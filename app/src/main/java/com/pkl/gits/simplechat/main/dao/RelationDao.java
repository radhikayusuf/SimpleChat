package com.pkl.gits.simplechat.main.dao;

/**
 * Created by Varokah on 10/21/2016.
 */

public class RelationDao {
    private String friend_state;

    public RelationDao(String friend_state) {
        this.friend_state = friend_state;
    }

    public String getFriend_state() {
        return friend_state;
    }

    public void setFriend_state(String friend_state) {
        this.friend_state = friend_state;
    }
}
