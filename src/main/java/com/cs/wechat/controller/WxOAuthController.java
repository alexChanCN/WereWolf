package com.cs.wechat.controller;

import com.cs.wechat.domain.model.Member;
import com.cs.wechat.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.net.URLEncoder;

/**
 * Created by cs on 2017/8/27.
 */
@Controller
@RequestMapping("/wechat")
@Slf4j
@ApiIgnore
public class WxOAuthController {

    @Autowired
    WxMpService wxMpService;
    @Autowired
    MemberService memberService;

    @GetMapping("/authorize")
    public String authorize(@RequestParam String returnUrl) {
        String url = "http://shine.tunnel.qydev.com/wechat/info";
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAUTH2_SCOPE_BASE, URLEncoder.encode(returnUrl));
        log.info("[redirectUrl]{}", redirectUrl);
        return "redirect:" + redirectUrl;
    }

    @GetMapping("/info")
    public String userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl) {
        System.out.println("jinlaile");
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        String openId = wxMpOAuth2AccessToken.getOpenId();
        Member member = memberService.findByOpenId(openId);
        String url = "http://shine.tunnel.qydev.com/#/signup";
        log.info("returnUrl{}",returnUrl);
        if (member == null) {
            return "redirect:" + url + "?openId=" + openId;
        } else
            return "redirect:" + returnUrl + "?openId=" + openId;

    }
}
