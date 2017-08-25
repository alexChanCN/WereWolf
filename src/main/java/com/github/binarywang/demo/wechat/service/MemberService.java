package com.github.binarywang.demo.wechat.service;

import com.github.binarywang.demo.wechat.domain.dto.RegisterInfo;
import com.github.binarywang.demo.wechat.domain.model.Member;

/**
 * Created by cs on 2017/8/4.
 */
public interface MemberService extends CoreService<Member,Integer>{
    boolean registry(RegisterInfo registerInfo);
    boolean changeChance(String openId, Integer i);
    Integer getChance(String openId);
    Member findByOpenId(String openId);
}
