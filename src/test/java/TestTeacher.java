import com.github.binarywang.demo.wechat.WxMpDemoApplication;
import com.github.binarywang.demo.wechat.domain.model.Comment;
import com.github.binarywang.demo.wechat.domain.model.Teacher;
import com.github.binarywang.demo.wechat.service.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by cs on 2017/8/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WxMpDemoApplication.class)
public class TestTeacher {
    @Autowired
    TeacherService teacherService;

    @Test
    public void getOne(){
        Teacher teacher = teacherService.get(1);
        List<Comment> comments = teacher.getComments();
        System.out.println(comments);
        //comments.forEach(System.out::println);
    }
}
