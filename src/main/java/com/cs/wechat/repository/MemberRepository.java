package com.cs.wechat.repository;

import com.cs.wechat.core.BaseRepository;
import com.cs.wechat.domain.model.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by cs on 2017/8/4.
 */
public interface MemberRepository extends BaseRepository<Member,Integer> {

    Member findByOpenId(String openId);

}
