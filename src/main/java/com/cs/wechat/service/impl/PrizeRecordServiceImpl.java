package com.cs.wechat.service.impl;

import com.cs.wechat.core.BaseServiceImpl;
import com.cs.wechat.domain.entity.Member;
import com.cs.wechat.domain.entity.Prize;
import com.cs.wechat.domain.entity.PrizeRecord;
import com.cs.wechat.pojo.dto.PrizeInfo;
import com.cs.wechat.domain.repository.MemberRepository;
import com.cs.wechat.domain.repository.PrizeRecordRepository;
import com.cs.wechat.service.PrizeRecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * Created by cs on 2017/8/11.
 */
@Service
public class PrizeRecordServiceImpl extends BaseServiceImpl<PrizeRecord, Integer> implements PrizeRecordService {

    @Autowired
    PrizeRecordRepository prizeRecordRepository;

    @Autowired
    MemberRepository memberRepository;

    private static final String[] HEADERS = {"学号", "姓名", "基本"};
    @Override
    public Integer add(PrizeInfo prizeInfo) {
        PrizeRecord prizeRecord = new PrizeRecord();

        Member member = memberRepository.findByOpenId(prizeInfo.getOpenId());
        prizeRecord.setMember(member);

        Prize prize = new Prize();
        prize.setId(prizeInfo.getPrizeId());
        prizeRecord.setPrize(prize);

        prizeRecord.setStatus(prizeInfo.getStatus());
        prizeRecord.setCreateTime(new Date());
        prizeRecordRepository.save(prizeRecord);
        return 1;
    }

    @Override
    public List<PrizeRecord> listMine(String openId, Integer status) {
        //创建查询条件数据对象
        Member member = new Member();
        member.setOpenId(openId);
        //创建查询条件数据对象
        PrizeRecord prizeRecord = new PrizeRecord();
        prizeRecord.setStatus(status);
        prizeRecord.setMember(member);

        //创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching(); //构建对象
        //.withIgnorePaths("focus");  //忽略属性：是否关注。因为是基本类型，需要忽略掉

        //创建实例
        Example<PrizeRecord> ex = Example.of(prizeRecord, matcher);

        //查询
        return prizeRecordRepository.findAll(ex);
        //return prizeRecordRepository.findByOpenIdAndStatus(openId,status);
    }


    @Override
    public boolean updateById(Integer id) {
        PrizeRecord prizeRecord = prizeRecordRepository.findOne(id);
        if (prizeRecord != null) {
            prizeRecord.setStatus(2);
            prizeRecordRepository.save(prizeRecord);
            return true;
        } else
            return false;
    }

}
