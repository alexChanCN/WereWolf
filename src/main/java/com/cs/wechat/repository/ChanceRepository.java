package com.cs.wechat.repository;

import com.cs.wechat.core.BaseRepository;
import com.cs.wechat.domain.model.Chance;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cs on 2017/8/1.
 */
@Repository
public interface ChanceRepository extends BaseRepository<Chance,Long> {

    Chance findByReason(String reason);
    List<Chance> findByOpenId(String openId);
}
