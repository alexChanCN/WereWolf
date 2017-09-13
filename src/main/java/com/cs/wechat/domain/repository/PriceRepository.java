package com.cs.wechat.domain.repository;

import com.cs.wechat.core.BaseRepository;
import com.cs.wechat.domain.entity.Price;
import com.cs.wechat.domain.entity.Room;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cs on 2017/9/12.
 */
@Repository
public interface PriceRepository extends BaseRepository<Price,Integer>{
    List<Price> findByRoom(Room room);
}
