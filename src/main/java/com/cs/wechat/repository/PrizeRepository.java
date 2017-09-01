package com.cs.wechat.repository;

import com.cs.wechat.core.BaseRepository;
import com.cs.wechat.domain.model.Prize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by cs on 2017/8/11.
 */
@Repository
public interface PrizeRepository extends BaseRepository<Prize,Integer> {


}
