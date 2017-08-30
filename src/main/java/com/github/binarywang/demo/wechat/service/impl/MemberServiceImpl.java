package com.github.binarywang.demo.wechat.service.impl;

import com.github.binarywang.demo.wechat.domain.dto.RegisterInfo;
import com.github.binarywang.demo.wechat.domain.model.Member;
import com.github.binarywang.demo.wechat.repository.MemberRepository;
import com.github.binarywang.demo.wechat.repository.SubscriberRepository;
import com.github.binarywang.demo.wechat.service.MemberService;
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
public class MemberServiceImpl implements MemberService {

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

        //Subscriber subscriber = subscriberRepository.findByOpenId(openId);
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


    @Override
    public Integer save(Member model) {
        return null;
    }

    @Override
    public void saveOrUpdate(Member model) {

    }

    @Override
    public void update(Member model) {

    }

    @Override
    public void merge(Member model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void deleteObject(Member model) {

    }

    @Override
    public Member get(Integer id) {
        return memberRepository.findOne(id);

    }

    @Override
    public int countAll() {
        return 0;
    }

    @Override
    public List<Member> listAll() {
        return  (List<Member>) memberRepository.findAll();
    }

    @Override
    public Page<Member> findByPage(Integer start, Integer size) {
        return memberRepository.findAll(new PageRequest(start, size));
    }

    @Override
    public boolean exists(Integer id) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public void clear() {

    }
}
