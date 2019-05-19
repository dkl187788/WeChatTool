package com.dukl.wechat.web.service;

import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

/**
 * Created by adu on 2019/5/19.
 */
public interface WeixinService {
    WxMpXmlOutMessage route(WxMpXmlMessage message);

    boolean hasKefuOnline();
}
