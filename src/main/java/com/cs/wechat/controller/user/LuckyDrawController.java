package com.cs.wechat.controller.user;

import com.cs.wechat.domain.dto.PrizeInfo;
import com.cs.wechat.domain.model.Prize;
import com.cs.wechat.domain.model.PrizeRecord;
import com.cs.wechat.service.MemberService;
import com.cs.wechat.service.PrizeService;
import com.cs.wechat.service.ChanceService;
import com.cs.wechat.service.PrizeRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cs on 2017/8/10.
 */
@RestController
@RequestMapping("/user/luckyDraw")
@Api(description = "抽奖模块")
@Slf4j
public class LuckyDrawController {
    @Autowired
    ChanceService chanceService;
    @Autowired
    MemberService memberService;
    @Autowired
    PrizeRecordService prizeRecordService;
    @Autowired
    PrizeService prizeService;
    /*@PutMapping
    public String luckyDraw(@RequestParam("id") String openId){
        awardService.add(openId,-1,0);
        memberService.changeChance(openId,-1);
        return "success";
    }*/
    @PostMapping
    @ApiOperation(value="抽奖", notes="抽奖")
    public String luckyDraw(@RequestBody PrizeInfo prizeInfo){
        String openId = prizeInfo.getOpenId();

        //Integer prizeId = prizeInfo.getPrizeId();
        if(memberService.changeChance(openId,-1)){
            chanceService.reduce(openId);
            prizeRecordService.add(prizeInfo);
            return "success";
        }
        else
            return "no chance";

    }

    @GetMapping("/record")
    @ApiOperation(value="显示还未兑现的奖品", notes="根据openId显示还未兑现的奖品")
    public List<PrizeRecord> listNoGet(@RequestParam("id") String openId){
        return prizeRecordService.listMine(openId,1);
    }

    @GetMapping("get")
    //@RequestMapping(value="get", method=RequestMethod.GET)
    @ApiOperation(value="显示已经兑现的奖品", notes="根据openId显示已经兑现的奖品")
    public List<PrizeRecord> listGet(@RequestParam("id") String openId){
        return prizeRecordService.listMine(openId,2);
    }

    @GetMapping
    public List<Prize> getAll(){

        List<Prize> prizes = prizeService.listAll();
        prizes.remove(0);
        return prizes;
    }
}
