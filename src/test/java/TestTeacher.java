import com.cs.wechat.WxMpDemoApplication;
import com.cs.wechat.domain.model.Teacher;
import com.cs.wechat.service.TeacherService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created by cs on 2017/8/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WxMpDemoApplication.class)
public class TestTeacher {
    @Autowired
    TeacherService teacherService;

    @Test
    public void save(){
        Teacher teacher = new Teacher();
        teacher.setName("xxx");
        teacher.setAge(18);
        teacher.setProfile("兰陵缭乱");
        teacher.setSex("男");

                teacherService.save(teacher);
    }
    @Test
    public void find(){
        System.out.println(teacherService.get(1));
    }

}
