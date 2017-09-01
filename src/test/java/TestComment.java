import com.cs.wechat.WxMpDemoApplication;
import com.cs.wechat.domain.dto.CommentInfo;
import com.cs.wechat.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by cs on 2017/8/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WxMpDemoApplication.class)
public class TestComment {

    @Autowired
    CommentService commentService;

    @Test
    public void testSave() {
        CommentInfo commentInfo = new CommentInfo("xxx",1,"xxx");
        commentService.add(commentInfo);
    }



}
