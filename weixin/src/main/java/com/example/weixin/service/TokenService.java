package com.example.weixin.service;

import com.example.weixin.pojo.Token;

import java.util.Map;

public interface TokenService {
    /**
     * 获取access_token
     */
    public Map<String,Object> getAccessTokenService(Token token);
}
