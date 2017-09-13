package com.cs.wechat.service.impl;

import com.cs.wechat.core.BaseServiceImpl;
import com.cs.wechat.domain.repository.RoomRepository;
import com.cs.wechat.service.PriceService;
import com.cs.wechat.pojo.vo.RoomStatus;
import com.cs.wechat.domain.entity.OrderRecord;
import com.cs.wechat.domain.entity.Room;
import com.cs.wechat.service.OrderService;
import com.cs.wechat.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cs on 2017/8/5.
 */
@Service
public class RoomServiceImpl extends BaseServiceImpl<Room, Integer> implements RoomService {

    private static Integer COUNT_ALL = null;
    private static Integer COUNT_INTERGRITY = null;
    private static Integer COUNT_SCATTER = null;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    PriceService priceService;
    @Autowired
    OrderService orderService;

    @Override
    public List<RoomStatus> getAllStatus(String date, Integer phase, Integer type) {
        List<RoomStatus> roomStatuses = new ArrayList<RoomStatus>();
        List<Room> rooms = roomRepository.findByType(type);
        for (Room room : rooms) {
            RoomStatus roomStatus = new RoomStatus();
            Integer total = room.getSeatCount();
            roomStatus.setNo(room.getId());
            roomStatus.setName(room.getName());
            roomStatus.setCurrent(0);
            roomStatus.setTotal(total);
            roomStatus.setPicUrl(room.getPicUrl());
            float price = priceService.findOnePrice(date,phase,room.getId());
            roomStatus.setPrice(price);
            roomStatus.setProfile(room.getProfile());
            roomStatuses.add(roomStatus);
        }

        List<OrderRecord> orderRecords = orderService.findByRequest(date, phase, type);
        for (OrderRecord orderRecord : orderRecords) {
            int index = orderRecord.getRoom().getId();
            for(RoomStatus roomStatus:roomStatuses){
                if(index == roomStatus.getNo())
                    roomStatus.setCurrent(roomStatus.getCurrent() + orderRecord.getNumber());
            }

        }
        return roomStatuses;
    }

}
