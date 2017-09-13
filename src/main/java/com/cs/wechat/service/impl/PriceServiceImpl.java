package com.cs.wechat.service.impl;

import com.cs.wechat.core.BaseServiceImpl;
import com.cs.wechat.domain.repository.PriceRepository;
import com.cs.wechat.domain.entity.Price;
import com.cs.wechat.domain.entity.Room;
import com.cs.wechat.exception.CheckException;
import com.cs.wechat.service.PriceService;
import com.cs.wechat.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cs on 2017/9/12.
 */
@Service
public class PriceServiceImpl extends BaseServiceImpl<Price, Integer> implements PriceService {

    @Autowired
    PriceRepository priceRepository;

    @Override
    public List<Price> findByRoom(Integer roomId) {
        Room room = new Room();
        room.setId(roomId);
        return priceRepository.findByRoom(room);
    }

    @Override
    public Float findOnePrice(String date, Integer phase, Integer roomId) {

        Room room = new Room();
        room.setId(roomId);
        Price price = new Price();
        price.setRoom(room);
        price.setPhase(phase);
        Example<Price> ex = Example.of(price);
        List<Price> prices = priceRepository.findAll(ex);
        if (prices.size() == 0)
            throw new CheckException("Price未设置",new NullPointerException());
        else
            price = prices.get(0);
        int day = 0;
        try {
            day = DateUtils.dayForWeek(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (day > 0 && day < 5)
            return price.getWorkday();
        else
            return price.getWeekend();
    }

}
