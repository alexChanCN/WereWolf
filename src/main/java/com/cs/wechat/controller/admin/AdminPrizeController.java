package com.cs.wechat.controller.admin;

import com.cs.wechat.domain.model.Prize;
import com.cs.wechat.domain.model.PrizeRecord;
import com.cs.wechat.service.PrizeRecordService;
import com.cs.wechat.service.PrizeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cs on 2017/8/10.
 */
@RestController
@RequestMapping("/admin/prize")
@Api(description = "奖品管理模块")
public class AdminPrizeController {

    @Autowired
    PrizeService prizeService;

    @GetMapping()
    @ApiOperation(value = "获取所有奖品信息", notes = "获取所有奖品信息")
    public List<Prize> findAll() {
        return prizeService.listAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID，获取奖品信息", notes = "根据ID，获取奖品信息")
    public Prize findById(@PathVariable Integer id) {
        return prizeService.get(id);
    }


    @PostMapping
    @ApiOperation(value = "添加", notes = "添加奖品")
    public String add(@RequestBody Prize prize,@RequestHeader("Authorization")String authorization) {
        prizeService.save(prize);
        return "success";
    }

    @PutMapping
    @ApiOperation(value = "修改", notes = "修改奖品")
    public String update(@RequestBody Prize prize,@RequestHeader("Authorization")String authorization) {
        prizeService.update(prize);
        return "success";
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "删除", notes = "删除奖品")
    public String delete(@PathVariable Integer id,@RequestHeader("Authorization")String authorization) {
        prizeService.delete(id);
        return "success";
    }


}
