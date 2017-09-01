package com.cs.wechat.service.impl;

import com.cs.wechat.core.BaseServiceImpl;
import com.cs.wechat.domain.model.Chance;
import com.cs.wechat.repository.ChanceRepository;
import com.cs.wechat.service.ChanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import static com.cs.wechat.core.ProjectConstant.*;
/**
 * Created by cs on 2017/8/9.
 */
@Service
public class ChanceServiceImpl extends BaseServiceImpl<Chance,Long> implements ChanceService {

    @Autowired
    ChanceRepository chanceRepository;


    @Override
    public Integer add(String openId,Integer reason) {
        Chance chance = new Chance();
        chance.setOpenId(openId);
        chance.setReason(reason);
        chance.setTime(new Date());
        chance.setCount(1);         //增加一次机会
        chanceRepository.save(chance);
        return 1;
    }

    @Override
    public Integer reduce(String openId) {
        Chance chance = new Chance();
        chance.setOpenId(openId);
        chance.setReason(LUCKY_DRAW);
        chance.setTime(new Date());
        chance.setCount(-1);         //减少一次机会
        chanceRepository.save(chance);
        return -1;
    }

    @Override
    public List<Chance> findByOpenId(String openId) {
        return chanceRepository.findByOpenId(openId);
    }
}
