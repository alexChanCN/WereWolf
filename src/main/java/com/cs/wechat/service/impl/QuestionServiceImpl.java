package com.cs.wechat.service.impl;

import com.cs.wechat.core.BaseServiceImpl;
import com.cs.wechat.pojo.vo.QuestionInfo;
import com.cs.wechat.domain.entity.Question;
import com.cs.wechat.domain.repository.QuestionRepository;
import com.cs.wechat.service.QuestionService;
import com.cs.wechat.utils.QuestionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;


/**
 * Created by cs on 2017/8/4.
 */
@Service
public class QuestionServiceImpl extends BaseServiceImpl<Question,Integer> implements QuestionService{

    @Autowired
    QuestionRepository questionRepository;

    /*@Override
    public boolean compareAnswer(Integer id, String answer) {
        Question question = questionRepository.findOne(id);
        String correctAnswer = question.getAnswer();
        if(answer.equalsIgnoreCase(correctAnswer)){
            return true;
        }
        return false;
    }*/

    @Override
    public QuestionInfo getTop() {
        QuestionInfo questionInfo = QuestionUtils.toOption(questionRepository.findFirstByOrderByIdDesc());
        return questionInfo;
    }

    @Override
    public QuestionInfo getRandom() {
        Random random = new Random();

        int count = (int)questionRepository.count();
        int id = random.nextInt(count);
        QuestionInfo questionInfo = QuestionUtils.toOption(questionRepository.findOne(id+1));
        return questionInfo;
    }

}
