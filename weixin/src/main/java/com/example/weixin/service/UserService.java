package com.example.weixin.service;

import com.example.weixin.pojo.Users;

public interface UserService {
    /**
     * 获取关注公众号的用户
     */
    public Users loadUsers(String access_token);
}
