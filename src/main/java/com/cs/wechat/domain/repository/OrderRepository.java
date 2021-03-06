package com.cs.wechat.domain.repository;

import com.cs.wechat.core.BaseRepository;
import com.cs.wechat.domain.entity.Member;
import com.cs.wechat.domain.entity.OrderRecord;
import com.cs.wechat.domain.entity.Room;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by cs on 2017/8/7.
 */
@Repository
public interface OrderRepository extends BaseRepository<OrderRecord,Long> {
    //@Query("select o from OrderInfo o where o.date = :date and o.room = :room and o.phase = :phase")
    //List<OrderInfo> findByDateAndRoomAndPhase(@Param("date") Date date,@Param("room") Integer room,@Param("phase") Integer phase);
    List<OrderRecord> findByDateAndRoomAndPhase(Date date, Room room, Integer phase);
    List<OrderRecord> findByMember(Member member);

    List<OrderRecord> findByStatus(Integer status);
}
