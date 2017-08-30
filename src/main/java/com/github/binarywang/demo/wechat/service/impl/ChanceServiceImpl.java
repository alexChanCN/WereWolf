package com.github.binarywang.demo.wechat.service.impl;

import com.github.binarywang.demo.wechat.domain.model.Chance;
import com.github.binarywang.demo.wechat.repository.ChanceRepository;
import com.github.binarywang.demo.wechat.service.ChanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import static com.github.binarywang.demo.wechat.core.ProjectConstant.*;
/**
 * Created by cs on 2017/8/9.
 */
@Service
public class ChanceServiceImpl implements ChanceService {

    @Autowired
    ChanceRepository chanceRepository;


    @Override
    public Long save(Chance model) {
        return null;
    }

    @Override
    public void saveOrUpdate(Chance model) {

    }

    @Override
    public void update(Chance model) {

    }

    @Override
    public void merge(Chance model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteObject(Chance model) {

    }

    @Override
    public Chance get(Long id) {
        return null;
    }

    @Override
    public int countAll() {
        return 0;
    }

    @Override
    public List<Chance> listAll() {
        return null;
    }

    @Override
    public Page<Chance> findByPage(Integer start, Integer size) {
        return null;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public void clear() {

    }

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
