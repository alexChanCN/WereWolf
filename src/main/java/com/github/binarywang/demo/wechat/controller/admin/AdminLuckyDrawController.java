package com.github.binarywang.demo.wechat.controller.admin;

import com.github.binarywang.demo.wechat.domain.model.Prize;
import com.github.binarywang.demo.wechat.service.PrizeService;
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
public class AdminLuckyDrawController {

    @Autowired
    PrizeService prizeService;

    @GetMapping("/page")
    @ApiOperation(value="分页获取奖品信息", notes="分页获取奖品信息")
    public Page<Prize> findByPage(@RequestParam Integer start, @RequestParam Integer size){
        return prizeService.findByPage(start, size);
    }

    @GetMapping()
    @ApiOperation(value="获取所有奖品信息", notes="获取所有奖品信息")
    public List<Prize> findAll(){
        return prizeService.listAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value="根据ID，获取奖品信息", notes="根据ID，获取奖品信息")
    public Prize findById(@PathVariable Integer id){
        return prizeService.get(id);
    }

    @GetMapping("/name")
    @ApiOperation(value="根据姓名,获取奖品信息", notes="根据姓名,获取奖品信息")
    public List<Prize> findByName(@RequestParam String name){
        System.out.println(name);
        return prizeService.findByName(name);
    }

    @GetMapping("/status/{status}")
    @ApiOperation(value="根据状态,获取奖品信息", notes="根据状态,获取奖品信息")
    public List<Prize> findByStatus(@PathVariable Integer status){
        return prizeService.findByStatus(status);
    }

    @PostMapping
    @ApiOperation(value="添加", notes="根据Prize,添加奖品记录")
    public String add(@RequestBody Prize prize){
        prizeService.save(prize);
        return "success";
    }

    @PutMapping
    @ApiOperation(value="修改", notes="根据Prize,修改奖品记录")
    public String update(@RequestBody Prize prize){
        prizeService.update(prize);
        return "success";
    }

    @PutMapping("/verify")
    @ApiOperation(value="修改", notes="领取奖品,即修改status为1")
    public String update(@PathVariable Integer id){
        prizeService.updateById(id);
        return "success";
    }

    @DeleteMapping
    @ApiOperation(value="删除", notes="根据id,删除奖品记录")
    public String delete(@PathVariable Integer id){
        prizeService.delete(id);
        return "success";
    }


}
