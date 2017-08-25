package com.github.binarywang.demo.wechat.controller.admin;

import com.github.binarywang.demo.wechat.domain.model.OrderInfo;
import com.github.binarywang.demo.wechat.service.OrderService;
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
@RequestMapping("/admin/order")
@Api(description = "预定管理模块")
public class AdminOrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/page")
    @ApiOperation(value="分页获取订单信息", notes="分页获取订单信息")
    public Page<OrderInfo> findByPage(@RequestParam Integer start, @RequestParam Integer size){
        return orderService.findByPage(start, size);
    }

    @GetMapping()
    @ApiOperation(value="获取所有订单信息", notes="获取所有订单信息")
    public List<OrderInfo> findAll(){
        return orderService.listAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value="根据id，获取该订单信息", notes="根据id，获取该订单信息")
    public OrderInfo getOne(@PathVariable long id){
        return orderService.get(id);
    }

    @PostMapping
    @ApiOperation(value="添加", notes="根据OrderInfo,添加订单记录")
    public String add(@RequestBody OrderInfo orderInfo){
        orderService.save(orderInfo);
        return "success";
    }

    @PutMapping
    @ApiOperation(value="修改", notes="根据OrderInfo,修改订单记录")
    public String update(@RequestBody OrderInfo orderInfo){
        orderService.update(orderInfo);
        return "success";
    }


    @DeleteMapping
    @ApiOperation(value="删除", notes="根据id,删除订单记录")
    public String delete(@PathVariable long id){
        orderService.delete(id);
        return "success";
    }


}
