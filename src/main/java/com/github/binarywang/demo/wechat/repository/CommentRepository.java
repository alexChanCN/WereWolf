package com.github.binarywang.demo.wechat.repository;

import com.github.binarywang.demo.wechat.domain.model.Comment;
import com.github.binarywang.demo.wechat.domain.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cs on 2017/8/4.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer>{
    List<Comment> findByTeacher(Teacher t);

}
