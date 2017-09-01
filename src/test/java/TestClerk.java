import com.cs.wechat.WxMpDemoApplication;
import com.cs.wechat.domain.model.Clerk;
import com.cs.wechat.service.ClerkService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by cs on 2017/9/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WxMpDemoApplication.class)
public class TestClerk {
    @Autowired
    ClerkService clerkService;

    @Test
    public void testSave(){
        Clerk clerk= new Clerk();
        clerk.setUsername("xxx");
        clerk.setPassword("123456");
        clerkService.save(clerk);
    }

    @Test
    public void testFind(){

        Clerk clerk = clerkService.findByUsername("xxx");
        System.out.println(clerk.getUsername());
    }
    @Test
    public void testGet(){

        Clerk clerk = clerkService.get(1);
        System.out.println(clerk.getUsername());
    }
}
