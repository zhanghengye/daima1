package com.example.administrator.zijixiangmu.bean;

/**
 * Created by Administrator on 2018/5/31.
 */

public class Accounts {

    /**
     * account : {"balance":0,"nickName":"shg_KEw11v5LWw","phone":"18634812916","profileImageUrl":"http://ody09wgi3.bkt.clouddn.com/user/head/Head-01.png","status":0,"ticket":"0f6a9b51-e4a1-490a-bdec-f8a88a1e50b7","updateTime":1527753776000,"userId":33}
     * isnew : 1
     */

    private AccountBean account;
    private int isnew;

    public AccountBean getAccount() {
        return account;
    }

    public void setAccount(AccountBean account) {
        this.account = account;
    }

    public int getIsnew() {
        return isnew;
    }

    public void setIsnew(int isnew) {
        this.isnew = isnew;
    }

    public static class AccountBean {
        /**
         * balance : 0
         * nickName : shg_KEw11v5LWw
         * phone : 18634812916
         * profileImageUrl : http://ody09wgi3.bkt.clouddn.com/user/head/Head-01.png
         * status : 0
         * ticket : 0f6a9b51-e4a1-490a-bdec-f8a88a1e50b7
         * updateTime : 1527753776000
         * userId : 33
         */

        private int balance;
        private String nickName;
        private String phone;
        private String profileImageUrl;
        private int status;
        private String ticket;
        private long updateTime;
        private int userId;

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
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

        public String getTicket() {
            return ticket;
        }

        public void setTicket(String ticket) {
            this.ticket = ticket;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
