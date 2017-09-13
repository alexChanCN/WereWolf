package com.cs.wechat.web.admin;

import com.cs.wechat.core.BaseController;
import com.cs.wechat.core.ResultBean;
import com.cs.wechat.domain.entity.Member;
import com.cs.wechat.domain.entity.OrderRecord;
import com.cs.wechat.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cs on 2017/8/8.
 */
@RestController
@RequestMapping("/admin/order")
@Api(description = "预定管理模块")
public class AdminOrderController extends BaseController<OrderRecord,Long>{

    @Autowired
    OrderService orderService;

    @GetMapping("/name")
    @ApiOperation(value="根据姓名，分页查询", notes="根据姓名，分页查询")
    public Page<OrderRecord> findByName(@RequestParam String name, @RequestParam Integer start, @RequestParam Integer size){
        OrderRecord orderRecord = new OrderRecord();
        Member member = new Member();
        member.setName(name);
        orderRecord.setMember(member);
        return orderService.findByMatcher(orderRecord,"member.name",new PageRequest(start,size));
    }

    @GetMapping("/newOrder")
    @ApiOperation(value="倒序获取所有还未确定的订单", notes="倒序获取所有还未确定的订单")
    public Page<OrderRecord> findNewOder(@RequestParam Integer start, @RequestParam Integer size){
        return orderService.findAllDesc(start, size);
    }


    @PutMapping("/confirm")
    @ApiOperation(value = "确认预定", notes = "根据ID,确认预定成功")
    public ResultBean confirm(@RequestHeader("Authorization")String authorization, @RequestParam Long id, @RequestParam String name) throws WxErrorException {
        if (orderService.confirm(id,name).equals(1)){
            return new ResultBean(ResultBean.SUCCESS);
        }
        else
            return new ResultBean(ResultBean.FAIL);
    }



}
