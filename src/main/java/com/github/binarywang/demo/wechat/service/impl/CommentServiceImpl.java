package com.github.binarywang.demo.wechat.service.impl;

import com.github.binarywang.demo.wechat.domain.dto.CommentInfo;
import com.github.binarywang.demo.wechat.domain.model.Comment;
import com.github.binarywang.demo.wechat.domain.model.Teacher;
import com.github.binarywang.demo.wechat.repository.CommentRepository;
import com.github.binarywang.demo.wechat.service.CommentService;
import com.github.binarywang.demo.wechat.service.MemberService;
import com.github.binarywang.demo.wechat.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by cs on 2017/8/8.
 */
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    TeacherService teacherService;
    @Autowired
    MemberService memberService;
    @Override
    public Integer save(Comment model) {
        return null;
    }

    @Override
    public void saveOrUpdate(Comment model) {

    }

    @Override
    public void update(Comment model) {
        commentRepository.save(model);
    }

    @Override
    public void merge(Comment model) {

    }

    @Override
    public void delete(Integer id) {
        commentRepository.delete(id);
    }

    @Override
    public void deleteObject(Comment model) {

    }

    @Override
    public Comment get(Integer id) {
        return commentRepository.findOne(id);
    }

    @Override
    public int countAll() {
        return 0;
    }

    @Override
    public List<Comment> listAll() {
        return commentRepository.findAll();
    }

    @Override
    public Page<Comment> findByPage(Integer start, Integer size) {
        return commentRepository.findAll(new PageRequest(start,size));
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
