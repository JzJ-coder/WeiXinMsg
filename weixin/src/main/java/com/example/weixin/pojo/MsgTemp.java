package com.example.weixin.pojo;

import java.util.HashMap;
import java.util.Map;

/**
 * 封装需要发送的消息模板
 */
public class MsgTemp {
    //接收者openid
    private String touser;
    //模板ID
    private String template_id;
    //模板跳转链接（海外帐号没有跳转能力）
    private String url;
    //模板数据
    private Map<String,Map<String,String>> data;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, Map<String, String>> getData() {
        return data;
    }

    public void setData(Map<String, Map<String, String>> data) {
        this.data = data;
    }
    /**
     * 封装消息数据
     */
    public static Map<String,String> templateData(String value,String color){
        Map<String,String> map = new HashMap<>();
        //模板内容
        map.put("value",value);
        //模板内容字体颜色，不填默认为黑色
        map.put("color",color);
        return map;
    }
}
