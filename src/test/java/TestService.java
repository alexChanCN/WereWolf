import com.github.binarywang.demo.wechat.WxMpDemoApplication;
import com.github.binarywang.demo.wechat.domain.model.Comment;
import com.github.binarywang.demo.wechat.domain.model.Question;
import com.github.binarywang.demo.wechat.domain.model.Teacher;
import com.github.binarywang.demo.wechat.repository.QuestionRepository;
import com.github.binarywang.demo.wechat.service.MemberService;
import com.github.binarywang.demo.wechat.service.QuestionService;
import com.github.binarywang.demo.wechat.service.TeacherService;
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
    public void testQuestionCompare(){
        System.out.println(questionService.compareAnswer(1,"a"));
    }

    @Test
    public void testTeacher(){
        List<Teacher> teachers = teacherService.listAll();
        teachers.forEach(System.out::println);
        List<Comment> comments = teacherService.get(1).getComments();
        comments.forEach(System.out::println);
    }

    @Test
    public void testMember(){
        System.out.println(memberService.get(1).getOpenId());
    }



}
