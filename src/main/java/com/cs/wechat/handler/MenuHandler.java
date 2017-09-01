package com.cs.wechat.handler;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSession;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutNewsMessage;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class MenuHandler extends AbstractHandler {

    /*@Autowired
    private UserService userService;*/

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {

        String msg = String.format("type:%s, event:%s, key:%s",
                wxMessage.getMsgType(), wxMessage.getEvent(),
                wxMessage.getEventKey());
        /*if (WxConsts.BUTTON_VIEW.equals(wxMessage.getEvent())) {
            return null;
        }*/
        try {
            System.out.println(weixinService.getAccessToken());
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        if (wxMessage.getEventKey().equals("ID")) {
            //System.out.println(wxMessage.getEventKey());
            String userId = "您的OpenId是: " + wxMessage.getFromUser();
            return WxMpXmlOutMessage.TEXT().content(userId)
                    .fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
                    .build();
        } /*else if (wxMessage.getEventKey().equals("PIC")) {
            String userId = wxMessage.getFromUser();
            String picUrl = userService.findBy("openId", userId).getHeadImgUrl();
            System.out.println(picUrl);
            return WxMpXmlOutMessage.TEXT().content(picUrl)
                    .fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
                    .build();

        } */else if (wxMessage.getEventKey().equals("PROFILE")) {
            WxMpXmlOutNewsMessage.Item item = new WxMpXmlOutNewsMessage.Item();
            item.setDescription("个人信息查询");
            item.setPicUrl("http://shine1.tunnel.qydev.com/1.jpg");
            item.setTitle("个人资料");
            item.setUrl("http://shine1.tunnel.qydev.com/hello?openId=" + wxMessage.getFromUser());
            WxSession ws = sessionManager.getSession(wxMessage.getFromUser());
            ws.setAttribute("username",wxMessage.getFromUser());

            return WxMpXmlOutMessage.NEWS()
                    .fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
                    .addArticle(item)
                    .build();
        } else
            return WxMpXmlOutMessage.TEXT().content(msg)
                    .fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
                    .build();
    }

}
