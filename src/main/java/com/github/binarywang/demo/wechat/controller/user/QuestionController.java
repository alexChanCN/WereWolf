package com.github.binarywang.demo.wechat.controller.user;

import com.github.binarywang.demo.wechat.domain.dto.AnswerInfo;
import com.github.binarywang.demo.wechat.domain.dto.QuestionInfo;
import com.github.binarywang.demo.wechat.domain.model.Question;
import com.github.binarywang.demo.wechat.service.ChanceService;
import com.github.binarywang.demo.wechat.service.MemberService;
import com.github.binarywang.demo.wechat.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cs on 2017/8/9.
 */
@RestController
@RequestMapping("/user/question")
@Api(description = "答题模块")
public class QuestionController {

    @Autowired
    ChanceService awardService;
    @Autowired
    MemberService memberService;
    @Autowired
    QuestionService questionService;

    @PutMapping("/answer")
    @ApiOperation(value="答题", notes="填写answerInfo信息，回答问题")
    public String answer(@RequestBody  AnswerInfo answerInfo){
        Integer id = answerInfo.getId();
        String answer = answerInfo.getAnswer();
        String openId = answerInfo.getOpenId();
        if(questionService.compareAnswer(id,answer)){
        memberService.changeChance(openId,1);
        awardService.add(openId,1,2);//1:加一次chance  2：答题
            return "success";
        }
        else
            return "answer error";
    }

    @GetMapping("{id}")
    @ApiOperation(value="获取题目信息", notes="根据题目Id，获取题目信息")
    public Question getById(@PathVariable  Integer id){
        return questionService.get(id);
    }

    @GetMapping
    @ApiOperation(value="获取题目信息", notes="获取最新题目信息")
    public QuestionInfo getTop(){
        return questionService.getTop();
    }

    @GetMapping("/random")
    @ApiOperation(value="获取题目信息", notes="随机获取题目信息")
    public QuestionInfo getRandom(){
        return questionService.getRandom();
    }
}
