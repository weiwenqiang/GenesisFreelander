package com.wwq.genesisfreelander.model.json;

import java.util.List;

/**
 * Created by wwq on 2017/5/4.
 */

public class FindTalkEntity {

    /**
     * code : SUCCESS
     * data : {"count1":2,"count2":5,"noreply":[{"guardTarge":"送货快","id":18,"nickName":"哈哈","orderDetail":"头肉（半斤)","orderId":"1000002032899823","sendTime":"1492520923000","shopReply":"","shopScore":5,"talkContent":"口感好","talkedDate":"1493979206186","talkedImage":""},{"guardTarge":"送错","id":19,"nickName":"哈哈","orderDetail":"凤爪（半斤)","orderId":"1000000218049165","sendTime":"1492521034000","shopReply":"","shopScore":4,"talkContent":"口感好","talkedDate":"1493979223289","talkedImage":"13412345678/4ebb4a3ab92047c48c7a2ed87315a832"},{"guardTarge":"","id":20,"nickName":" ","orderDetail":"凤爪（半斤)","orderId":"1000000464694040","sendTime":"1493970517000","shopReply":"","shopScore":4,"talkContent":"","talkedDate":"1494042716572","talkedImage":""},{"guardTarge":"准时送到,服务态度好","id":21,"nickName":" ","orderDetail":"凤爪（半斤)","orderId":"1000000464694040","sendTime":"1493970517000","shopReply":"","shopScore":4,"talkContent":"","talkedDate":"1494042726608","talkedImage":""},{"guardTarge":"准时送到,送上楼","id":22,"nickName":" ","orderDetail":"凤爪（半斤)","orderId":"1000000464694040","sendTime":"1493970517000","shopReply":"","shopScore":5,"talkContent":"我的","talkedDate":"1494043125551","talkedImage":""},{"guardTarge":"送上楼,准时送到","id":23,"nickName":" ","orderDetail":"凤爪（半斤)","orderId":"1000000464694040","sendTime":"1493970517000","shopReply":"","shopScore":5,"talkContent":"你们","talkedDate":"1494043565560","talkedImage":"13173668590/54be00c9eb8341548a8b99a139408659"}],"reply":[{"guardTarge":"","id":5,"nickName":"哦i噢噢噢","orderDetail":"","orderId":"1000000712319800","sendTime":"1492501743000","shopReply":"ghjvgh","shopScore":0,"talkContent":"","talkedDate":"1493972071294","talkedImage":"13498765432/"}]}
     * msg : 有评论
     * status : true
     */

    private String code;
    private DataBean data;
    private String msg;
    private boolean status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
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

    public static class DataBean {
        /**
         * count1 : 2
         * count2 : 5
         * noreply : [{"guardTarge":"送货快","id":18,"nickName":"哈哈","orderDetail":"头肉（半斤)","orderId":"1000002032899823","sendTime":"1492520923000","shopReply":"","shopScore":5,"talkContent":"口感好","talkedDate":"1493979206186","talkedImage":""},{"guardTarge":"送错","id":19,"nickName":"哈哈","orderDetail":"凤爪（半斤)","orderId":"1000000218049165","sendTime":"1492521034000","shopReply":"","shopScore":4,"talkContent":"口感好","talkedDate":"1493979223289","talkedImage":"13412345678/4ebb4a3ab92047c48c7a2ed87315a832"},{"guardTarge":"","id":20,"nickName":" ","orderDetail":"凤爪（半斤)","orderId":"1000000464694040","sendTime":"1493970517000","shopReply":"","shopScore":4,"talkContent":"","talkedDate":"1494042716572","talkedImage":""},{"guardTarge":"准时送到,服务态度好","id":21,"nickName":" ","orderDetail":"凤爪（半斤)","orderId":"1000000464694040","sendTime":"1493970517000","shopReply":"","shopScore":4,"talkContent":"","talkedDate":"1494042726608","talkedImage":""},{"guardTarge":"准时送到,送上楼","id":22,"nickName":" ","orderDetail":"凤爪（半斤)","orderId":"1000000464694040","sendTime":"1493970517000","shopReply":"","shopScore":5,"talkContent":"我的","talkedDate":"1494043125551","talkedImage":""},{"guardTarge":"送上楼,准时送到","id":23,"nickName":" ","orderDetail":"凤爪（半斤)","orderId":"1000000464694040","sendTime":"1493970517000","shopReply":"","shopScore":5,"talkContent":"你们","talkedDate":"1494043565560","talkedImage":"13173668590/54be00c9eb8341548a8b99a139408659"}]
         * reply : [{"guardTarge":"","id":5,"nickName":"哦i噢噢噢","orderDetail":"","orderId":"1000000712319800","sendTime":"1492501743000","shopReply":"ghjvgh","shopScore":0,"talkContent":"","talkedDate":"1493972071294","talkedImage":"13498765432/"}]
         */

        private int count1;
        private int count2;
        private List<ReplyBean> reply;

        public int getCount1() {
            return count1;
        }

        public void setCount1(int count1) {
            this.count1 = count1;
        }

        public int getCount2() {
            return count2;
        }

        public void setCount2(int count2) {
            this.count2 = count2;
        }

        public List<ReplyBean> getReply() {
            return reply;
        }

        public void setReply(List<ReplyBean> reply) {
            this.reply = reply;
        }

        public static class ReplyBean {
            /**
             * guardTarge :
             * id : 5
             * nickName : 哦i噢噢噢
             * orderDetail :
             * orderId : 1000000712319800
             * sendTime : 1492501743000
             * shopReply : ghjvgh
             * shopScore : 0
             * talkContent :
             * talkedDate : 1493972071294
             * talkedImage : 13498765432/
             */

            private String guardTarge;
            private int id;
            private String nickName;
            private String orderDetail;
            private String orderId;
            private String sendTime;
            private String shopReply;
            private int shopScore;
            private String talkContent;
            private String talkedDate;
            private String talkedImage;

            public String getGuardTarge() {
                return guardTarge;
            }

            public void setGuardTarge(String guardTarge) {
                this.guardTarge = guardTarge;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getOrderDetail() {
                return orderDetail;
            }

            public void setOrderDetail(String orderDetail) {
                this.orderDetail = orderDetail;
            }

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public String getSendTime() {
                return sendTime;
            }

            public void setSendTime(String sendTime) {
                this.sendTime = sendTime;
            }

            public String getShopReply() {
                return shopReply;
            }

            public void setShopReply(String shopReply) {
                this.shopReply = shopReply;
            }

            public int getShopScore() {
                return shopScore;
            }

            public void setShopScore(int shopScore) {
                this.shopScore = shopScore;
            }

            public String getTalkContent() {
                return talkContent;
            }

            public void setTalkContent(String talkContent) {
                this.talkContent = talkContent;
            }

            public String getTalkedDate() {
                return talkedDate;
            }

            public void setTalkedDate(String talkedDate) {
                this.talkedDate = talkedDate;
            }

            public String getTalkedImage() {
                return talkedImage;
            }

            public void setTalkedImage(String talkedImage) {
                this.talkedImage = talkedImage;
            }
        }
    }
}
