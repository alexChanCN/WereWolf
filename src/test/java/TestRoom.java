import com.github.binarywang.demo.wechat.WxMpDemoApplication;
import com.github.binarywang.demo.wechat.domain.dto.FindSeatInfo;
import com.github.binarywang.demo.wechat.domain.dto.RoomStatus;
import com.github.binarywang.demo.wechat.domain.model.Room;
import com.github.binarywang.demo.wechat.service.OrderService;
import com.github.binarywang.demo.wechat.service.RoomService;
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
public class TestRoom {
    @Autowired
    RoomService roomService;

    @Test
    public void testAdd() {
        for (int i = 1; i <= 8; i++) {
            Room r = new Room();
            r.setName(i + "号房间");
            r.setPicUrl("xxxxx");
            r.setPrice(12.5f);
            r.setSeatCount(12);
            r.setStatus(1);
            r.setType(1);
            roomService.save(r);
        }
    }

    @Test
    public void testChange() {
        System.out.println(roomService.changeStatus(1, 0));
    }

    @Test
    public void  testFind2(){
        List<RoomStatus> roomStatuses = roomService.getAllStatus(new Date(),1);
        System.out.println(JsonUtils.toJson(roomStatuses));
    }
}
