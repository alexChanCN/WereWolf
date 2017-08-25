package com.github.binarywang.demo.wechat.repository;

import com.github.binarywang.demo.wechat.domain.model.Room;
import com.github.binarywang.demo.wechat.domain.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cs on 2017/8/5.
 */
@Repository
public interface SeatRepository extends JpaRepository<Seat,Integer>{
    //List<Room> findByStatus();
    Seat findByRoomAndSeatNo(Room room,Integer seatNo);
}
