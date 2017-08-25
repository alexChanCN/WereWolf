package com.github.binarywang.demo.wechat.security.service;

import com.github.binarywang.demo.wechat.domain.dto.PwdInfo;
import com.github.binarywang.demo.wechat.domain.entity.User;
import com.github.binarywang.demo.wechat.service.CoreService;

/**
 * Created by cs on 2017/8/25.
 */
public interface UserService extends CoreService<User,Integer>{
    String changePwd(PwdInfo pwdInfo);
}
