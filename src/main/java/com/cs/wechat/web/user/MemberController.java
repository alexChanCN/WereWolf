package com.cs.wechat.web.user;

import com.cs.wechat.pojo.dto.RegisterInfo;
import com.cs.wechat.domain.entity.Member;
import com.cs.wechat.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cs on 2017/8/4.
 */
@RestController
@RequestMapping("/user/member")
@Api(description = "会员模块")
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    WxMpService wxMpService;

    @PostMapping
    @ApiOperation(value="注册会员", notes="根据registerInfo信息注册成为会员;必须先关注公众号,即subscriber表中有对应openId字段")
    public String register(@RequestBody RegisterInfo registerInfo){
        if(memberService.registry(registerInfo))
            return "success";
        else
            return "error";
    }
    @PutMapping
    @ApiOperation(value="修改会员信息", notes="修改手机号码，只需填写openId和phoneNo字段")
    public String update(@RequestBody RegisterInfo registerInfo){
        Member member = memberService.findByOpenId(registerInfo.getOpenId());
        member.setPhoneNo(registerInfo.getPhoneNo());
       /* if(memberService.save(member) == 1)
        return "success";
        else
            return "error";*/
       return null;
    }

    @GetMapping("/{openId}")
    @ApiOperation(value="获取会员信息", notes="根据openId，获取该会员信息")
    public Member getOne(@PathVariable String openId){
        return memberService.findByOpenId(openId);
    }

     @GetMapping("/headUrl/{openId}")
     @ApiOperation(value="获取会员信息", notes="根据openId，获取该会员信息")
     public String getHeadUrl(@PathVariable String openId){
         String lang = "zh_CN"; //语言
         WxMpUser user = new WxMpUser();
         try {
              user = wxMpService.getUserService().userInfo(openId,lang);
         } catch (WxErrorException e) {
             e.printStackTrace();
         }
         return user.getHeadImgUrl();
     }


}
