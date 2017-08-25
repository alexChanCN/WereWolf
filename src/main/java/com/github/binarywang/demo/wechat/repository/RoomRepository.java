package com.github.binarywang.demo.wechat.repository;

import com.github.binarywang.demo.wechat.domain.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cs on 2017/8/5.
 */
@Repository
public interface RoomRepository extends JpaRepository<Room,Integer>{
    //List<Room> findByStatus();
}
