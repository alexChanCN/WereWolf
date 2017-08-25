import com.github.binarywang.demo.wechat.WxMpDemoApplication;
import com.github.binarywang.demo.wechat.domain.model.Chance;
import com.github.binarywang.demo.wechat.service.ChanceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by cs on 2017/8/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WxMpDemoApplication.class)
public class TestChance {
    @Autowired
    ChanceService awardService;

    @Test
    public void testList(){
        List<Chance> awards = awardService.findByOpenId("oqAK2wRLiXO3bJ9JfPm53kH7ar6E");
        awards.forEach(System.out::println);
    }
}
