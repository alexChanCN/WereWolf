package com.cs.wechat.domain.repository;

import com.cs.wechat.core.BaseRepository;
import com.cs.wechat.domain.entity.Member;

/**
 * Created by cs on 2017/8/4.
 */
public interface MemberRepository extends BaseRepository<Member,Integer> {

    Member findByOpenId(String openId);

}
