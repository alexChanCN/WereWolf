package com.github.binarywang.demo.wechat.service;

import com.github.binarywang.demo.wechat.core.CoreService;
import com.github.binarywang.demo.wechat.domain.model.AnswerRecord;

/**
 * Created by cs on 2017/8/27.
 */
public interface AnswerRecordService extends CoreService<AnswerRecord,Integer> {
    boolean IsAnswer(String openId);
}
