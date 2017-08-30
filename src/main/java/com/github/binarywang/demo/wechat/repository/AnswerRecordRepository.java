package com.github.binarywang.demo.wechat.repository;

import com.github.binarywang.demo.wechat.domain.model.AnswerRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by cs on 2017/8/27.
 */
@Repository
public interface AnswerRecordRepository extends JpaRepository<AnswerRecord,Integer>{

    AnswerRecord findFirstByOpenIdAndDate(String openId,Date date);
}
