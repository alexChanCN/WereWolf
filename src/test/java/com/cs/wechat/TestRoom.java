package com.cs.wechat;

import com.cs.wechat.pojo.vo.RoomStatus;
import com.cs.wechat.domain.entity.Room;
import com.cs.wechat.service.RoomService;
import com.cs.wechat.utils.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by cs on 2017/8/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WxMpDemoApplication.class)
public class TestRoom {
    @Autowired
    RoomService roomService;

    @Test
    public void testAdd() {
        for (int i = 1; i <= 8; i++) {
            Room r = new Room();
            r.setName(i + "号房间");
            r.setPicUrl("xxxxx");
            r.setSeatCount(12);
            r.setType(1);
            //roomService.save(r);
        }
    }

   @Test
    public void  testFind2(){
        List<RoomStatus> roomStatuses = roomService.getAllStatus("2017-08-30",1,1);
        System.out.println(JsonUtils.toJson(roomStatuses));
    }
    @Test
    public void find(){
        System.out.println(roomService.get(1).getName());
    }
/*
    @Test
    public void seeJson(){
        String date = "2017-8-10";
        RoomRequest roomRequest = new RoomRequest(date,1,1);
        System.out.println(JsonUtils.toJson(roomRequest));
    }*/
}
