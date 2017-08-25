package com.github.binarywang.demo.wechat.service.impl;

import com.github.binarywang.demo.wechat.domain.model.Room;
import com.github.binarywang.demo.wechat.domain.model.Seat;
import com.github.binarywang.demo.wechat.repository.SeatRepository;
import com.github.binarywang.demo.wechat.service.SeatService;
import com.github.binarywang.demo.wechat.utils.RoomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cs on 2017/8/5.
 */
@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    SeatRepository seatRepository;

    @Override
    public Integer save(Seat model) {
        seatRepository.save(model);
        return 1;
    }

    @Override
    public void saveOrUpdate(Seat model) {

    }

    @Override
    public void update(Seat model) {

    }

    @Override
    public void merge(Seat model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void deleteObject(Seat model) {

    }

    @Override
    public Seat get(Integer id) {
        return seatRepository.getOne(id);
    }

    @Override
    public int countAll() {
        return 0;
    }

    @Override
    public List<Seat> listAll() {
        return null;
    }

    @Override
    public Page<Seat> findByPage(Integer start, Integer size) {
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

    @Override
    public Seat findByIds(Integer roomId, Integer seatNo) {
        Room room = RoomUtils.getInstance(roomId);
        Seat seat = new Seat();
        seat.setRoom(room);
        seat.setSeatNo(seatNo);
        Seat result = seatRepository.findByRoomAndSeatNo(room,seatNo);
        return result;
    }

    @Override
    public Integer changeStatus(Integer seatId, Integer status) {
        Seat seat = seatRepository.findOne(seatId);
        seat.setStatus(status);
        return 1;
    }

    @Override
    public Integer changeStatus(Integer roomId, Integer seatNo, Integer status) {
        Seat seat = findByIds(roomId,seatNo);
        Integer presentStatus = seat.getStatus();
        if(status != presentStatus){
            seat.setStatus(status);
            seatRepository.save(seat);
        }
        else
            return 0;
        return 1;
    }
}
