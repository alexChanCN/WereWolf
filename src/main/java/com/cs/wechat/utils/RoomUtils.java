package com.cs.wechat.utils;

import com.cs.wechat.domain.model.Room;

/**
 * Created by cs on 2017/8/10.
 */
public class RoomUtils {
    private static Room classInstance = new Room();

    public static Room getInstance() {
        return classInstance;
    }
    public static Room getInstance(Integer id) {
        classInstance.setId(id);
        return classInstance;
    }
}
