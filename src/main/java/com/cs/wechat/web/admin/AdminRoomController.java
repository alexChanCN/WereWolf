package com.cs.wechat.web.admin;

import com.cs.wechat.core.BaseController;
import com.cs.wechat.core.ResultBean;
import com.cs.wechat.domain.entity.Price;
import com.cs.wechat.domain.entity.Room;
import com.cs.wechat.service.PriceService;
import com.cs.wechat.service.RoomService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by cs on 2017/8/8.
 */
@RestController
@RequestMapping("/admin/room")
@Api(description = "房间管理模块" )
public class AdminRoomController extends BaseController<Room,Integer>{

    @Autowired
    RoomService roomService;
    @Autowired
    PriceService priceService;

    @PostMapping("/prices")
    public ResultBean addRoomAndPrice(@RequestHeader("Authorization")String authorization,@RequestBody Room room){

        Integer id = roomService.save(room);
        Room newRoom = new Room();
        newRoom.setId(id);

        List<Price> prices = new ArrayList<>();
        for(int i =0;i<4;i++){
            Price price = new Price();
            price.setPhase(i+1);
            price.setWeekend(0f);
            price.setWorkday(0f);
            price.setRoom(newRoom);
            prices.add(price);
        }
        priceService.save(prices);
        return new ResultBean(ResultBean.SUCCESS);
    }

}
