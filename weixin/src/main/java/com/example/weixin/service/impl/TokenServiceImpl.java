package com.example.weixin.service.impl;

import com.example.weixin.pojo.Token;
import com.example.weixin.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class TokenServiceImpl implements TokenService {
    //注入RestTemplate对象
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Map<String, Object> getAccessTokenService(Token token) {
        String url = "https://api.weixin.qq.com/cgi-bin/token" +
                "?grant_type=client_credential&appid="+token.getAppID()+"&secret="+token.getAppsecret();
        return restTemplate.getForObject(url,Map.class);
    }
}
