package com.github.binarywang.demo.wechat.service.impl;

import com.github.binarywang.demo.wechat.domain.dto.RoomRequest;
import com.github.binarywang.demo.wechat.domain.dto.RoomStatus;
import com.github.binarywang.demo.wechat.domain.model.OrderRecord;
import com.github.binarywang.demo.wechat.domain.model.PrizeRecord;
import com.github.binarywang.demo.wechat.domain.model.Room;
import com.github.binarywang.demo.wechat.repository.RoomRepository;
import com.github.binarywang.demo.wechat.service.OrderService;
import com.github.binarywang.demo.wechat.service.RoomService;
import com.github.binarywang.demo.wechat.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.github.binarywang.demo.wechat.core.ProjectConstant.INTEGRITY;
import static com.github.binarywang.demo.wechat.core.ProjectConstant.ROOM_COUNT;

/**
 * Created by cs on 2017/8/5.
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    OrderService orderService;

    @Override
    public Integer save(Room model) {
        roomRepository.save(model);
        return 1;
    }

    @Override
    public void saveOrUpdate(Room model) {

    }

    @Override
    public void update(Room model) {
        roomRepository.save(model);
    }

    @Override
    public void merge(Room model) {

    }

    @Override
    public void delete(Integer id) {
        roomRepository.delete(id);
    }

    @Override
    public void deleteObject(Room model) {

    }

    @Override
    public Room get(Integer id) {
        return roomRepository.findOne(id);
    }

    @Override
    public int countAll() {
        return 0;
    }

    @Override
    public List<Room> listAll() {
        return roomRepository.findAll();
    }

    @Override
    public Page<Room> findByPage(Integer start, Integer size) {
        return null;
    }

    @Override
    public boolean exists(Integer id) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public void clear() {

    }

    /*@Override
    public Integer changeStatus(Integer roomId, Integer status) {
        Room room = roomRepository.findOne(roomId);
        Integer presentStatus = room.getStatus();
        if(status != presentStatus){
            room.setStatus(status);
            roomRepository.save(room);
        }
        else
            return 0;
        return 1;
    }*/


    @Override
    public List<RoomStatus> getAllStatus(RoomRequest roomRequest) {
        List<RoomStatus> roomStatuses = new ArrayList<RoomStatus>();

        List<Room> rooms = roomRepository.findByType(roomRequest.getType());

        for (Room room : rooms) {
            RoomStatus roomStatus = new RoomStatus();
            Integer total = room.getSeatCount();
            roomStatus.setNo(room.getId());
            roomStatus.setCurrent(0);
            roomStatus.setTotal(total);
            roomStatus.setPicUrl(room.getPicUrl());
            roomStatuses.add(roomStatus);
        }

        List<OrderRecord> orderRecords = orderService.findByRequest(roomRequest);
        for (OrderRecord orderRecord : orderRecords) {
            Integer index = orderRecord.getRoom().getId() - 1;
            RoomStatus roomStatus = roomStatuses.get(index);
            roomStatus.setCurrent(roomStatus.getCurrent() + orderRecord.getNumber());

        }

        return roomStatuses;
    }

    /*@Override
    public Integer reserve(Integer roomId ,Integer seatNo,Integer status) {
        Room room = roomRepository.findOne(roomId);
        if (room.getStatus() == 1){
            if(room.getType() ==1)
                room.setStatus(0);
            else if(room.getType() ==2)
                seatService.findByIds(roomId ,seatNo);
                //seat操作
        }
        else
            return 0;
        return 1;
    }*/
}
