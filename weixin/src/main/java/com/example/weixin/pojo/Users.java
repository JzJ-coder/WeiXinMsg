package com.example.weixin.pojo;

import java.util.List;
import java.util.Map;

/**
 * 创建关注用户实体类
 */
public class Users {
    //关注该公众账号的总用户数
    private Long total;
    //拉取的OPENID个数，最大值为10000
    private Long count;
    //列表数据，OPENID的列表
    private Map<String, List<String>> data;
    //拉取列表的最后一个用户的OPENID(分页时有用)
    private String next_openid;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Map<String, List<String>> getData() {
        return data;
    }

    public void setData(Map<String, List<String>> data) {
        this.data = data;
    }

    public String getNext_openid() {
        return next_openid;
    }

    public void setNext_openid(String next_openid) {
        this.next_openid = next_openid;
    }
}
