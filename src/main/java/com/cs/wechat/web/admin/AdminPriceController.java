package com.cs.wechat.web.admin;


import com.cs.wechat.core.ResultBean;
import com.cs.wechat.domain.entity.Price;
import com.cs.wechat.service.PriceService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by cs on 2017/9/12.
 */
@RestController
@RequestMapping("/admin/price")
@Api(description = "价格管理模块")
public class AdminPriceController{

    @Autowired
    PriceService priceService;

    @GetMapping("/roomId/{roomId}")
    public ResultBean<List<Price>> listByRoomId(@PathVariable Integer roomId){
        return new ResultBean<>(priceService.findByRoom(roomId));
    }

    @PutMapping("/all")
    public ResultBean updateAll(@RequestHeader("Authorization")String authorization,@RequestBody List<Price> prices){
        priceService.save(prices);
        return new ResultBean(ResultBean.SUCCESS);
    }
}
