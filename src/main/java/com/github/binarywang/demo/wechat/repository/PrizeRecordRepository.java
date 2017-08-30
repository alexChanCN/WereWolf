package com.github.binarywang.demo.wechat.repository;

import com.github.binarywang.demo.wechat.domain.model.Member;
import com.github.binarywang.demo.wechat.domain.model.PrizeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cs on 2017/8/11.
 */
@Repository
public interface PrizeRecordRepository extends JpaRepository<PrizeRecord,Integer> {
    List<PrizeRecord> findByMemberAndStatus(Member member, Integer status);

    List<PrizeRecord> findByMember(Member member);

    List<PrizeRecord> findByStatus(Integer status);

}
