package com.cs.wechat.service.impl;

import com.cs.wechat.core.BaseServiceImpl;
import com.cs.wechat.domain.model.Prize;
import com.cs.wechat.repository.PrizeRepository;
import com.cs.wechat.service.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cs on 2017/8/29.
 */
@Service
public class PrizeServiceImpl extends BaseServiceImpl<Prize,Integer> implements PrizeService {

}
