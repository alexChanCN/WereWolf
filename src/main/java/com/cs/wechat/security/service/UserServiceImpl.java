package com.cs.wechat.security.service;

import com.cs.wechat.core.BaseServiceImpl;
import com.cs.wechat.security.repository.UserRepository;
import com.cs.wechat.pojo.dto.PwdInfo;
import com.cs.wechat.security.entity.User;
import com.cs.wechat.utils.EncodePwdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * Created by cs on 2017/8/25.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User,Integer> implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public Integer save(User model) {
        String pwd = model.getPassword();
        model.setPassword(EncodePwdUtils.toEncode(pwd));
        userRepository.save(model);
        return 1;
    }

    @Override
    public String changePwd(PwdInfo pwdInfo) {
        String oldPwd = pwdInfo.getOldPwd();
        User user = userRepository.findByUsername(pwdInfo.getUsername());

        if(user == null) return "no user!";
        String currentPwd = user.getPassword();

        if(EncodePwdUtils.decode(oldPwd,currentPwd)){
            String newPwd = EncodePwdUtils.toEncode(pwdInfo.getNewPwd());
            user.setPassword(newPwd);
            userRepository.save(user);
            return "success";
        }
        else
            return "password error!";
    }
}
