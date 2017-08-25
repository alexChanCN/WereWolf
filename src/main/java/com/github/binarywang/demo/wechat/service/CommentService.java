package com.github.binarywang.demo.wechat.service;

import com.github.binarywang.demo.wechat.domain.dto.CommentInfo;
import com.github.binarywang.demo.wechat.domain.model.Comment;

import java.util.List;

/**
 * Created by cs on 2017/8/8.
 */
public interface CommentService extends CoreService<Comment,Integer> {
    Integer add(CommentInfo commentInfo);

    List<Comment> findByTeacher(Integer teacherId);
}
