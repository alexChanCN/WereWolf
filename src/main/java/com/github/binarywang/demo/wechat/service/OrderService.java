package com.github.binarywang.demo.wechat.service;

import com.github.binarywang.demo.wechat.core.CoreService;
import com.github.binarywang.demo.wechat.domain.dto.OrderRequest;
import com.github.binarywang.demo.wechat.domain.dto.RoomRequest;
import com.github.binarywang.demo.wechat.domain.dto.SeatRequest;
import com.github.binarywang.demo.wechat.domain.model.OrderRecord;

import java.util.List;

/**
 * Created by cs on 2017/8/8.
 */
public interface OrderService extends CoreService<OrderRecord,Long> {
    Integer reserve(OrderRequest reserveInfo);
    Integer confirm(Long id,String clerkName);
    List<OrderRecord> findByOpenId(String openId);
    List<OrderRecord> findByRequest(RoomRequest roomRequest);
    List<OrderRecord> findSeats(SeatRequest seatRequest);

}
