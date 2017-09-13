package com.cs.wechat.web.admin;

import com.cs.wechat.core.BaseController;
import com.cs.wechat.domain.entity.Member;
import com.cs.wechat.domain.entity.PrizeRecord;
import com.cs.wechat.service.PrizeRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


/**
 * Created by cs on 2017/8/10.
 */
@RestController
@RequestMapping("/admin/lucky")
@Api(description = "抽奖管理模块")
public class AdminLuckyDrawController extends BaseController<PrizeRecord,Integer> {

    @Autowired
    PrizeRecordService prizeRecordService;


    @GetMapping("/name")
    @ApiOperation(value = "根据姓名，分页查询", notes = "根据姓名，分页查询")
    public Page<PrizeRecord> findByName(@RequestParam String name, @RequestParam Integer start, @RequestParam Integer size) {
        PrizeRecord prizeRecord = new PrizeRecord();
        Member member = new Member();
        member.setName(name);
        prizeRecord.setMember(member);
        return prizeRecordService.findByMatcher(prizeRecord,"member.name",new PageRequest(start,size));
    }

    @GetMapping("/status")
    @ApiOperation(value = "根据状态,分页查询", notes = "根据状态,分页查询")
    public Page<PrizeRecord> findByStatus(@RequestParam Integer status, @RequestParam Integer start, @RequestParam Integer size) {
        PrizeRecord prizeRecord = new PrizeRecord();
        prizeRecord.setStatus(status);
        return prizeRecordService.findByExample(prizeRecord,new PageRequest(start,size));
    }


    @PutMapping("{id}")
    @ApiOperation(value = "确认领取", notes = "根据ID,修改奖品记录，确认领取")
    public String updateById(@PathVariable Integer id,@RequestHeader("Authorization")String authorization) {
        if (prizeRecordService.updateById(id))
            return "success";
        else
            return "false";
    }



}
