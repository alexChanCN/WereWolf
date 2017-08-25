package com.github.binarywang.demo.wechat.repository;

import com.github.binarywang.demo.wechat.domain.model.Question;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by cs on 2017/8/4.
 */
@Repository
public interface QuestionRepository extends PagingAndSortingRepository<Question,Integer>{
    List<Question> findAll();

    Question findFirstByOrderByIdDesc();
}
