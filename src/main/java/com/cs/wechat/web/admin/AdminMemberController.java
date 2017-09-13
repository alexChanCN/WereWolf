package com.cs.wechat.web.admin;

import com.cs.wechat.core.BaseController;
import com.cs.wechat.domain.entity.Member;
import com.cs.wechat.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cs on 2017/8/4.
 */
@RestController
@RequestMapping("/admin/member")
@Api(description = "会员管理模块")
public class AdminMemberController extends BaseController<Member,Integer>{

    @Autowired
    MemberService memberService;

    @GetMapping("/name")
    @ApiOperation(value="根据姓名,分页查询", notes="根据姓名,分页查询")
    public Page<Member> findByName(@RequestParam String name,@RequestParam Integer start, @RequestParam Integer size){
        Member member = new Member();
        member.setName(name);
        return memberService.findByMatcher(member,"name",new PageRequest(start,size));
    }

}
