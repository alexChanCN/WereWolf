package com.github.binarywang.demo.wechat.repository;

import com.github.binarywang.demo.wechat.domain.model.Chance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cs on 2017/8/1.
 */
@Repository
public interface ChanceRepository extends JpaRepository<Chance,Long>{

    Chance findByReason(String reason);
    List<Chance> findByOpenId(String openId);
}
