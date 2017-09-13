package com.cs.wechat.service;

import com.cs.wechat.core.BaseService;
import com.cs.wechat.pojo.vo.RoomStatus;
import com.cs.wechat.domain.entity.Room;

import java.util.List;

/**
 * Created by cs on 2017/8/5.
 */
public interface RoomService extends BaseService<Room,Integer> {

    List<RoomStatus> getAllStatus(String date, Integer phase, Integer type);



}
