import com.github.binarywang.demo.wechat.WxMpDemoApplication;
import com.github.binarywang.demo.wechat.domain.model.Member;
import com.github.binarywang.demo.wechat.service.MemberService;
import com.github.binarywang.demo.wechat.utils.JsonUtils;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;

/**
 * Created by cs on 2017/8/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WxMpDemoApplication.class)
public class TestMember {
    @Autowired
    MemberService memberService;

    @Test
    public void testChange(){
        memberService.changeChance("xxx",1);
        System.out.println(memberService.getChance("xxx"));
    }

    @Test
    public void get(){
        System.out.println(JsonUtils.toJson(memberService.get(3)));
    }
}
