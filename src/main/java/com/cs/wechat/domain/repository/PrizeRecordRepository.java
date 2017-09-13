package com.cs.wechat.domain.repository;

import com.cs.wechat.core.BaseRepository;
import com.cs.wechat.domain.entity.Member;
import com.cs.wechat.domain.entity.PrizeRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cs on 2017/8/11.
 */
@Repository
public interface PrizeRecordRepository extends BaseRepository<PrizeRecord,Integer> {
    List<PrizeRecord> findByMemberAndStatus(Member member, Integer status);

    List<PrizeRecord> findByMember(Member member);

    List<PrizeRecord> findByStatus(Integer status);

}
