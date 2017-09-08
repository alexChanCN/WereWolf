package com.cs.wechat.service;

import com.cs.wechat.core.BaseService;
import com.cs.wechat.domain.vo.OrderRequest;
import com.cs.wechat.domain.vo.RoomRequest;
import com.cs.wechat.domain.vo.SeatRequest;
import com.cs.wechat.domain.model.OrderRecord;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by cs on 2017/8/8.
 */
public interface OrderService extends BaseService<OrderRecord,Long> {
    Integer reserve(OrderRequest reserveInfo);
    Integer confirm(Long id,String clerkName) throws WxErrorException;
    List<OrderRecord> findByOpenId(String openId);
    List<OrderRecord> findByRequest(RoomRequest roomRequest);
    List<OrderRecord> findSeats(SeatRequest seatRequest);
    List<OrderRecord> findByStatus(Integer status);
    boolean updateById(Long id);

    Page<OrderRecord> findAllDesc(Integer start,Integer size);

}
