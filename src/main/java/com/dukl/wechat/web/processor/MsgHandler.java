package com.dukl.wechat.web.processor;

import com.dukl.wechat.builder.TextBuilder;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.kefu.result.WxMpKfOnlineList;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by adu on 2019/5/19
 */
@Component
public class MsgHandler extends AbstractHandler {

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService wxMpService,
                                    WxSessionManager sessionManager) {


        if (!wxMessage.getMsgType().equals(WxConsts.XmlMsgType.EVENT)) {

        }

        //当用户输入关键词如“你好”，“客服”等，并且有客服在线时，把消息转发给在线客服
        String content = "服务繁忙，请稍后！";
        if (StringUtils.startsWithAny(wxMessage.getContent(), "你好", "客服")
                ) {
            boolean kfOnlineFlag = false;
            try {
                WxMpKfOnlineList kfOnlineList = wxMpService.getKefuService().kfOnlineList();
                kfOnlineFlag = kfOnlineList != null && kfOnlineList.getKfOnlineList().size() > 0;
            } catch (WxErrorException e) {
                logger.info("获取客服列表发生异常", e);
            }
            if (kfOnlineFlag) {
                return WxMpXmlOutMessage
                        .TRANSFER_CUSTOMER_SERVICE().fromUser(wxMessage.getToUser())
                        .toUser(wxMessage.getFromUser()).build();
            }
        } else {
            content = "您的消息内容是:" + wxMessage.getContent();
        }

        return new TextBuilder().build(content, wxMessage, wxMpService);

    }

}
