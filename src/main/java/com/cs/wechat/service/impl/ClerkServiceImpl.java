package com.cs.wechat.service.impl;

import com.cs.wechat.core.BaseServiceImpl;
import com.cs.wechat.domain.model.Clerk;
import com.cs.wechat.repository.ClerkRepository;
import com.cs.wechat.service.ClerkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cs on 2017/8/31.
 */
@Service
public class ClerkServiceImpl extends BaseServiceImpl<Clerk,Integer> implements ClerkService {

    @Autowired
    ClerkRepository clerkRepository;
    @Override
    public Clerk findByUsername(String username) {
        return clerkRepository.findByUsername(username);
    }
}
