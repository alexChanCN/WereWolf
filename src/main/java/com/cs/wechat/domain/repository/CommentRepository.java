package com.cs.wechat.domain.repository;

import com.cs.wechat.core.BaseRepository;
import com.cs.wechat.domain.entity.Comment;
import com.cs.wechat.domain.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cs on 2017/8/4.
 */
@Repository
public interface CommentRepository extends BaseRepository<Comment,Integer> {
    List<Comment> findByTeacherOrderByIdDesc(Teacher t);

}
