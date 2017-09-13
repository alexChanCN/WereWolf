package com.cs.wechat;

import com.cs.wechat.domain.entity.Question;
import com.cs.wechat.domain.repository.QuestionRepository;
import com.cs.wechat.service.MemberService;
import com.cs.wechat.service.QuestionService;
import com.cs.wechat.service.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by cs on 2017/7/3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WxMpDemoApplication.class)
public class TestService {
    /*@Autowired
    private UserService userService;

    @Test
    public void testUser(){
        User user = new User();
        user.setNickName("dewqd");
        userService.save(user);
    }

    @Test
    public void testFind(){
        User user = userService.findBy("openId","oqAK2wRLiXO3bJ9JfPm53kH7ar6E");
        System.out.println(user.getHeadImgUrl());
    }*/

/*    @Autowired
    private AwardRepository awardRepository;
    @Test
    public void test() throws Exception {
        AwardInfo a = new AwardInfo();
        a.setOpen_id("xx");
        a.setReason("aaa");
        awardRepository.save(a);

    }*/
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionService questionService;

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private MemberService memberService;


    @Test
    public void testQuestionService(){
        List<Question> questions = (List<Question>) questionRepository.findAll();
        questions.forEach(System.out::println);
        Question question = questionRepository.findOne(1);
        System.out.println(question);
    }



    @Test
    public void testMember(){
        System.out.println(memberService.get(1).getOpenId());
    }



}
