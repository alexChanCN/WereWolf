package com.github.binarywang.demo.wechat.repository;

import com.github.binarywang.demo.wechat.domain.model.Member;
import com.github.binarywang.demo.wechat.domain.model.OrderInfo;
import com.github.binarywang.demo.wechat.domain.model.Room;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by cs on 2017/8/7.
 */
@Repository
public interface OrderRepository extends PagingAndSortingRepository<OrderInfo,Long>{
    //@Query("select o from OrderInfo o where o.date = :date and o.room = :room and o.phase = :phase")
    //List<OrderInfo> findByDateAndRoomAndPhase(@Param("date") Date date,@Param("room") Integer room,@Param("phase") Integer phase);
    List<OrderInfo> findByDateAndRoomAndPhase(Date date, Room room, Integer phase);
    List<OrderInfo> findByMember(Member member);
}
