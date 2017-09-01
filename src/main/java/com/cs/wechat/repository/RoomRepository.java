package com.cs.wechat.repository;

import com.cs.wechat.core.BaseRepository;
import com.cs.wechat.domain.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cs on 2017/8/5.
 */
@Repository
public interface RoomRepository extends BaseRepository<Room,Integer> {
    List<Room> findByType(Integer type);
}
