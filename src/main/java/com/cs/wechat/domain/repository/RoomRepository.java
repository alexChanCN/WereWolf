package com.cs.wechat.domain.repository;

import com.cs.wechat.core.BaseRepository;
import com.cs.wechat.domain.entity.Room;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cs on 2017/8/5.
 */
@Repository
public interface RoomRepository extends BaseRepository<Room,Integer> {
    List<Room> findByType(Integer type);
}
