package com.cs.wechat.service;

import com.cs.wechat.core.BaseService;
import com.cs.wechat.domain.dto.OrderRequest;
import com.cs.wechat.domain.dto.RoomRequest;
import com.cs.wechat.domain.dto.SeatRequest;
import com.cs.wechat.domain.model.OrderRecord;

import java.util.List;

/**
 * Created by cs on 2017/8/8.
 */
public interface OrderService extends BaseService<OrderRecord,Long> {
    Integer reserve(OrderRequest reserveInfo);
    Integer confirm(Long id,String clerkName);
    List<OrderRecord> findByOpenId(String openId);
    List<OrderRecord> findByRequest(RoomRequest roomRequest);
    List<OrderRecord> findSeats(SeatRequest seatRequest);
    List<OrderRecord> findByStatus(Integer status);
    boolean updateById(Long id);

}
