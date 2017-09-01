package com.cs.wechat.service;

import com.cs.wechat.core.BaseService;
import com.cs.wechat.domain.dto.RoomRequest;
import com.cs.wechat.domain.dto.RoomStatus;
import com.cs.wechat.domain.model.Room;

import java.util.List;

/**
 * Created by cs on 2017/8/5.
 */
public interface RoomService extends BaseService<Room,Integer> {

    Integer getIntegrityCount();
    Integer getScatterCount();
    Integer getAllCount();
    List<RoomStatus> getAllStatus(RoomRequest roomRequest);



}
