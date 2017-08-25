import com.github.binarywang.demo.wechat.WxMpDemoApplication;
import com.github.binarywang.demo.wechat.domain.dto.QuestionInfo;
import com.github.binarywang.demo.wechat.domain.model.Question;
import com.github.binarywang.demo.wechat.service.QuestionService;
import com.github.binarywang.demo.wechat.utils.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by cs on 2017/8/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WxMpDemoApplication.class)
public class TestQuestion {
    @Autowired
    QuestionService questionService;

    @Test
    public void testSave(){
        for(int i = 0;i<20;i++){
        Question q = new Question();
        q.setAnswer("A");
        q.setTitle("第" +i + "题");
        q.setOption_A("答案A");
        q.setOption_B("答案B");
        q.setOption_C("答案C");
        q.setOption_D("答案D");
        questionService.save(q);}
    }
    @Test
    public void testUpdate(){
        Question question = questionService.get(1);
        question.setTitle("我是修改后的题目");
        questionService.save(question);
        System.out.println(questionService.get(1).getTitle());
    }

    @Test
    public void testGetRandom(){
        QuestionInfo question = questionService.getRandom();
        System.out.println(JsonUtils.toJson(question));
    }
}
