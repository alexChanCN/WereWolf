import com.cs.wechat.WxMpDemoApplication;
import com.cs.wechat.domain.model.Chance;
import com.cs.wechat.service.ChanceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by cs on 2017/8/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WxMpDemoApplication.class)
public class TestChance {
    @Autowired
    ChanceService chanceService;

    @Test
    public void testList(){
        List<Chance> awards = chanceService.findByOpenId("oqAK2wRLiXO3bJ9JfPm53kH7ar6E");
        awards.forEach(System.out::println);
    }
    @Test
    public void save(){
        Chance chance = new Chance();
        chance.setTime(new Date());
        chanceService.save(chance);
    }
}
