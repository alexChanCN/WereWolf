package com.github.binarywang.demo.wechat.service;

import com.github.binarywang.demo.wechat.domain.dto.FindSeatInfo;
import com.github.binarywang.demo.wechat.domain.dto.ReserveInfo;
import com.github.binarywang.demo.wechat.domain.model.OrderInfo;

import java.util.List;

/**
 * Created by cs on 2017/8/8.
 */
public interface OrderService extends CoreService<OrderInfo,Long>{
    Integer reserve(ReserveInfo reserveInfo);
    Integer verify(Long id,String clerkName);
    List<Integer> findSeats(FindSeatInfo info);
    List<OrderInfo> findByOpenId(String openId);
}
