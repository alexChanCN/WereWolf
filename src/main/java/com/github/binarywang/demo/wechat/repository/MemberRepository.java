package com.github.binarywang.demo.wechat.repository;

import com.github.binarywang.demo.wechat.domain.model.Member;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by cs on 2017/8/4.
 */
public interface MemberRepository extends PagingAndSortingRepository<Member,Integer>{

    Member findByOpenId(String openId);
}
