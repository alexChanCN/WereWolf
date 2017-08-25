package com.github.binarywang.demo.wechat.controller.user;

import com.github.binarywang.demo.wechat.domain.dto.ReserveInfo;
import com.github.binarywang.demo.wechat.domain.model.OrderInfo;
import com.github.binarywang.demo.wechat.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cs on 2017/8/8.
 */
@RestController
@RequestMapping("/user/order")
@Api(description = "预定模块")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    @ApiOperation(value="预定", notes="填写registerInfo信息，预定房间、座位")
    public String add(@RequestBody ReserveInfo reserveInfo){
        orderService.reserve(reserveInfo);
        return "success";
    }

    @GetMapping("{openId}")
    @ApiOperation(value="获取订单信息", notes="根据openId，获取该会员的所有订单信息")
    public List<OrderInfo> listAll(@PathVariable String openId){
        return orderService.findByOpenId(openId);
    }
    /*@PutMapping
    public String verify(@RequestParam("id") Long id,@RequestParam("name") String name){
        orderService.verify(id,name);
        return "success";
    }*/


}
