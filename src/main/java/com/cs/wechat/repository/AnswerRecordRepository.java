package com.cs.wechat.repository;

import com.cs.wechat.core.BaseRepository;
import com.cs.wechat.domain.model.AnswerRecord;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by cs on 2017/8/27.
 */
@Repository
public interface AnswerRecordRepository extends BaseRepository<AnswerRecord,Integer> {

    AnswerRecord findFirstByOpenIdAndDate(String openId,Date date);
}
