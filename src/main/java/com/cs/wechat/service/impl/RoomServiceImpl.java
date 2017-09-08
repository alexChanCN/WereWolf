package com.cs.wechat.service.impl;

import com.cs.wechat.core.BaseServiceImpl;
import com.cs.wechat.repository.RoomRepository;
import com.cs.wechat.domain.vo.RoomRequest;
import com.cs.wechat.domain.vo.RoomStatus;
import com.cs.wechat.domain.model.OrderRecord;
import com.cs.wechat.domain.model.Room;
import com.cs.wechat.service.OrderService;
import com.cs.wechat.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.cs.wechat.core.ProjectConstant.INTEGRITY;
import static com.cs.wechat.core.ProjectConstant.SCATTER;

/**
 * Created by cs on 2017/8/5.
 */
@Service
public class RoomServiceImpl extends BaseServiceImpl<Room,Integer> implements RoomService {

    private static Integer COUNT_ALL = null;
    private static Integer COUNT_INTERGRITY = null;
    private static Integer COUNT_SCATTER = null;
    @Autowired
    RoomRepository roomRepository;

    @Autowired
    OrderService orderService;

    @Override
    public Integer getIntegrityCount() {
        if (COUNT_INTERGRITY == null)
            COUNT_INTERGRITY = roomRepository.findByType(INTEGRITY).size();
        return COUNT_INTERGRITY;
    }

    @Override
    public Integer getScatterCount() {
        if (COUNT_SCATTER == null)
            COUNT_SCATTER = roomRepository.findByType(SCATTER).size();
        return COUNT_SCATTER;
    }

    @Override
    public Integer getAllCount() {
        if (COUNT_ALL == null)
            COUNT_ALL = roomRepository.findAll().size();
        return COUNT_ALL;
    }


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
            roomStatus.setPrice(room.getPrice());
            roomStatus.setProfile(room.getProfile());
            roomStatuses.add(roomStatus);
        }

        List<OrderRecord> orderRecords = orderService.findByRequest(roomRequest);
        for (OrderRecord orderRecord : orderRecords) {
            Integer index;
            if (orderRecord.getRoom().getType() == 1)
                index = orderRecord.getRoom().getId() - 1;
            else
                index = orderRecord.getRoom().getId() - 1 - getIntegrityCount();

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


}
