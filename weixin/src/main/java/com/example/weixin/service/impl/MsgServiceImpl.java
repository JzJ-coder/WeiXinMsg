package com.example.weixin.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.weixin.pojo.MsgTemp;
import com.example.weixin.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MsgServiceImpl implements MsgService {
    //注入RestTemplate对象
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void sendMsg(String access_token, List<String> users) {
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token;


        Map<String, String> name = MsgTemp.templateData("笑笑", "#173177");
        Map<String, String> sex = MsgTemp.templateData("女", "#173177");
        Map<String, String> hobby = MsgTemp.templateData("小杰", "#173177");
        Map<String, String> boyfriend = MsgTemp.templateData("小杰", "#173177");

        //给模板数据赋值
        Map<String, Map<String,String>> map = new HashMap<>();
        map.put("name",name);
        map.put("sex",sex);
        map.put("hobby",hobby);
        map.put("boyfriend",boyfriend);


        //给实体类赋值
        MsgTemp msgTemp = new MsgTemp();
        msgTemp.setTemplate_id("EiwOEuB5--DCg3eQ3mOAwCjW5zwocPweTeU0BUmAGv0");
        msgTemp.setUrl("www.baidu.com");
        //将模板数据封装
        msgTemp.setData(map);

        //创建HttpHeaders对象，封装请求头信息
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        //遍历微信公众号用户集合
        for (String openid : users){
            msgTemp.setTouser(openid);
            //将msg转换成json格式
            String jsonString = JSON.toJSONString(msgTemp);
            //封装请求体和请求头
            HttpEntity<String> entity = new HttpEntity<String>(jsonString,headers);
            String msg = restTemplate.postForObject(url, entity, String.class);
            System.out.println(msg);
        }

    }
}

