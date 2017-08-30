package com.github.binarywang.demo.wechat.service.impl;

import com.github.binarywang.demo.wechat.domain.dto.OrderRequest;
import com.github.binarywang.demo.wechat.domain.dto.RoomRequest;
import com.github.binarywang.demo.wechat.domain.dto.SeatRequest;
import com.github.binarywang.demo.wechat.domain.model.Member;
import com.github.binarywang.demo.wechat.domain.model.OrderRecord;
import com.github.binarywang.demo.wechat.domain.model.Room;
import com.github.binarywang.demo.wechat.repository.OrderRepository;
import com.github.binarywang.demo.wechat.service.*;
import com.github.binarywang.demo.wechat.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.github.binarywang.demo.wechat.core.ProjectConstant.*;

/**
 * Created by cs on 2017/8/8.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    MemberService memberService;
    @Autowired
    RoomService roomService;

    @Autowired
    ChanceService chanceService;


    @Override
    public Integer reserve(OrderRequest request) {
        Integer roomId = request.getRoomId();
        //Integer seatId = reserve.getSeatId();
        String openId = request.getOpenId();

        Member member = memberService.findByOpenId(openId);
        Room room = roomService.get(roomId);
        //Seat seat = seatService.findByIds(roomId,seatId);
        //Seat seat = seatService.get(seatId);
        //roomService.changeStatus(roomId,1);
        //seatService.changeStatus(seatId,1);

        OrderRecord record = new OrderRecord();
        record.setMember(member);
        //orderInfo.setSeat(seat);
        record.setDate(DateUtils.string2Date(request.getDate()));
        record.setNumber(request.getNumber());
        record.setRoom(room);
        record.setPhase(request.getPhase());
        record.setStatus(RESERVE);
        record.setCreateTime(new Date());
        orderRepository.save(record);
        return 1;
    }

    @Override
    public Integer confirm(Long id, String clerkName) {
        OrderRecord orderInfo = orderRepository.findOne(id);
        orderInfo.setStatus(CONFIRM);
        orderInfo.setClerkName(clerkName);
        orderInfo.setUpdateTime(new Date());
        orderRepository.save(orderInfo);

        String openId = orderInfo.getMember().getOpenId();
        //Integer roomId = orderInfo.getRoom().getId();
        //Integer seatId = orderInfo.getSeat().getId();
        //roomService.changeStatus(roomId,3);
        //seatService.changeStatus(seatId,3);
        chanceService.add(openId, SIGN_IN);
        memberService.changeChance(openId, SIGN_IN);
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
        Integer type = roomRequest.getType();

        OrderRecord orderRecord = new OrderRecord();
        Room room = new Room();
        room.setType(roomRequest.getType());


        orderRecord.setRoom(room);

        orderRecord.setDate(DateUtils.string2Date(roomRequest.getDate()));
        orderRecord.setStatus(RESERVE);
        orderRecord.setPhase(roomRequest.getPhase());


        //创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching(); //构建对象
        //.withIgnorePaths("focus");  //忽略属性：是否关注。因为是基本类型，需要忽略掉

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
    public Long save(OrderRecord model) {
        return null;
    }

    @Override
    public void saveOrUpdate(OrderRecord model) {

    }

    @Override
    public void update(OrderRecord model) {

    }

    @Override
    public void merge(OrderRecord model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteObject(OrderRecord model) {

    }

    @Override
    public OrderRecord get(Long id) {
        return null;
    }

    @Override
    public int countAll() {
        return 0;
    }

    @Override
    public List<OrderRecord> listAll() {
        return null;
    }

    @Override
    public Page<OrderRecord> findByPage(Integer start, Integer size) {
        return null;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public void clear() {

    }
}
