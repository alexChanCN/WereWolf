package com.cs.wechat.service.impl;

import com.cs.wechat.core.BaseServiceImpl;
import com.cs.wechat.domain.vo.CommentInfo;
import com.cs.wechat.domain.model.Comment;
import com.cs.wechat.domain.model.Teacher;
import com.cs.wechat.repository.CommentRepository;
import com.cs.wechat.service.CommentService;
import com.cs.wechat.service.MemberService;
import com.cs.wechat.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by cs on 2017/8/8.
 */
@Service
public class CommentServiceImpl extends BaseServiceImpl<Comment,Integer> implements CommentService{
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    TeacherService teacherService;
    @Autowired
    MemberService memberService;

    @Override
    public Integer add(CommentInfo commentInfo) {
        Integer teacherId = commentInfo.getTeacherId();
        String words = commentInfo.getComment();
        Date date = new Date();
        String openId = commentInfo.getOpenId();
        /*openId = OpenIdUtils.sub(openId);
        System.out.println(openId);*/
        Comment comment = new Comment();
        comment.setMember(memberService.findByOpenId(openId));
        comment.setComment(words);
        comment.setTeacher(teacherService.get(teacherId));
        comment.setTime(date);
        commentRepository.save(comment);
        return 1;
    }

    @Override
    public List<Comment> findByTeacher(Integer teacherId) {
        Teacher teacher = new Teacher();
        teacher.setId(teacherId);
        return commentRepository.findByTeacherOrderByIdDesc(teacher);
    }


}
