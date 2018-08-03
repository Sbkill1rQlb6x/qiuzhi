package com.gs.qiuzhi.pojo;

public class User {
    private int user_id;
    private String user_phone;
    private String email;
    private String user_pass;
    private int remark;
    private int user_flag;
    private String nickName;
    private String user_face;
    private  String user_onlyId;
    private  int user_share_count;
    private int user_collect_count;

    public int getUser_share_count() {
        return user_share_count;
    }

    public void setUser_share_count(int user_share_count) {
        this.user_share_count = user_share_count;
    }

    public int getUser_collect_count() {
        return user_collect_count;
    }

    public void setUser_collect_count(int user_collect_count) {
        this.user_collect_count = user_collect_count;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public int getRemark() {
        return remark;
    }

    public void setRemark(int remark) {
        this.remark = remark;
    }

    public int getUser_flag() {
        return user_flag;
    }

    public void setUser_flag(int user_flag) {
        this.user_flag = user_flag;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUser_face() {
        return user_face;
    }

    public void setUser_face(String user_face) {
        this.user_face = user_face;
    }

    public String getUser_onlyId() {
        return user_onlyId;
    }

    public void setUser_onlyId(String user_onlyId) {
        this.user_onlyId = user_onlyId;
    }
}
