package com.github.binarywang.demo.wechat.service.impl;

import com.github.binarywang.demo.wechat.domain.model.Member;
import com.github.binarywang.demo.wechat.domain.model.Prize;
import com.github.binarywang.demo.wechat.repository.MemberRepository;
import com.github.binarywang.demo.wechat.repository.PrizeRepository;
import com.github.binarywang.demo.wechat.service.PrizeService;
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
public class PrizeServiceImpl implements PrizeService{

    @Autowired
    PrizeRepository prizeRepository;

    @Autowired
    MemberRepository memberRepository;

    @Override
    public Integer save(Prize model) {
        prizeRepository.save(model);
        return 1;
    }

    @Override
    public void saveOrUpdate(Prize model) {

    }

    @Override
    public void update(Prize model) {

    }

    @Override
    public void merge(Prize model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void deleteObject(Prize model) {

    }

    @Override
    public Prize get(Integer id) {
        return prizeRepository.findOne(id);
    }

    @Override
    public int countAll() {
        return 0;
    }

    @Override
    public List<Prize> listAll() {
        return (List)prizeRepository.findAll();
    }

    @Override
    public Page<Prize> findByPage(Integer start, Integer size) {
        return prizeRepository.findAll(new PageRequest(start,size));
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
    public Integer add(String openId, Integer prizeId) {
        Prize prize = new Prize();
        Member member = memberRepository.findByOpenId(openId);
        prize.setMember(member);
        prize.setPrizeId(prizeId);
        prize.setStatus(0);
        prize.setCreateTime(new Date());
        prizeRepository.save(prize);
        return 1;
    }

    @Override
    public List<Prize> listMine(String openId, Integer status) {
        //创建查询条件数据对象
        Member member = new Member();
        member.setOpenId(openId);
        //创建查询条件数据对象
        Prize prize = new Prize();
        prize.setStatus(status);
        prize.setMember(member);

        //创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching(); //构建对象
        //.withIgnorePaths("focus");  //忽略属性：是否关注。因为是基本类型，需要忽略掉

        //创建实例
        Example<Prize> ex = Example.of(prize, matcher);

        //查询
        return prizeRepository.findAll(ex);
        //return prizeRepository.findByOpenIdAndStatus(openId,status);
    }

    @Override
    public List<Prize> findByName(String name) {
        //创建查询条件数据对象
        Member member = new Member();
        member.setName(name);
        //创建查询条件数据对象
        Prize prize = new Prize();
        prize.setMember(member);

        //创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching()//构建对象
        .withMatcher("name", startsWith()); //姓名采用“开始匹配”的方式查询
        //.withIgnorePaths("focus");  //忽略属性：是否关注。因为是基本类型，需要忽略掉

        //创建实例
        Example<Prize> ex = Example.of(prize, matcher);

        //查询
        return prizeRepository.findAll(ex);
    }

    @Override
    public List<Prize> findByStatus(Integer status) {
        return prizeRepository.findByStatus(status);
    }

    @Override
    public void updateById(Integer id) {
        Prize prize = prizeRepository.findOne(id);
        prize.setStatus(1);
        prizeRepository.save(prize);
    }
}
