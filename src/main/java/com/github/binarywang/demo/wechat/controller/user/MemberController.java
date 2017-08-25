package com.github.binarywang.demo.wechat.controller.user;

import com.github.binarywang.demo.wechat.domain.dto.RegisterInfo;
import com.github.binarywang.demo.wechat.domain.model.Member;
import com.github.binarywang.demo.wechat.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @PostMapping
    @ApiOperation(value="注册会员", notes="根据registerInfo信息注册成为会员;必须先关注公众号,即subscriber表中有对应openId字段")
    public String register(@RequestBody RegisterInfo registerInfo){
        memberService.registry(registerInfo);
        return "success";
    }

    /*@GetMapping("/{id}")
    public Member getOne(@PathVariable Integer id){
        return memberService.get(id);
    }*/
    @GetMapping("/{openId}")
    @ApiOperation(value="获取会员信息", notes="根据openId，获取该会员信息")
    public Member getOne(@PathVariable String openId){
        return memberService.findByOpenId(openId);
    }

     /* @Autowired
    private UserService userService;
    @GetMapping
    public String index(ModelMap map,@RequestParam  String openId) {
       User user = userService.findBy("openId",openId);
        String nickName = user.getNickName();
        String headImgUrl = user.getHeadImgUrl();
        // 加入一个属性，用来在模板中读取
        map.addAttribute("nickName", nickName);
        map.addAttribute("headImgUrl", headImgUrl);
        // return模板文件的名称，对应src/main/resources/templates/index.html
        //map.addAttribute("user", user);
        return "index";
    }
*/

}
