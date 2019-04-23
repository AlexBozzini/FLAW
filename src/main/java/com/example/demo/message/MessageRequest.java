package com.example.demo.message;

import java.util.Objects;

public class MessageRequest {
    private String messageBody;
    private Long userid;
    private Long channelId;

    public MessageRequest(String messageBody, Long userid, Long channelId) {
        this.messageBody = messageBody;
        this.userid = userid;
        this.channelId = channelId;
    }

    public MessageRequest() {
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public Long getUserId() {
        return userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageRequest that = (MessageRequest) o;
        return Objects.equals(messageBody, that.messageBody) &&
                Objects.equals(userid, that.userid) &&
                Objects.equals(channelId, that.channelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageBody, userid, channelId);
    }

    public void setUserId(Long userid) {
        this.userid = userid;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        return "MessageRequest{" +
                "messageBody='" + messageBody + '\'' +
                ", userid=" + userid +
                ", channelId=" + channelId +
                '}';
    }
}
