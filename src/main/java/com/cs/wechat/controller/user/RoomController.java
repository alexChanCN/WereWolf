package com.cs.wechat.controller.user;

import com.cs.wechat.domain.dto.RoomRequest;
import com.cs.wechat.domain.dto.RoomStatus;
import com.cs.wechat.domain.dto.SeatRequest;
import com.cs.wechat.domain.model.OrderRecord;
import com.cs.wechat.service.OrderService;
import com.cs.wechat.service.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cs on 2017/8/27.
 */
@RestController
@RequestMapping("/user/room")
@Api(description = "房间模块")
public class RoomController {
    @Autowired
    RoomService roomService;

    @Autowired
    OrderService orderService;

    @PostMapping
    @ApiOperation(value="获取所有房间状态", notes="获取房间总座位数和剩余座位数,type = 0 散房,type = 1 整房")
    public List<RoomStatus> getStatus(@RequestBody RoomRequest roomRequest){
        return roomService.getAllStatus(roomRequest);
    }

    @PostMapping("/seat")
    @ApiOperation(value="获取指定房间状态", notes="获取预定房间人的信息")
    public List<OrderRecord> getOne(@RequestBody SeatRequest seatRequest){
        return orderService.findSeats(seatRequest);
    }
}
