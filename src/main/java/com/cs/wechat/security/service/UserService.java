package com.cs.wechat.security.service;

import com.cs.wechat.core.BaseService;
import com.cs.wechat.domain.vo.PwdInfo;
import com.cs.wechat.domain.entity.User;

/**
 * Created by cs on 2017/8/25.
 */
public interface UserService extends BaseService<User,Integer> {
    String changePwd(PwdInfo pwdInfo);
}
