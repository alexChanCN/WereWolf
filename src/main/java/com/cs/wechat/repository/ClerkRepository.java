package com.cs.wechat.repository;


import com.cs.wechat.core.BaseRepository;
import com.cs.wechat.domain.model.Clerk;
import org.springframework.stereotype.Repository;

/**
 * Created by cs on 2017/8/31.
 */
@Repository
public interface ClerkRepository extends BaseRepository<Clerk,Integer> {
    Clerk findByUsername(String username);
}
