package com.github.binarywang.demo.wechat.service.impl;

import com.github.binarywang.demo.wechat.domain.model.AnswerRecord;
import com.github.binarywang.demo.wechat.repository.AnswerRecordRepository;
import com.github.binarywang.demo.wechat.service.AnswerRecordService;
import com.github.binarywang.demo.wechat.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by cs on 2017/8/27.
 */
@Service
public class AnswerRecordServiceImpl implements AnswerRecordService {

    @Autowired
    AnswerRecordRepository answerRecordRepository;
    @Override
    public Integer save(AnswerRecord model) {
        answerRecordRepository.save(model);
        return 1;
    }

    @Override
    public void saveOrUpdate(AnswerRecord model) {

    }

    @Override
    public void update(AnswerRecord model) {

    }

    @Override
    public void merge(AnswerRecord model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void deleteObject(AnswerRecord model) {

    }

    @Override
    public AnswerRecord get(Integer id) {
        return null;
    }

    @Override
    public int countAll() {
        return 0;
    }

    @Override
    public List<AnswerRecord> listAll() {
        return null;
    }

    @Override
    public Page<AnswerRecord> findByPage(Integer start, Integer size) {
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

    @Override
    public boolean IsAnswer(String openId) {
        Date date = new Date();
        AnswerRecord answerRecord = answerRecordRepository.findFirstByOpenIdAndDate(openId,date);
        if(answerRecord == null)
            return false;
        return true;
    }
}
