package com.cs.wechat.service;

import com.cs.wechat.core.BaseService;
import com.cs.wechat.domain.dto.RegisterInfo;
import com.cs.wechat.domain.model.Member;

/**
 * Created by cs on 2017/8/4.
 */
public interface MemberService extends BaseService<Member,Integer> {
    boolean registry(RegisterInfo registerInfo);
    boolean changeChance(String openId, Integer i);
    Integer getChance(String openId);
    Member findByOpenId(String openId);
}