package com.cs.wechat.controller.user;

import com.cs.wechat.service.MemberService;
import com.cs.wechat.domain.vo.AnswerResponse;
import com.cs.wechat.domain.vo.QuestionInfo;
import com.cs.wechat.domain.model.AnswerRecord;
import com.cs.wechat.domain.model.Question;
import com.cs.wechat.service.AnswerRecordService;
import com.cs.wechat.service.ChanceService;
import com.cs.wechat.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import static com.cs.wechat.core.ProjectConstant.*;

/**
 * Created by cs on 2017/8/9.
 */
@RestController
@RequestMapping("/user/question")
@Api(description = "答题模块")
@Slf4j
public class QuestionController {

    @Autowired
    ChanceService chanceService;
    @Autowired
    MemberService memberService;
    @Autowired
    QuestionService questionService;
    @Autowired
    AnswerRecordService answerRecordService;

    @PostMapping("/answer")
    @ApiOperation(value = "答题", notes = "填写answerInfo信息，回答问题")
    public Integer answer(@RequestBody AnswerResponse answerResponse) {

        Integer result = answerResponse.getResult();
        String openId = answerResponse.getOpenId();
        AnswerRecord answerRecord = new AnswerRecord();
        answerRecord.setDate(new Date());
        answerRecord.setOpenId(openId);
        answerRecord.setStatus(result);

        boolean isAnswer = answerRecordService.IsAnswer(openId);
        if (!isAnswer) {
            answerRecordService.save(answerRecord);
            if (result.equals(1)) {

                memberService.changeChance(openId, 1);
                chanceService.add(openId,ANSWER_QUESTION);//1:加一次chance  2：答题
            }
        } else
            return 0;

        return 1;
    }

    @GetMapping("{id}")
    @ApiOperation(value = "获取题目信息", notes = "根据题目Id，获取题目信息")
    public Question getById(@PathVariable Integer id) {
        return questionService.get(id);
    }

    @GetMapping
    @ApiOperation(value = "获取题目信息", notes = "获取最新题目信息")
    public QuestionInfo getTop() {
        return questionService.getTop();
    }

    @GetMapping("/random")
    @ApiOperation(value = "获取题目信息", notes = "随机获取题目信息")
    public QuestionInfo getRandom() {
        return questionService.getRandom();
    }

    @GetMapping("/count")
    @ApiOperation(value = "获取当天剩余答题次数", notes = "获取当天剩余答题次数")
    public Integer getCount(@RequestParam("openId") String openId) {
        if (answerRecordService.IsAnswer(openId))
            return 0;
        else
            return 1;
    }
}
