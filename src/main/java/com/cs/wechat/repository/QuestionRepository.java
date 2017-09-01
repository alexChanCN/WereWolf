package com.cs.wechat.repository;

import com.cs.wechat.core.BaseRepository;
import com.cs.wechat.domain.model.Question;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by cs on 2017/8/4.
 */
@Repository
public interface QuestionRepository extends BaseRepository<Question,Integer> {
    List<Question> findAll();

    Question findFirstByOrderByIdDesc();
}
