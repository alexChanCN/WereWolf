package com.cs.wechat.service.impl;

import com.cs.wechat.core.BaseServiceImpl;
import com.cs.wechat.domain.model.Teacher;
import com.cs.wechat.repository.TeacherRepository;
import com.cs.wechat.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by cs on 2017/8/4.
 */
@Service
public class TeacherServiceImpl extends BaseServiceImpl<Teacher,Integer>implements TeacherService {

}
