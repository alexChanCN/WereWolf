package com.cs.wechat.service;

import com.cs.wechat.core.BaseService;
import com.cs.wechat.pojo.dto.CommentInfo;
import com.cs.wechat.domain.entity.Comment;

import java.util.List;

/**
 * Created by cs on 2017/8/8.
 */
public interface CommentService extends BaseService<Comment,Integer> {
    Integer add(CommentInfo commentInfo);

    List<Comment> findByTeacher(Integer teacherId);
}
