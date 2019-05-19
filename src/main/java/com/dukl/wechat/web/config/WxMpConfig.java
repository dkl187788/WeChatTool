package com.dukl.wechat.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by adu on 2019/5/19
 */
@Component
@ConfigurationProperties(prefix = "wx")
public class WxMpConfig {
    //@Value("${token}")
    private String token;

    //@Value("${appid}")
    private String appid;

    //@Value("${appsecret}")
    private String appSecret;

    //@Value("${aeskey}")
    private String aesKey;

    public String getToken() {
        return this.token;
    }

    public String getAppid() {
        return this.appid;
    }

    public String getAppSecret() {
        return this.appSecret;
    }

    public String getAesKey() {
        return this.aesKey;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public void setAesKey(String aesKey) {
        this.aesKey = aesKey;
    }

    @Override
    public String toString() {
        return "WxMpConfig{" +
                "token='" + token + '\'' +
                ", appid='" + appid + '\'' +
                ", appSecret='" + appSecret + '\'' +
                ", aesKey='" + aesKey + '\'' +
                '}';
    }
}
