package com.github.binarywang.demo.wechat.service.impl;

import com.github.binarywang.demo.wechat.domain.dto.RegisterInfo;
import com.github.binarywang.demo.wechat.domain.model.Member;
import com.github.binarywang.demo.wechat.domain.model.Subscriber;
import com.github.binarywang.demo.wechat.repository.MemberRepository;
import com.github.binarywang.demo.wechat.repository.SubscriberRepository;
import com.github.binarywang.demo.wechat.service.MemberService;
import com.github.binarywang.demo.wechat.utils.DecodeBase64;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
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

    @Override
    public boolean registry(RegisterInfo registerInfo) {

        String openId = registerInfo.getOpenId();
        Subscriber subscriber = subscriberRepository.findByOpenId(openId);
        Member member = new Member();
        member.setPhoneNo(registerInfo.getPhoneNo());
        member.setName(registerInfo.getName());
        member.setIdCard(registerInfo.getIdCard());
        member.setAwardCount(1);
        member.setHeadImgUrl(subscriber.getHeadImgUrl());
        member.setNickName(subscriber.getNickName());
        member.setSex(subscriber.getSex());
        member.setOpenId(subscriber.getOpenId());
        member.setCreateTime(new Date());
        memberRepository.save(member);
        return true;
    }

    @Override
    public boolean changeChance(String openId, Integer i) {
        Member member = memberRepository.findByOpenId(openId);
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
        Member member = memberRepository.findOne(id);
        String nickName = member.getNickName();
        member.setNickName(DecodeBase64.Decode(nickName));
        return member;
    }

    @Override
    public int countAll() {
        return 0;
    }

    @Override
    public List<Member> listAll() {
        List<Member> members = (List<Member>) memberRepository.findAll();
        for(Member member: members){
            String nickName = member.getNickName();
            member.setNickName(DecodeBase64.Decode(nickName));
        }
        return members;
    }

    @Override
    public Page<Member> findByPage(Integer start, Integer size) {
        Page<Member> members = memberRepository.findAll(new PageRequest(start,size));
        for(Member member: members){
            String nickName = member.getNickName();
            member.setNickName(DecodeBase64.Decode(nickName));
        }
        return members;
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
