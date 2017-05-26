package com.somo.test.server.model;

/**
 * Created by yebonkim on 2017. 5. 25..
 */

public class Chat {
    String userId;
    String data;

    public Chat(String userId, String data) {
        this.userId = userId;
        this.data = data;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
