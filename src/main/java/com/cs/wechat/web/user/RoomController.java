package com.cs.wechat.web.user;

import com.cs.wechat.pojo.vo.RoomStatus;
import com.cs.wechat.domain.entity.OrderRecord;
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

    @GetMapping
    @ApiOperation(value="获取所有房间状态", notes="获取房间总座位数和剩余座位数,type = 0 散房,type = 1 整房")
    public List<RoomStatus> getStatus(@RequestParam String date,@RequestParam Integer phase,@RequestParam Integer type){
        return roomService.getAllStatus(date,phase,type);
    }

    @GetMapping("/seat")
    @ApiOperation(value="获取指定房间状态", notes="获取预定房间人的信息")
    public List<OrderRecord> getOne(@RequestParam String date,@RequestParam Integer roomId,@RequestParam Integer phase){
        return orderService.findSeats(date,roomId,phase);
    }
}
