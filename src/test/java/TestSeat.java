import com.github.binarywang.demo.wechat.WxMpDemoApplication;
import com.github.binarywang.demo.wechat.domain.model.Room;
import com.github.binarywang.demo.wechat.domain.model.Seat;
import com.github.binarywang.demo.wechat.repository.SeatRepository;
import com.github.binarywang.demo.wechat.service.SeatService;
import com.github.binarywang.demo.wechat.utils.JsonUtils;
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
public class TestSeat {
    @Autowired
    SeatRepository seatRepository;
    @Autowired
    SeatService seatService;

    @Test
    public void testAdd() {
        for (int i = 0; i < 8; i++) {
            Room room = new Room();
            room.setId(i + 1);
            for (int j = 0; j < 12; j++) {
                Seat seat = new Seat();
                seat.setStatus(1);
                seat.setRoom(room);
                seat.setSeatNo(j+1);
                seatService.save(seat);
            }
        }
    }

    @Test
    public void findByRoomAndSeatNo() {
        Room room = new Room();
        room.setId(1);
        Seat seat = seatRepository.findByRoomAndSeatNo(room, 1);
        System.out.println(seat.getId());
    }

    @Test
    public void change() {
        System.out.println(seatService.changeStatus(1, 1, 1));
    }

    @Test
    public void findIds() {
        Seat seat = seatService.findByIds(1,1);
        System.out.println(JsonUtils.toJson(seat));
    }
}
