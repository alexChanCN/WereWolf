package com.cs.wechat.web.user;

import com.cs.wechat.pojo.dto.CommentInfo;
import com.cs.wechat.service.CommentService;
import com.cs.wechat.domain.entity.Comment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cs on 2017/8/8.
 */
@RestController
@RequestMapping("/user/comment")
@Api(description = "评论模块")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/{id}")
    @ApiOperation(value="获取评论", notes="根据教练ID，获取所有评论")
    public List<Comment> findByTeacher(@PathVariable Integer id){
        return commentService.findByTeacher(id);
    }

    @PostMapping
    @ApiOperation(value="添加评论", notes="根据CommentInfo对象添加评论")
    public String add(@RequestBody CommentInfo commentInfo){
        commentService.add(commentInfo);
        return "success";
    }
}
