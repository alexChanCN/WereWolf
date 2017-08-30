package com.github.binarywang.demo.wechat.service.impl;

import com.github.binarywang.demo.wechat.domain.dto.PrizeInfo;
import com.github.binarywang.demo.wechat.domain.model.Member;
import com.github.binarywang.demo.wechat.domain.model.Prize;
import com.github.binarywang.demo.wechat.domain.model.PrizeRecord;
import com.github.binarywang.demo.wechat.repository.MemberRepository;
import com.github.binarywang.demo.wechat.repository.PrizeRecordRepository;
import com.github.binarywang.demo.wechat.service.PrizeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;

/**
 * Created by cs on 2017/8/11.
 */
@Service
public class PrizeRecordServiceImpl implements PrizeRecordService {

    @Autowired
    PrizeRecordRepository prizeRecordRepository;

    @Autowired
    MemberRepository memberRepository;

    @Override
    public Integer save(PrizeRecord model) {
        prizeRecordRepository.save(model);
        return 1;
    }

    @Override
    public void saveOrUpdate(PrizeRecord model) {

    }

    @Override
    public void update(PrizeRecord model) {

    }

    @Override
    public void merge(PrizeRecord model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void deleteObject(PrizeRecord model) {

    }

    @Override
    public PrizeRecord get(Integer id) {
        return prizeRecordRepository.findOne(id);
    }

    @Override
    public int countAll() {
        return 0;
    }

    @Override
    public List<PrizeRecord> listAll() {
        return (List)prizeRecordRepository.findAll();
    }

    @Override
    public Page<PrizeRecord> findByPage(Integer start, Integer size) {
        return prizeRecordRepository.findAll(new PageRequest(start,size));
    }

    @Override
    public boolean exists(Integer id) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public void clear() {

    }

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
    public List<PrizeRecord> findByName(String name) {
        //创建查询条件数据对象
        Member member = new Member();
        member.setName(name);
        //创建查询条件数据对象
        PrizeRecord prizeRecord = new PrizeRecord();
        prizeRecord.setMember(member);

        //创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching()//构建对象
        .withMatcher("name", startsWith()); //姓名采用“开始匹配”的方式查询
        //.withIgnorePaths("focus");  //忽略属性：是否关注。因为是基本类型，需要忽略掉

        //创建实例
        Example<PrizeRecord> ex = Example.of(prizeRecord, matcher);

        //查询
        return prizeRecordRepository.findAll(ex);
    }

    @Override
    public List<PrizeRecord> findByStatus(Integer status) {
        return prizeRecordRepository.findByStatus(status);
    }

    @Override
    public void updateById(Integer id) {
        PrizeRecord prizeRecord = prizeRecordRepository.findOne(id);
        prizeRecord.setStatus(1);
        prizeRecordRepository.save(prizeRecord);
    }
}
