package com.github.binarywang.demo.wechat.service;

import com.github.binarywang.demo.wechat.domain.model.Seat;

/**
 * Created by cs on 2017/8/5.
 */
public interface SeatService extends CoreService<Seat,Integer>{
    Seat findByIds(Integer roomId, Integer seatNo);
    Integer changeStatus(Integer seatId ,Integer status);
    Integer changeStatus(Integer roomId, Integer seatNo ,Integer status);

    //List<RoomStatus> getAllStatus(Date date, Integer phase);
}
