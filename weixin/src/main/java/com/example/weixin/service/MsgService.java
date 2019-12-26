package com.example.weixin.service;

import com.example.weixin.pojo.MsgTemp;
import com.example.weixin.pojo.Users;

import java.util.List;

public interface MsgService {
    /**
     * 发送模板消息
     */
    public void sendMsg(String access_token, List<String> users);
}
