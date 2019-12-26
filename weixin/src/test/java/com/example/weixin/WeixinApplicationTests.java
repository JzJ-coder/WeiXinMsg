package com.example.weixin;

import com.example.weixin.pojo.MsgTemp;
import com.example.weixin.pojo.Token;
import com.example.weixin.pojo.Users;
import com.example.weixin.service.MsgService;
import com.example.weixin.service.TokenService;
import com.example.weixin.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class WeixinApplicationTests {

    @Test
    void contextLoads() {
    }

    //注入service对象
    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @Autowired
    private MsgService msgService;

    @Test
    public void getAccessToken(){
        Map<String, Object> map = tokenService.getAccessTokenService(Token.instance());
        //打印access_token后面都会用到
        System.out.println(map.get("access_token"));
        //有效时间（默认2小时）
        System.out.println(map.get("expires_in"));

        Users users = userService.loadUsers((String) map.get("access_token"));
        //获取关注该公众号的用户
        System.out.println(users.getData());

        //获取accesstoken
        String access_token = (String) map.get("access_token");
        //获取关注用户的id
        List<String> openid = users.getData().get("openid");

        //发送模板信息
        msgService.sendMsg(access_token,openid);

    }
}
