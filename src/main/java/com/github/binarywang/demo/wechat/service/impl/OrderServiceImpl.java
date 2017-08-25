package com.github.binarywang.demo.wechat.service.impl;

import com.github.binarywang.demo.wechat.domain.dto.FindSeatInfo;
import com.github.binarywang.demo.wechat.domain.dto.ReserveInfo;
import com.github.binarywang.demo.wechat.domain.model.Member;
import com.github.binarywang.demo.wechat.domain.model.OrderInfo;
import com.github.binarywang.demo.wechat.domain.model.Room;
import com.github.binarywang.demo.wechat.domain.model.Seat;
import com.github.binarywang.demo.wechat.repository.OrderRepository;
import com.github.binarywang.demo.wechat.service.*;
import com.github.binarywang.demo.wechat.utils.DateUtils;
import com.github.binarywang.demo.wechat.utils.RoomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by cs on 2017/8/8.
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    MemberService memberService;
    @Autowired
    RoomService roomService;
    @Autowired
    SeatService seatService;
    @Autowired
    ChanceService awardService;

    @Override
    public Long save(OrderInfo model) {
        return null;
    }

    @Override
    public void saveOrUpdate(OrderInfo model) {

    }

    @Override
    public void update(OrderInfo model) {

    }

    @Override
    public void merge(OrderInfo model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteObject(OrderInfo model) {

    }

    @Override
    public OrderInfo get(Long id) {
        return null;
    }

    @Override
    public int countAll() {
        return 0;
    }

    @Override
    public List<OrderInfo> listAll() {
        return null;
    }

    @Override
    public Page<OrderInfo> findByPage(Integer start, Integer size) {
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


    @Override
    public Integer reserve(ReserveInfo reserve) {
        Integer roomId = reserve.getRoomId();
        Integer seatId = reserve.getSeatId();
        String openId = reserve.getOpenId();
        Integer phase = reserve.getPhase();

        Member member = memberService.findByOpenId(openId);
        Room room = roomService.get(roomId);
        //Seat seat = seatService.findByIds(roomId,seatId);
        Seat seat = seatService.get(seatId);
        roomService.changeStatus(roomId,1);
        seatService.changeStatus(seatId,1);

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setMember(member);
        orderInfo.setSeat(seat);
        orderInfo.setRoom(room);
        orderInfo.setPhase(phase);
        orderInfo.setStatus(1);
        orderInfo.setCreateTime(new Date());
        orderRepository.save(orderInfo);
        return 1;
    }

    @Override
    public Integer verify(Long id, String clerkName) {
        OrderInfo orderInfo = orderRepository.findOne(id);
        orderInfo.setStatus(3);
        orderInfo.setClerkName(clerkName);
        orderInfo.setUpdateTime(new Date());
        orderRepository.save(orderInfo);

        String openId = orderInfo.getMember().getOpenId();
        Integer roomId = orderInfo.getRoom().getId();
        Integer seatId = orderInfo.getSeat().getId();
        roomService.changeStatus(roomId,3);
        seatService.changeStatus(seatId,3);
        awardService.add(openId,1,1);
        memberService.changeChance(openId,1);
        return 1;
    }

    @Override
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
    }

    @Override
    public List<OrderInfo> findByOpenId(String openId) {
        Member member = memberService.findByOpenId(openId);
        return orderRepository.findByMember(member);
    }
}
