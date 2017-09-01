package com.cs.wechat.service.impl;

import com.cs.wechat.core.BaseServiceImpl;
import com.cs.wechat.domain.dto.RegisterInfo;
import com.cs.wechat.domain.model.Member;
import com.cs.wechat.repository.MemberRepository;
import com.cs.wechat.repository.SubscriberRepository;
import com.cs.wechat.service.MemberService;
import com.github.binarywang.java.emoji.EmojiConverter;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by cs on 2017/8/4.
 */
@Service
public class MemberServiceImpl extends BaseServiceImpl<Member,Integer> implements MemberService {

    @Autowired
    SubscriberRepository subscriberRepository;
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    WxMpService wxMpService;

    private EmojiConverter emojiConverter = EmojiConverter.getInstance();

    @Override
    public boolean registry(RegisterInfo registerInfo) {
        String openId = registerInfo.getOpenId();
        String lang = "zh_CN"; //语言
        WxMpUser user = new WxMpUser();

        try {
            user = wxMpService.getUserService().userInfo(openId,lang);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        Member member = new Member();
        member.setOpenId(openId);
        member.setPhoneNo(registerInfo.getPhoneNo());
        member.setName(registerInfo.getName());
        member.setIdCard(registerInfo.getIdCard());

        member.setAwardCount(1);
        member.setCreateTime(new Date());
        member.setHeadImgUrl(user.getHeadImgUrl());
        String alis = emojiConverter.toAlias(user.getNickname());
        member.setNickName(alis);

        if(memberRepository.findByOpenId(openId)==null)
            memberRepository.save(member);
        else
            return false;
        return true;
    }

    @Override
    public boolean changeChance(String openId, Integer i) {
        Member member = findByOpenId(openId);
        Integer count = member.getAwardCount();
        if (i > 0 || (i < 0 && count > 0)) {
            count = count + i;
            System.out.println(count);
        } else
            return false;
        member.setAwardCount(count);
        memberRepository.save(member);
        return true;
    }

    @Override
    public Integer getChance(String openId) {
        Member member = memberRepository.findByOpenId(openId);
        Integer count = member.getAwardCount();
        return count;
    }

    @Override
    public Member findByOpenId(String openId) {
        return memberRepository.findByOpenId(openId);
    }

}
