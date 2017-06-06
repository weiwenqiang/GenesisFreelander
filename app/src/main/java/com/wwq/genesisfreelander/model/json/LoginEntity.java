package com.wwq.genesisfreelander.model.json;

import java.io.Serializable;

/**
 * Created by 魏文强 on 2017/3/2.
 */

public class LoginEntity implements Serializable {
    /**
     * code : SUCCESS
     * data : {"guardPhone":"18201323192","id":509,"isPush":0,"latitude":"37.788880","longitude":"112.561292","password":"000000","realName":"刘晓东","state":0,"token":"9f03309e6c7648ecbbdbf0bc3a6d96df"}
     * msg : 登录成功
     * status : true
     */
    private static final long serialVersionUID = 1L;
    private String code;
    public Data data;
    private String msg;
    private boolean status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static class Data {
        public String getGuardImage() {
            return guardImage;
        }

        public void setGuardImage(String guardImage) {
            this.guardImage = guardImage;
        }

        /**
         * guardPhone : 18201323192
         * id : 509
         * isPush : 0
         * latitude : 37.788880
         * longitude : 112.561292
         * password : 000000
         * realName : 刘晓东
         * state : 0
         * token : 9f03309e6c7648ecbbdbf0bc3a6d96df
         */
        private String guardImage;
        private String guardPhone;
        private int id;
        private int isPush;
        private String latitude;
        private String longitude;
        private String password;
        private String realName;
        private int state;
        private String token;

        public String getGuardPhone() {
            return guardPhone;
        }

        public void setGuardPhone(String guardPhone) {
            this.guardPhone = guardPhone;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIsPush() {
            return isPush;
        }

        public void setIsPush(int isPush) {
            this.isPush = isPush;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
