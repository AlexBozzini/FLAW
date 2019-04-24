package com.example.demo.message;

import java.util.Objects;

public class MessageRequest {
    private String messageBody;
    private Long userId;
    private Long channelId;

    public MessageRequest(String messageBody, Long userId, Long channelId) {
        this.messageBody = messageBody;
        this.userId = userId;
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
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageRequest that = (MessageRequest) o;
        return Objects.equals(messageBody, that.messageBody) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(channelId, that.channelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageBody, userId, channelId);
    }

    public void setUserId(Long userid) {
        this.userId = userid;
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
                ", userid=" + userId +
                ", channelId=" + channelId +
                '}';
    }
}
