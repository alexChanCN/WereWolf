package com.github.binarywang.demo.wechat.service.impl;

import com.github.binarywang.demo.wechat.domain.model.Prize;
import com.github.binarywang.demo.wechat.repository.PrizeRepository;
import com.github.binarywang.demo.wechat.service.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cs on 2017/8/29.
 */
@Service
public class PrizeServiceImpl implements PrizeService {

    @Autowired
    PrizeRepository prizeRepository;
    @Override
    public Integer save(Prize model) {
        prizeRepository.save(model);
        return 1;
    }

    @Override
    public void saveOrUpdate(Prize model) {

    }

    @Override
    public void update(Prize model) {

    }

    @Override
    public void merge(Prize model) {

    }

    @Override
    public void delete(Integer id) {
        prizeRepository.delete(id);
    }

    @Override
    public void deleteObject(Prize model) {

    }

    @Override
    public Prize get(Integer id) {
        return null;
    }

    @Override
    public int countAll() {
        return 0;
    }

    @Override
    public List<Prize> listAll() {
        return prizeRepository.findAll();
    }

    @Override
    public Page<Prize> findByPage(Integer start, Integer size) {
        return null;
    }

    @Override
    public boolean exists(Integer id) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public void clear() {

    }
}
