import com.github.binarywang.demo.wechat.WxMpDemoApplication;
import com.github.binarywang.demo.wechat.domain.model.Subscriber;
import com.github.binarywang.demo.wechat.repository.SubscriberRepository;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;

/**
 * Created by cs on 2017/8/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WxMpDemoApplication.class)
public class TestSubscriber {

    @Autowired
    SubscriberRepository subscriberRepository;

    @Test
    public void testSave() {
        Subscriber s = new Subscriber();
        s.setId(100000);
        s.setOpenId("111");
        subscriberRepository.save(s);
    }

    @Test
    public void testFind() {
        String nickname = subscriberRepository.findById(3).getNickName();
        try {
            nickname = new String(Base64.decodeBase64(nickname.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(nickname);
    }

    @Test
    public void testRepository() {
        System.out.println(subscriberRepository.findByOpenId("xxx").getOpenId());
    }
}
