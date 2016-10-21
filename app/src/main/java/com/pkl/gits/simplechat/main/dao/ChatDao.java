package com.pkl.gits.simplechat.main.dao;

/**
 * Created by Varokah on 10/21/2016.
 */

public class ChatDao {
    private String message,time;

    public ChatDao(String message, String time) {
        this.message = message;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
