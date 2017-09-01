package com.cs.wechat.service;

import com.cs.wechat.core.BaseService;
import com.cs.wechat.domain.model.Clerk;

/**
 * Created by cs on 2017/8/31.
 */
public interface ClerkService extends BaseService<Clerk,Integer> {
    Clerk findByUsername(String username);
}
