package com.cs.wechat;

import com.cs.wechat.domain.repository.PriceRepository;
import com.cs.wechat.domain.entity.Price;
import com.cs.wechat.domain.entity.Room;
import com.cs.wechat.service.PriceService;
import com.cs.wechat.utils.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by cs on 2017/9/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPrice {
    @Autowired
    PriceRepository priceRepository;
    @Autowired
    PriceService priceService;


    @Test
    public void testAdd(){
        Room room = new Room();
        room.setId(1);
        Price price = new Price();
        price.setRoom(room);
        price.setPhase(1);
        price.setWeekend(400f);
        price.setWorkday(300f);
        System.out.println(JsonUtils.toJson(priceRepository.save(price)));
    }

    @Test
    public void testList(){
        System.out.println(priceService.findByRoom(1).toString());
    }
}
