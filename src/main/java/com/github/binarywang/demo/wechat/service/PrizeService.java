package com.github.binarywang.demo.wechat.service;

import com.github.binarywang.demo.wechat.domain.model.Prize;

import java.util.List;

/**
 * Created by cs on 2017/8/11.
 */
public interface PrizeService extends CoreService<Prize,Integer> {
    Integer add(String openId,Integer prizeId);

    List<Prize> listMine(String openId, Integer status);

    List<Prize> findByName(String name);

    List<Prize> findByStatus(Integer status);

    void  updateById(Integer id);


}
