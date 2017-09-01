package com.cs.wechat.controller.admin;

import com.cs.wechat.service.RoomService;
import com.cs.wechat.domain.model.Room;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by cs on 2017/8/8.
 */
@RestController
@RequestMapping("/admin/room")
@Api(description = "房间管理模块" )
public class AdminRoomController {

    @Autowired
    RoomService roomService;

    @GetMapping("/page")
    @ApiOperation(value="分页获取房间信息", notes="分页获取房间信息")
    public Page<Room> findByPage(@RequestHeader("Authorization")String authorization,@RequestParam Integer start, @RequestParam Integer size){
        return roomService.findByPage(start, size);
    }

    @GetMapping()
    @ApiOperation(value="获取所有房间信息", notes="获取所有房间信息")
    public List<Room> findAll(@RequestHeader("Authorization")String authorization){
        return roomService.listAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value="根据id，获取该房间信息", notes="根据id，获取该房间信息")
    public Room getOne(@RequestHeader("Authorization")String authorization,@PathVariable Integer id){
        return roomService.get(id);
    }

    @PostMapping
    @ApiOperation(value="添加", notes="根据Room,添加房间信息")
    public String add(@RequestHeader("Authorization")String authorization,@RequestBody Room room){
        roomService.save(room);
        return "success";
    }

    @PutMapping
    @ApiOperation(value="修改", notes="根据Teacher,修改教练信息")
    public String update(@RequestHeader("Authorization")String authorization,@RequestBody Room room){
        roomService.update(room);
        return "success";
    }


    @DeleteMapping
    @ApiOperation(value="删除", notes="根据id,删除教练信息")
    public String delete(@RequestHeader("Authorization")String authorization,@PathVariable Integer id){
        roomService.delete(id);
        return "success";
    }
}
