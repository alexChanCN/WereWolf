import com.cs.wechat.WxMpDemoApplication;
import com.cs.wechat.domain.model.Member;
import com.cs.wechat.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
        List<Member> members = memberService.listAll();
        for(Member member:members){
        String openId = member.getOpenId();
            System.out.println(openId.length());
        }

    }
}
