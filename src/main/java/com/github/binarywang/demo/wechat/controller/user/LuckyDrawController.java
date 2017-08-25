package com.github.binarywang.demo.wechat.controller.user;

import com.github.binarywang.demo.wechat.domain.dto.PrizeInfo;
import com.github.binarywang.demo.wechat.domain.model.Prize;
import com.github.binarywang.demo.wechat.service.ChanceService;
import com.github.binarywang.demo.wechat.service.MemberService;
import com.github.binarywang.demo.wechat.service.PrizeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cs on 2017/8/10.
 */
@RestController
@RequestMapping("/user/luckyDraw")
@Api(description = "抽奖模块")
public class LuckyDrawController {
    @Autowired
    ChanceService chanceService;
    @Autowired
    MemberService memberService;
    @Autowired
    PrizeService prizeService;
    /*@PutMapping
    public String luckyDraw(@RequestParam("id") String openId){
        awardService.add(openId,-1,0);
        memberService.changeChance(openId,-1);
        return "success";
    }*/
    @PutMapping
    @ApiOperation(value="抽奖", notes="抽奖")
    public String luckyDraw(@RequestBody PrizeInfo prizeInfo){
        String openId = prizeInfo.getOpenId();
        Integer prizeId = prizeInfo.getPrizeId();
        if(memberService.changeChance(openId,-1)){
            chanceService.add(openId,-1,0);
            prizeService.add(openId,prizeId);
            return "success";
        }
        else
            return "no chance";

    }

    @GetMapping
    @ApiOperation(value="显示还未兑现的奖品", notes="根据openId显示还未兑现的奖品")
    public List<Prize> listNoGet(@RequestParam("id") String openId){
        return prizeService.listMine(openId,0);
    }

    @GetMapping("get")
    //@RequestMapping(value="get", method=RequestMethod.GET)
    @ApiOperation(value="显示已经兑现的奖品", notes="根据openId显示已经兑现的奖品")
    public List<Prize> listGet(@RequestParam("id") String openId){
        return prizeService.listMine(openId,1);
    }
}
