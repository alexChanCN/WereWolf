import com.github.binarywang.demo.wechat.WxMpDemoApplication;
import com.github.binarywang.demo.wechat.domain.dto.FindSeatInfo;
import com.github.binarywang.demo.wechat.domain.dto.ReserveInfo;
import com.github.binarywang.demo.wechat.domain.model.OrderInfo;
import com.github.binarywang.demo.wechat.domain.model.Room;
import com.github.binarywang.demo.wechat.repository.OrderRepository;
import com.github.binarywang.demo.wechat.service.OrderService;
import com.github.binarywang.demo.wechat.utils.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
        ReserveInfo reserveInfo = new ReserveInfo(1,1,1,"xxx");
        orderService.reserve(reserveInfo);

    }

    @Test
    public void testUpdate(){
        orderService.verify(1l,"xxx");
    }

    @Test
    public void  testFind(){
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //Date date = dateFormat.format(new Date());
        Date date = new Date();
        Room room = new Room();
        room.setId(1);
        List<OrderInfo> orderInfos = repository.findByDateAndRoomAndPhase(date,room,1);

        System.out.println(JsonUtils.toJson(orderInfos));
        //orderInfos.forEach(System.out::println);
    }
    @Test
    public void  testFind2(){
        FindSeatInfo info = new FindSeatInfo();
        info.setDate("2017-08-10");
        info.setRoomId(1);
        info.setPhase(1);
        System.out.println(JsonUtils.toJson(orderService.findSeats(info)));
    }

    @Test
    public void findByOpenId(){
        //JsonUtils.toJson(orderService.findByOpenId("oqAK2wRLiXO3bJ9JfPm53kH7ar6E"));
        List<OrderInfo> orderInfos = orderService.findByOpenId("oqAK2wRLiXO3bJ9JfPm53kH7ar6E");
        orderInfos.forEach(System.out::println);
    }
}
