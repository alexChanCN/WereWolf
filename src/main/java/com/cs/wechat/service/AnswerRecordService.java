package com.cs.wechat.service;

import com.cs.wechat.core.BaseService;
import com.cs.wechat.domain.entity.AnswerRecord;

/**
 * Created by cs on 2017/8/27.
 */
public interface AnswerRecordService extends BaseService<AnswerRecord,Integer> {
    boolean IsAnswer(String openId);
}
