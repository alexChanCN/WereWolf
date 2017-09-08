package com.cs.wechat.service.impl;

import com.cs.wechat.core.BaseServiceImpl;
import com.cs.wechat.domain.vo.OrderRequest;
import com.cs.wechat.domain.vo.RoomRequest;
import com.cs.wechat.domain.model.Member;
import com.cs.wechat.repository.OrderRepository;
import com.cs.wechat.service.ChanceService;
import com.cs.wechat.service.MemberService;
import com.cs.wechat.domain.vo.SeatRequest;
import com.cs.wechat.domain.model.OrderRecord;
import com.cs.wechat.domain.model.Room;
import com.cs.wechat.service.OrderService;
import com.cs.wechat.service.RoomService;
import com.cs.wechat.utils.DateUtils;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.cs.wechat.core.ProjectConstant.*;

/**
 * Created by cs on 2017/8/8.
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<OrderRecord, Long> implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    MemberService memberService;
    @Autowired
    RoomService roomService;
    @Autowired
    ChanceService chanceService;
    @Autowired
    WxMpService wxMpService;


    @Override
    public Integer reserve(OrderRequest request) {
        SeatRequest seatRequest = new SeatRequest();
        seatRequest.setDate(request.getDate());
        seatRequest.setPhase(request.getPhase());
        seatRequest.setRoomId(request.getRoomId());
        List<OrderRecord> orderRecords = findSeats(seatRequest);
        Integer current = orderRecords.size();
        Integer total = roomService.get(request.getRoomId()).getSeatCount();
        if (current < total) {
            Integer roomId = request.getRoomId();
            String openId = request.getOpenId();
            Member member = memberService.findByOpenId(openId);
            //System.out.println(member);
            Room room = new Room();
            room.setId(roomId);

            OrderRecord record = new OrderRecord();
            record.setMember(member);
            record.setDate(DateUtils.string2Date(request.getDate()));
            record.setNumber(request.getNumber());
            record.setRoom(room);
            record.setPhase(request.getPhase());
            record.setStatus(RESERVE);
            record.setType(request.getType());
            record.setCreateTime(new Date());
            orderRepository.save(record);
            return 1;
        } else
            return 0;
    }

    @Override
    public Integer confirm(Long id, String clerkName) throws WxErrorException {
        OrderRecord orderInfo = orderRepository.findOne(id);
        orderInfo.setStatus(CONFIRM);
        orderInfo.setClerkName(clerkName);
        orderInfo.setUpdateTime(new Date());
        orderRepository.save(orderInfo);

        String openId = orderInfo.getMember().getOpenId();
        chanceService.add(openId, SIGN_IN);
        memberService.changeChance(openId, SIGN_IN);
        WxMpKefuMessage message = WxMpKefuMessage
                .TEXT()
                .toUser(orderInfo.getMember().getOpenId())
                .content("恭喜预订成功")
                .build();
        wxMpService.getKefuService().sendKefuMessage(message);
        return 1;
    }

   /* @Override
    public List<Integer> findSeats(FindSeatInfo info) {
        Date date = DateUtils.string2Date(info.getDate());
        Room room = RoomUtils.getInstance(info.getRoomId());
        List<OrderInfo> orderInfos = orderRepository.findByDateAndRoomAndPhase(date,room,info.getPhase());
        List<Integer> ids = new ArrayList<Integer>();
        //Integer[] ids = new Integer[20];
        for(OrderInfo orderInfo : orderInfos){
            ids.add(orderInfo.getSeat().getSeatNo());
        }
        return ids;
    }*/

    @Override
    public List<OrderRecord> findByOpenId(String openId) {
        Member member = memberService.findByOpenId(openId);
        return orderRepository.findByMember(member);
    }

    @Override
    public List<OrderRecord> findByRequest(RoomRequest roomRequest) {
        OrderRecord orderRecord = new OrderRecord();
        Room room = new Room();
        room.setType(roomRequest.getType());
        orderRecord.setRoom(room);
        orderRecord.setDate(DateUtils.string2Date(roomRequest.getDate()));
        orderRecord.setPhase(roomRequest.getPhase());

        //创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching(); //构建对象

        //创建实例
        Example<OrderRecord> ex = Example.of(orderRecord, matcher);

        //查询
        return orderRepository.findAll(ex);
    }

    @Override
    public List<OrderRecord> findSeats(SeatRequest seatRequest) {
        Date date = DateUtils.string2Date(seatRequest.getDate());
        Integer id = seatRequest.getRoomId();
        Room room = new Room();
        room.setId(id);
        Integer phase = seatRequest.getPhase();
        return orderRepository.findByDateAndRoomAndPhase(date, room, phase);
    }

    @Override
    public List<OrderRecord> findByStatus(Integer status) {
        return orderRepository.findByStatus(status);
    }

    @Override
    public boolean updateById(Long id) {
        OrderRecord orderRecord = orderRepository.getOne(id);
        if (orderRecord != null) {
            orderRecord.setStatus(CONFIRM);
            orderRepository.save(orderRecord);
            return true;
        } else
            return false;

    }

    @Override
    public Page<OrderRecord> findAllDesc(Integer start,Integer size) {
        OrderRecord orderRecord = new OrderRecord();
        orderRecord.setStatus(1);
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return orderRepository.findAll(Example.of(orderRecord),new PageRequest(start,size,sort));
    }


}
