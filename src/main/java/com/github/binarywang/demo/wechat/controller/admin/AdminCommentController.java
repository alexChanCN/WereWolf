package com.github.binarywang.demo.wechat.controller.admin;

import com.github.binarywang.demo.wechat.domain.model.Comment;
import com.github.binarywang.demo.wechat.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cs on 2017/8/8.
 */
@RestController
@RequestMapping("/admin/comment")
@Api(description = "评论管理模块")
public class AdminCommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/page")
    @ApiOperation(value="分页获取评论", notes="分页获取评论")
    public Page<Comment> findByPage(@RequestParam Integer start, @RequestParam Integer size){
        return commentService.findByPage(start, size);
    }

    @GetMapping()
    @ApiOperation(value="获取所有评论", notes="获取所有评论")
    public List<Comment> findAll(){
        return commentService.listAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value="根据ID获取评论", notes="根据评论的ID，获取评论")
    public Comment findById(@PathVariable Integer id){
        return commentService.get(id);
    }

    @GetMapping("/teacher")
    @ApiOperation(value="根据教练ID，获取该教练的所有评论", notes="根据教练ID，获取该教练的所有评论")
    public List<Comment> findByTeacher(@RequestParam Integer id){
        return commentService.findByTeacher(id);
    }

    @PostMapping
    @ApiOperation(value="添加评论", notes="根据Comment添加评论")
    public String add(@RequestBody Comment comment){
        commentService.save(comment);
        return "success";
    }

    @PutMapping
    @ApiOperation(value="修改评论", notes="根据Comment修改评论")
    public String update(@RequestBody Comment comment){
        commentService.update(comment);
        return "success";
    }

    @DeleteMapping
    @ApiOperation(value="删除评论", notes="根据Comment删除评论")
    public String delete(@PathVariable Integer id){
        commentService.delete(id);
        return "success";
    }
}
