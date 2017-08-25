package com.github.binarywang.demo.wechat.service.impl;

import com.github.binarywang.demo.wechat.domain.model.Teacher;
import com.github.binarywang.demo.wechat.repository.TeacherRepository;
import com.github.binarywang.demo.wechat.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cs on 2017/8/4.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public Integer save(Teacher model) {
        return null;
    }

    @Override
    public void saveOrUpdate(Teacher model) {

    }

    @Override
    public void update(Teacher model) {

    }

    @Override
    public void merge(Teacher model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void deleteObject(Teacher model) {

    }

    @Override
    public Teacher get(Integer id) {
        return teacherRepository.findOne(id);
    }

    @Override
    public int countAll() {
        return 0;
    }

    @Override
    public List<Teacher> listAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Page<Teacher> findByPage(Integer start, Integer size) {
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
}
