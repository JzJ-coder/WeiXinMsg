package com.example.weixin.pojo;

/**
 * 测试号信息实体类，用来获取access_token
 */
public class Token {
    private String appID="wxd1adc2f24dd92d04";
    private String appsecret="527ac8d57e41dda55739f74bc9d8d7d8";

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public static Token instance(){
        return new Token();
    }
}
