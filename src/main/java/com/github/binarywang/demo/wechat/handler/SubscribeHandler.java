package com.github.binarywang.demo.wechat.handler;

import com.github.binarywang.demo.wechat.builder.TextBuilder;
import com.github.binarywang.demo.wechat.domain.model.Subscriber;
import com.github.binarywang.demo.wechat.repository.SubscriberRepository;
import com.github.binarywang.java.emoji.EmojiConverter;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class SubscribeHandler extends AbstractHandler {
    @Autowired
    SubscriberRepository subscriberRepository;
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) throws WxErrorException {

        this.logger.info("新关注用户 OPENID: " + wxMessage.getFromUser());

        // 获取微信用户基本信息
        WxMpUser userWxInfo = weixinService.getUserService()
                .userInfo(wxMessage.getFromUser(), null);

        if (userWxInfo != null) {
            // TODO 可以添加关注用户到本地
            Subscriber user = new Subscriber();
            String nickname = userWxInfo.getNickname();
            EmojiConverter emojiConverter = EmojiConverter.getInstance();
            nickname = emojiConverter.toAlias(nickname);

            /*try {
                nickname = Base64.encodeBase64String(nickname.getBytes("utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }*/
            // 出库后，使用 Base64 解码
            //nickname = new String(Base64.decodeBase64(nickname.getBytes()), "utf-8");
            user.setNickName(nickname);
            user.setCity(userWxInfo.getCity());
            user.setCountry(userWxInfo.getCountry());
            user.setGroupId(userWxInfo.getGroupId());
            user.setHeadImgUrl(userWxInfo.getHeadImgUrl());
            user.setOpenId(userWxInfo.getOpenId());
            user.setUnionId(userWxInfo.getUnionId());
            user.setLanguage(userWxInfo.getLanguage());
            user.setOpenId(userWxInfo.getOpenId());
            user.setProvince(userWxInfo.getProvince());
            user.setRemark(userWxInfo.getRemark());
            user.setSex(userWxInfo.getSex());
            user.setSexId(userWxInfo.getSexId());
            //user.setSubscribe(userWxInfo.getSubscribe());
            user.setSubscribeTime(userWxInfo.getSubscribeTime());
            //user.setTagIds(userWxInfo.getTagIds()));
            String OpenId = user.getOpenId();
            if(subscriberRepository.findByOpenId(OpenId) == null){
                subscriberRepository.save(user);
                System.out.println("写入数据成功!");
            }
            else
                System.out.println("已经写入数据库!");

        }

        WxMpXmlOutMessage responseResult = null;
        try {
            responseResult = handleSpecial(wxMessage);
        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
        }

        if (responseResult != null) {
            return responseResult;
        }

        try {
            return new TextBuilder().build("感谢关注", wxMessage, weixinService);
        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
        }

        return null;
    }

    /**
     * 处理特殊请求，比如如果是扫码进来的，可以做相应处理
     */
    private WxMpXmlOutMessage handleSpecial(WxMpXmlMessage wxMessage)
            throws Exception {
        //TODO
        return null;
    }

}
