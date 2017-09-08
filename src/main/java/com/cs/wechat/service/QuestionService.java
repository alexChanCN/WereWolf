package com.cs.wechat.service;


import com.cs.wechat.core.BaseService;
import com.cs.wechat.domain.vo.QuestionInfo;
import com.cs.wechat.domain.model.Question;

/**
 * Created by cs on 2017/8/4.
 */
public interface QuestionService extends BaseService<Question,Integer> {
    //boolean compareAnswer(Integer id, String answer);

    QuestionInfo getTop();

    QuestionInfo getRandom();


}
