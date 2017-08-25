package com.github.binarywang.demo.wechat.controller.admin;

import com.github.binarywang.demo.wechat.domain.model.Question;
import com.github.binarywang.demo.wechat.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cs on 2017/8/9.
 */
@RestController
@RequestMapping("/admin/question")
@Api(description = "答题管理模块")
public class AdminQuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/page")
    @ApiOperation(value="分页获取题目信息", notes="分页获取题目信息")
    public Page<Question> findByPage(@RequestParam Integer start, @RequestParam Integer size){
        return questionService.findByPage(start, size);
    }

    @GetMapping()
    @ApiOperation(value="获取所有题目信息", notes="获取所有题目信息")
    public List<Question> findAll(){
        return questionService.listAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value="根据id，获取该题目信息", notes="根据id，获取该题目信息")
    public Question getOne(@PathVariable Integer id){
        return questionService.get(id);
    }

    @PostMapping
    @ApiOperation(value="添加", notes="根据question,添加题目信息")
    public String add(@RequestBody Question question){
        questionService.save(question);
        return "success";
    }

    @PutMapping
    @ApiOperation(value="修改", notes="根据question,修改题目信息")
    public String update(@RequestBody Question question){
        questionService.update(question);
        return "success";
    }


    @DeleteMapping
    @ApiOperation(value="删除", notes="根据id,删除题目信息")
    public String delete(@PathVariable Integer id){
        questionService.delete(id);
        return "success";
    }


}
