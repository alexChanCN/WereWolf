package com.github.binarywang.demo.wechat.service;

import com.github.binarywang.demo.wechat.core.CoreService;
import com.github.binarywang.demo.wechat.domain.dto.RoomRequest;
import com.github.binarywang.demo.wechat.domain.dto.RoomStatus;
import com.github.binarywang.demo.wechat.domain.model.Room;

import java.util.List;

/**
 * Created by cs on 2017/8/5.
 */
public interface RoomService extends CoreService<Room,Integer> {

    //Integer reserve(Integer roomId,Integer seat);
    //Integer changeStatus(Integer roomId, Integer status);
    List<RoomStatus> getAllStatus(RoomRequest roomRequest);

}
