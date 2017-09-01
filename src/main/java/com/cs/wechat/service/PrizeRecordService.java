package com.cs.wechat.service;

import com.cs.wechat.core.BaseService;
import com.cs.wechat.domain.dto.PrizeInfo;
import com.cs.wechat.domain.model.PrizeRecord;

import java.util.List;

/**
 * Created by cs on 2017/8/11.
 */
public interface PrizeRecordService extends BaseService<PrizeRecord,Integer> {
    Integer add(PrizeInfo prizeInfo);

    List<PrizeRecord> listMine(String openId, Integer status);

    List<PrizeRecord> findByName(String name);

    List<PrizeRecord> findByStatus(Integer status);

    boolean updateById(Integer id);


}
