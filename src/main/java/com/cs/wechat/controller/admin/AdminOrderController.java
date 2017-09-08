package com.cs.wechat.controller.admin;

import com.cs.wechat.domain.model.Member;
import com.cs.wechat.domain.model.OrderRecord;
import com.cs.wechat.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cs on 2017/8/8.
 */
@RestController
@RequestMapping("/admin/order")
@Api(description = "预定管理模块")
public class AdminOrderController {

    @Autowired
    OrderService orderService;


    @GetMapping("/page")
    @ApiOperation(value="分页获取订单信息", notes="分页获取订单信息")
    public Page<OrderRecord> findByPage(@RequestParam Integer start, @RequestParam Integer size){
        return orderService.findByPage(start, size);
    }

    @GetMapping("/name")
    @ApiOperation(value="根据姓名，分页查询", notes="根据姓名，分页查询")
    public Page<OrderRecord> findByName(@RequestParam String name, @RequestParam Integer start, @RequestParam Integer size){
        OrderRecord orderRecord = new OrderRecord();
        Member member = new Member();
        member.setName(name);
        orderRecord.setMember(member);
        return orderService.findByMatcher(orderRecord,"member.name",new PageRequest(start,size));
    }

    @GetMapping()
    @ApiOperation(value="倒序获取所有还未确定的订单", notes="倒序获取所有还未确定的订单")
    public Page<OrderRecord> findAll(@RequestParam Integer start, @RequestParam Integer size){
        return orderService.findAllDesc(start, size);
    }

    @GetMapping("/{id}")
    @ApiOperation(value="根据id，获取该订单信息", notes="根据id，获取该订单信息")
    public OrderRecord getOne(@PathVariable long id){
        return orderService.get(id);
    }

    @PostMapping
    @ApiOperation(value="添加", notes="根据OrderInfo,添加订单记录")
    public String add(@RequestHeader("Authorization")String authorization,@RequestBody OrderRecord orderInfo){
        orderService.save(orderInfo);
        return "success";
    }

/*    @PutMapping
    @ApiOperation(value="修改", notes="根据OrderInfo,修改订单记录")
    public String update(@RequestHeader("Authorization")String authorization,@RequestBody OrderRecord orderInfo){
        orderService.update(orderInfo);
        return "success";
    }*/

    @PutMapping
    @ApiOperation(value = "确认预定", notes = "根据ID,确认预定成功")
    public String confirm(@RequestHeader("Authorization")String authorization,@RequestParam Long id,@RequestParam String name) throws WxErrorException {
        if (orderService.confirm(id,name).equals(1)){
            return "success";
        }
        else
            return "false";
    }


    @DeleteMapping("{id}")
    @ApiOperation(value="删除", notes="根据id,删除订单记录")
    public String delete(@RequestHeader("Authorization")String authorization,@PathVariable long id){
        orderService.delete(id);
        return "success";
    }

}
