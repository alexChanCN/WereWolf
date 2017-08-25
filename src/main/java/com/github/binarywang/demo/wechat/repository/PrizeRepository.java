package com.github.binarywang.demo.wechat.repository;

import com.github.binarywang.demo.wechat.domain.model.Member;
import com.github.binarywang.demo.wechat.domain.model.Prize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cs on 2017/8/11.
 */
@Repository
public interface PrizeRepository extends JpaRepository<Prize,Integer> {
    List<Prize> findByMemberAndStatus(Member member, Integer status);

    List<Prize> findByMember(Member member);

    List<Prize> findByStatus(Integer status);

}
