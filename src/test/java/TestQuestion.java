import com.cs.wechat.WxMpDemoApplication;
import com.cs.wechat.domain.vo.QuestionInfo;
import com.cs.wechat.domain.model.Question;
import com.cs.wechat.repository.AnswerRecordRepository;
import com.cs.wechat.service.AnswerRecordService;
import com.cs.wechat.service.QuestionService;
import com.cs.wechat.utils.JsonUtils;
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

    @Autowired
    AnswerRecordRepository answerRecordRepository;

    @Autowired
    AnswerRecordService answerRecordService;

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

    @Test
    public void testGetRecord(){
        //Date date = DateUtils.string2Date(new String("2017-08-10"));
        //Date date = DateUtils.getNowTime("yyyy-MM-dd");
        /*Date date = new Date();
        String openId = "xxx";
        System.out.println(answerRecordRepository.findByOpenIdAndDate(openId,date));*/
        System.out.println(answerRecordService.IsAnswer("oqAK2wRLiXO3bJ9JfPm53kH7ar6E"));
    }
}
