import com.cs.wechat.WxMpDemoApplication;
import com.cs.wechat.domain.model.Member;
import com.cs.wechat.domain.model.PrizeRecord;
import com.cs.wechat.repository.PrizeRecordRepository;
import com.cs.wechat.repository.PrizeRepository;
import com.cs.wechat.service.PrizeRecordService;
import com.cs.wechat.utils.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by cs on 2017/8/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WxMpDemoApplication.class)
public class TestPrize {
    @Autowired
    PrizeRecordRepository recordRepository;

    @Autowired
    PrizeRecordService prizeRecordService;
    @Autowired
    PrizeRepository prizeRepository;

    @Test
    public void testFind() {
       List<PrizeRecord> prizeRecords = prizeRecordService.listMine("oqAK2wRLiXO3bJ9JfPm53kH7ar6E",0);
        System.out.println(JsonUtils.toJson(prizeRecords));
    }

    @Test
    public void testFind2() {
        //创建查询条件数据对象
        Member member = new Member();
        //member.setId(3);
        member.setName("cs");
        //创建查询条件数据对象
        PrizeRecord prizeRecord = new PrizeRecord();
        prizeRecord.setMember(member);

        //创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching(); //构建对象
                //.withIgnorePaths("focus");  //忽略属性：是否关注。因为是基本类型，需要忽略掉

        //创建实例
        Example<PrizeRecord> ex = Example.of(prizeRecord, matcher);

        //查询
        List<PrizeRecord> ls = recordRepository.findAll(ex);

        //输出结果
        System.out.println("数量："+ls.size());
        for (PrizeRecord bo:ls)
        {
            System.out.println(bo.getCreateTime());
        }
    }

    @Test
    public void testFind3() {
        List<PrizeRecord> prizeRecords = prizeRecordService.findByName("张三");
        System.out.println(JsonUtils.toJson(prizeRecords));
    }

    @Test
    public void testFind4() {
        System.out.println(prizeRecordService.get(1));
    }

}
