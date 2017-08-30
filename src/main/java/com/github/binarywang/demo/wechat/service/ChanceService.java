package com.github.binarywang.demo.wechat.service;

import com.github.binarywang.demo.wechat.core.CoreService;
import com.github.binarywang.demo.wechat.domain.model.Chance;

import java.util.List;

/**
 * Created by cs on 2017/8/9.
 */
public interface ChanceService extends CoreService<Chance,Long> {
    Integer add(String openId,Integer reason);
    Integer reduce(String openId);
    List<Chance> findByOpenId(String openId);
}
