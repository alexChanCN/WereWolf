package com.cs.wechat;

import com.cs.wechat.pojo.dto.PwdInfo;
import com.cs.wechat.security.entity.Authority;
import com.cs.wechat.security.entity.User;
import com.cs.wechat.security.service.UserService;
import com.cs.wechat.utils.EncodePwdUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cs on 2017/8/25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WxMpDemoApplication.class)
public class TestUser {

    @Autowired
    UserService userService;

    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("cs");
        user.setPassword("cscscs");
        List<Authority> authorities = new ArrayList<Authority>();
        Authority authority = new Authority();
        authority.setId(1);
        authorities.add(authority);
        user.setAuthorities(authorities);
        //userService.save(user);
    }

    @Test
    public void testEncode(){
        System.out.println(EncodePwdUtils.toEncode("cscscs"));
        System.out.println(EncodePwdUtils.toEncode("cscscs"));
        System.out.println(EncodePwdUtils.toEncode("cscscs"));
    }
    @Test
    public void get(){
        String old = userService.get(1).getPassword();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.matches("123456",old));
    }

    @Test
    public void update(){
        PwdInfo pwdInfo = new PwdInfo("cs","cscscs","123456");
        System.out.println(userService.changePwd(pwdInfo));
    }

}
