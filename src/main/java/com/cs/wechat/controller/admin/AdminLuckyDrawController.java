package com.cs.wechat.controller.admin;

import com.cs.wechat.domain.model.Member;
import com.cs.wechat.domain.model.Prize;
import com.cs.wechat.domain.model.PrizeRecord;
import com.cs.wechat.service.PrizeRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cs on 2017/8/10.
 */
@RestController
@RequestMapping("/admin/lucky")
@Api(description = "抽奖管理模块")
public class AdminLuckyDrawController {

    @Autowired
    PrizeRecordService prizeRecordService;

    @GetMapping("/page")
    @ApiOperation(value = "分页获取奖品信息", notes = "分页获取奖品信息")
    public Page<PrizeRecord> findByPage(@RequestParam Integer start, @RequestParam Integer size) {
        return prizeRecordService.findByPage(start, size);
    }

    @GetMapping()
    @ApiOperation(value = "获取所有奖品信息", notes = "获取所有奖品信息")
    public List<PrizeRecord> findAll() {
        return prizeRecordService.listAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID，获取奖品信息", notes = "根据ID，获取奖品信息")
    public PrizeRecord findById(@PathVariable Integer id) {
        return prizeRecordService.get(id);
    }

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

    @PostMapping
    @ApiOperation(value = "添加", notes = "根据Prize,添加奖品记录")
    public String add(@RequestBody PrizeRecord prizeRecord,@RequestHeader("Authorization")String authorization) {
        prizeRecordService.save(prizeRecord);
        return "success";
    }

    @PutMapping
    @ApiOperation(value = "修改", notes = "根据Prize,修改奖品记录")
    public String update(@RequestBody PrizeRecord prizeRecord,@RequestHeader("Authorization")String authorization) {
        prizeRecordService.update(prizeRecord);
        return "success";
    }

    @PutMapping("{id}")
    @ApiOperation(value = "确认领取", notes = "根据ID,修改奖品记录，确认领取")
    public String updateById(@PathVariable Integer id,@RequestHeader("Authorization")String authorization) {
        if (prizeRecordService.updateById(id))
            return "success";
        else
            return "false";
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "删除", notes = "根据id,删除奖品记录")
    public String delete(@PathVariable Integer id,@RequestHeader("Authorization")String authorization) {
        prizeRecordService.delete(id);
        return "success";
    }


}
