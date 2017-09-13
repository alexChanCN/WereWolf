package com.cs.wechat.service;

import com.cs.wechat.core.BaseService;
import com.cs.wechat.domain.entity.Price;

import java.util.List;

/**
 * Created by cs on 2017/9/12.
 */
public interface PriceService extends BaseService<Price,Integer>{

    List<Price> findByRoom(Integer roomId);

    Float findOnePrice(String date,Integer phase,Integer roomId);

}
