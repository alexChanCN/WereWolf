package com.cs.wechat.repository;

import com.cs.wechat.core.BaseRepository;
import com.cs.wechat.domain.model.Member;
import com.cs.wechat.domain.model.PrizeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
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
