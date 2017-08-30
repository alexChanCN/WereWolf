package com.github.binarywang.demo.wechat.service;

import com.github.binarywang.demo.wechat.core.CoreService;
import com.github.binarywang.demo.wechat.domain.dto.PrizeInfo;
import com.github.binarywang.demo.wechat.domain.model.PrizeRecord;

import java.util.List;

/**
 * Created by cs on 2017/8/11.
 */
public interface PrizeRecordService extends CoreService<PrizeRecord,Integer> {
    Integer add(PrizeInfo prizeInfo);

    List<PrizeRecord> listMine(String openId, Integer status);

    List<PrizeRecord> findByName(String name);

    List<PrizeRecord> findByStatus(Integer status);

    void  updateById(Integer id);


}
