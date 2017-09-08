package com.cs.wechat.service;

import com.cs.wechat.core.BaseService;
import com.cs.wechat.domain.vo.PrizeInfo;
import com.cs.wechat.domain.model.PrizeRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by cs on 2017/8/11.
 */
public interface PrizeRecordService extends BaseService<PrizeRecord,Integer> {
    Integer add(PrizeInfo prizeInfo);

    List<PrizeRecord> listMine(String openId, Integer status);

    boolean updateById(Integer id);



}
