package com.example.weixin.service.impl;

import com.example.weixin.pojo.Users;
import com.example.weixin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
    //注入RestTemplate对象
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Users loadUsers(String access_token) {
        String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token="+access_token;
        return restTemplate.getForObject(url, Users.class);
    }
}
