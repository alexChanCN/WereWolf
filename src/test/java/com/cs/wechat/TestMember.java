package com.cs.wechat;

import com.cs.wechat.domain.entity.Member;
import com.cs.wechat.domain.repository.MemberRepository;
import com.cs.wechat.service.MemberService;
import com.cs.wechat.utils.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;

/**
 * Created by cs on 2017/8/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WxMpDemoApplication.class)
public class TestMember {
    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void testChange(){
        memberService.changeChance("xxx",1);
        System.out.println(memberService.getChance("xxx"));
    }

    @Test
    public void get(){
        List<Member> members = memberService.listAll();
        for(Member member:members){
        String openId = member.getOpenId();
            System.out.println(openId.length());
        }

    }

    @Test
    public void find(){
        /*List<Member> members = memberRepository.findByNameLike("张%");
        System.out.println(JsonUtils.toJson(members));*/
        Member member = new Member();
        member.setName("张");
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", startsWith().ignoreCase());

        Example<Member> example = Example.of(member,matcher);
        Page<Member> members = memberRepository.findAll(example,new PageRequest(0,10));
        System.out.println(JsonUtils.toJson(members));
    }
}
