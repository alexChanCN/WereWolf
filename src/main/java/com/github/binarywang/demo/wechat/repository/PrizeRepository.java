package com.github.binarywang.demo.wechat.repository;

import com.github.binarywang.demo.wechat.domain.model.Prize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by cs on 2017/8/11.
 */
@Repository
public interface PrizeRepository extends JpaRepository<Prize,Integer> {


}
