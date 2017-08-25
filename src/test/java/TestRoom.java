import com.github.binarywang.demo.wechat.WxMpDemoApplication;
import com.github.binarywang.demo.wechat.domain.model.Room;
import com.github.binarywang.demo.wechat.service.RoomService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}
