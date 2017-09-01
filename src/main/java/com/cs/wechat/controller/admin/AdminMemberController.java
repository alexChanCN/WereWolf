package com.cs.wechat.controller.admin;

import com.cs.wechat.domain.model.Member;
import com.cs.wechat.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cs on 2017/8/4.
 */
@RestController
@RequestMapping("/admin/member")
@Api(description = "会员管理模块")
public class AdminMemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/page")
    @ApiOperation(value="分页获取会员信息", notes="分页获取会员信息")
    public Page<Member> findByPage(@RequestHeader("Authorization")String authorization,@RequestParam Integer start, @RequestParam Integer size){
        return memberService.findByPage(start, size);
    }

    @GetMapping()
    @ApiOperation(value="获取所有会员信息", notes="获取所有会员信息")
    public List<Member> findAll(@RequestHeader("Authorization")String authorization){
        return memberService.listAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value="根据id，获取该会员信息", notes="根据id，获取该会员信息")
    public Member getOne(@RequestHeader("Authorization")String authorization,@PathVariable Integer id){
        return memberService.get(id);
    }

    @PostMapping
    @ApiOperation(value="添加", notes="根据Member,添加奖品信息")
    public String add(@RequestHeader("Authorization")String authorization,@RequestBody Member member){
        memberService.save(member);
        return "success";
    }

    @PutMapping
    @ApiOperation(value="修改", notes="根据Member,修改会员信息")
    public String update(@RequestHeader("Authorization")String authorization,@RequestBody Member member){
        memberService.update(member);
        return "success";
    }


    @DeleteMapping
    @ApiOperation(value="删除", notes="根据id,删除会员信息")
    public String delete(@RequestHeader("Authorization")String authorization,@PathVariable Integer id){
        memberService.delete(id);
        return "success";
    }

}
