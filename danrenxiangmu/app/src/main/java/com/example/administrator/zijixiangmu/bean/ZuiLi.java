package com.example.administrator.zijixiangmu.bean;

/**
 * Created by Administrator on 2018/5/31.
 */

public class ZuiLi {


    /**
     * createTime : 2018-05-30T13:29:30.200Z
     * updateTime : 2018-05-30T13:29:30.200Z
     * userId : 0
     * password : string
     * phone : string
     * nickName : string
     * ticket : string
     * profileImageUrl : string
     * status : 0
     * realName : string
     * birth : 2018-05-30T13:29:30.200Z
     * balance : 0
     */

    private String createTime;
    private String updateTime;
    private int userId;
    private String password;
    private String phone;
    private String nickName;
    private String ticket;
    private String profileImageUrl;
    private int status;
    private String realName;
    private String birth;
    private int balance;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
