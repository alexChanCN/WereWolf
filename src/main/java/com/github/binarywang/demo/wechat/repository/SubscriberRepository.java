package com.github.binarywang.demo.wechat.repository;

import com.github.binarywang.demo.wechat.domain.model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cs on 2017/8/4.
 */
@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber,Long>{
    Subscriber findByOpenId(String openId);
    Subscriber findById(Integer id);
}
