package com.cs.wechat.service;

import com.cs.wechat.core.BaseService;
import com.cs.wechat.pojo.dto.OrderRequest;
import com.cs.wechat.domain.entity.OrderRecord;
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
    List<OrderRecord> findByRequest(String date, Integer phase, Integer type);
    List<OrderRecord> findSeats(String date, Integer roomId, Integer phase);
    List<OrderRecord> findByStatus(Integer status);
    boolean updateById(Long id);

    Page<OrderRecord> findAllDesc(Integer start,Integer size);

}
