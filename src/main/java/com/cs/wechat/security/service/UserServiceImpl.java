package com.cs.wechat.security.service;

import com.cs.wechat.security.repository.UserRepository;
import com.cs.wechat.domain.vo.PwdInfo;
import com.cs.wechat.domain.entity.User;
import com.cs.wechat.utils.EncodePwdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cs on 2017/8/25.
 */
@Service
public class UserServiceImpl implements UserService{

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
    public void saveOrUpdate(User model) {

    }

    @Override
    public void update(User model) {

    }

    @Override
    public void merge(User model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void deleteObject(User model) {

    }

    @Override
    public User get(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public int countAll() {
        return 0;
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> findByPage(Integer start, Integer size) {
        return null;
    }

    @Override
    public Page<User> findByExample(User user, PageRequest pageRequest) {
        return null;
    }

    @Override
    public Page<User> findByMatcher(User user, String name, PageRequest pageRequest) {
        return null;
    }

    @Override
    public boolean exists(Integer id) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public void clear() {

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
