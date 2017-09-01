package com.cs.wechat.repository;

import com.cs.wechat.core.BaseRepository;
import com.cs.wechat.domain.model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cs on 2017/8/4.
 */
@Repository
public interface SubscriberRepository extends BaseRepository<Subscriber,Long> {
    Subscriber findByOpenId(String openId);
    Subscriber findById(Integer id);
}
