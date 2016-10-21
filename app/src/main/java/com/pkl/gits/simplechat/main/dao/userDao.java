package com.pkl.gits.simplechat.main.dao;

/**
 * Created by Varokah on 10/21/2016.
 */

public class UserDao {
    private String nama,status;

    public UserDao(String nama, String status) {
        this.nama = nama;
        this.status = status;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
