package com.cs.wechat.service;

import com.cs.wechat.core.BaseService;
import com.cs.wechat.domain.model.Chance;

import java.util.List;

/**
 * Created by cs on 2017/8/9.
 */
public interface ChanceService extends BaseService<Chance,Long> {
    Integer add(String openId,Integer reason);
    Integer reduce(String openId);
    List<Chance> findByOpenId(String openId);
}
