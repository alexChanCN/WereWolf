package com.github.binarywang.demo.wechat.service;


import com.github.binarywang.demo.wechat.core.CoreService;
import com.github.binarywang.demo.wechat.domain.dto.QuestionInfo;
import com.github.binarywang.demo.wechat.domain.model.Question;

/**
 * Created by cs on 2017/8/4.
 */
public interface QuestionService extends CoreService<Question,Integer> {
    boolean compareAnswer(Integer id, String answer);

    QuestionInfo getTop();

    QuestionInfo getRandom();


}
