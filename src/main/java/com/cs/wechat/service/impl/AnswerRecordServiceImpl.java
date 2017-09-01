package com.cs.wechat.service.impl;

import com.cs.wechat.core.BaseServiceImpl;
import com.cs.wechat.domain.model.AnswerRecord;
import com.cs.wechat.repository.AnswerRecordRepository;
import com.cs.wechat.service.AnswerRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by cs on 2017/8/27.
 */
@Service
public class AnswerRecordServiceImpl extends BaseServiceImpl<AnswerRecord,Integer>implements AnswerRecordService {

    @Autowired
    AnswerRecordRepository answerRecordRepository;

    /*
    是否答过题目
     */
    @Override
    public boolean IsAnswer(String openId) {
        Date date = new Date();
        AnswerRecord answerRecord = answerRecordRepository.findFirstByOpenIdAndDate(openId,date);
        if(answerRecord == null)
            return false;
        return true;
    }
}
