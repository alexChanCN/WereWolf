package com.github.binarywang.demo.wechat.service.impl;

import com.github.binarywang.demo.wechat.domain.dto.QuestionInfo;
import com.github.binarywang.demo.wechat.domain.model.AnswerRecord;
import com.github.binarywang.demo.wechat.domain.model.Question;
import com.github.binarywang.demo.wechat.repository.AnswerRecordRepository;
import com.github.binarywang.demo.wechat.repository.QuestionRepository;
import com.github.binarywang.demo.wechat.service.QuestionService;
import com.github.binarywang.demo.wechat.utils.QuestionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;


/**
 * Created by cs on 2017/8/4.
 */
@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public boolean compareAnswer(Integer id, String answer) {
        Question question = questionRepository.findOne(id);
        String correctAnswer = question.getAnswer();
        if(answer.equalsIgnoreCase(correctAnswer)){
            return true;
        }
        return false;
    }

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


    @Override
    public Integer save(Question model) {
        questionRepository.save(model);
        return 1;
    }

    @Override
    public void saveOrUpdate(Question model) {

    }

    @Override
    public void update(Question model) {
        questionRepository.save(model);
    }

    @Override
    public void merge(Question model) {

    }

    @Override
    public void delete(Integer id) {
        questionRepository.delete(id);
    }

    @Override
    public void deleteObject(Question model) {

    }

    @Override
    public Question get(Integer id) {
        return questionRepository.findOne(id);
    }

    @Override
    public int countAll() {
        return 0;
    }

    @Override
    public List<Question> listAll() {
        return questionRepository.findAll();
    }

    @Override
    public Page<Question> findByPage(Integer start, Integer size) {
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
