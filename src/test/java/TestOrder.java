import com.github.binarywang.demo.wechat.WxMpDemoApplication;
import com.github.binarywang.demo.wechat.domain.dto.OrderRequest;
import com.github.binarywang.demo.wechat.domain.dto.RoomRequest;
import com.github.binarywang.demo.wechat.domain.model.OrderRecord;
import com.github.binarywang.demo.wechat.domain.model.Room;
import com.github.binarywang.demo.wechat.repository.OrderRepository;
import com.github.binarywang.demo.wechat.service.OrderService;
import com.github.binarywang.demo.wechat.utils.DateUtils;
import com.github.binarywang.demo.wechat.utils.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by cs on 2017/8/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WxMpDemoApplication.class)
public class TestOrder {

    @Autowired
    OrderRepository repository;

    @Autowired
    OrderService orderService;

    @Test
    public void testAdd(){
        OrderRequest reserveInfo = new OrderRequest("xxx","2017-8-30",1,1,1);
        orderService.reserve(reserveInfo);

    }

    @Test
    public void testUpdate(){
        orderService.confirm(1l,"xxx");
    }

    @Test
    public void  testFind(){
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //Date date = dateFormat.format(new Date());
        Date date = new Date();
        Room room = new Room();
        room.setId(1);
        List<OrderRecord> orderInfos = repository.findByDateAndRoomAndPhase(date,room,1);

        System.out.println(JsonUtils.toJson(orderInfos));
        //orderInfos.forEach(System.out::println);
    }

    @Test
    public void findByOpenId(){
        //JsonUtils.toJson(orderService.findByOpenId("oqAK2wRLiXO3bJ9JfPm53kH7ar6E"));
        List<OrderRecord> orderInfos = orderService.findByOpenId("oqAK2wRLiXO3bJ9JfPm53kH7ar6E");
        orderInfos.forEach(System.out::println);
    }

    @Test
    public void  testFind2(){
        OrderRecord orderRecord = new OrderRecord();
        orderRecord.setPhase(1);
        //创建实例
        Example<OrderRecord> ex = Example.of(orderRecord);
        //查询
        List<OrderRecord> orderRecords =  repository.findAll(ex);
        System.out.println(JsonUtils.toJson(orderRecords));
    }
    @Test
    public void  testFind3(){
        RoomRequest roomRequest = new RoomRequest();
        roomRequest.setPhase(1);
        roomRequest.setType(1);
        roomRequest.setDate("2017-08-30");
        List<OrderRecord> orderRecords =  orderService.findByRequest(roomRequest);
        System.out.println(JsonUtils.toJson(orderRecords));
    }
}
