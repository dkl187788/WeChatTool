package com.dukl.wechat.web.processor;

import com.google.gson.Gson;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by adu on 2019/5/19
 */
public abstract class AbstractHandler implements WxMpMessageHandler {
    protected final Gson gson = new Gson();
    protected Logger logger = LoggerFactory.getLogger(getClass());

}
