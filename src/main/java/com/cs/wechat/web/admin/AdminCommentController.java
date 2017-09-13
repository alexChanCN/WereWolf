package com.cs.wechat.web.admin;

import com.cs.wechat.core.BaseController;
import com.cs.wechat.domain.entity.Teacher;
import com.cs.wechat.service.CommentService;
import com.cs.wechat.domain.entity.Comment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cs on 2017/8/8.
 */
@RestController
@RequestMapping("/admin/comment")
@Api(description = "评论管理模块")
public class AdminCommentController extends BaseController<Comment,Integer>{
    @Autowired
    CommentService commentService;


    @GetMapping("/teacher")
    @ApiOperation(value="根据教练ID，获取该教练的所有评论", notes="根据教练ID，获取该教练的所有评论")
    public Page<Comment> findByTeacher(@RequestParam String name,@RequestParam Integer start,@RequestParam Integer size){
        Teacher teacher = new Teacher();
        teacher.setName(name);
        Comment comment = new Comment();
        comment.setTeacher(teacher);
        return commentService.findByMatcher(comment,"teacher.name",new PageRequest(start,size));
    }
}
