package com.github.binarywang.demo.wechat.service;

import com.github.binarywang.demo.wechat.domain.dto.RoomStatus;
import com.github.binarywang.demo.wechat.domain.model.Room;

import java.util.Date;
import java.util.List;

/**
 * Created by cs on 2017/8/5.
 */
public interface RoomService extends CoreService<Room,Integer>{

    //Integer reserve(Integer roomId,Integer seat);
    Integer changeStatus(Integer roomId, Integer status);

    List<RoomStatus> getAllStatus(Date date, Integer phase);
}
