package com.dukl.wechat.web.config;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by adu on 2019/5/19.
 */
@Configurable
@Component
public class SystemBeanConfig {

    @Bean(name = "wxMpService")
    public WxMpService wxMpService(){
        return new WxMpServiceImpl();
    }
}


