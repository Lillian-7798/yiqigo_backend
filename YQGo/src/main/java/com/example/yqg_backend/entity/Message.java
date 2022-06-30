package com.example.yqg_backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Message {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "messageId")
    private int messageId;
    @Basic
    @Column(name = "dialogId")
    private Integer dialogId;
    @Basic
    @Column(name = "content")
    private String content;
    @Basic
    @Column(name = "userId")
    private Integer userId;

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public Integer getDialogId() {
        return dialogId;
    }

    public void setDialogId(Integer dialogId) {
        this.dialogId = dialogId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return messageId == message.messageId && Objects.equals(dialogId, message.dialogId) && Objects.equals(content, message.content) && Objects.equals(userId, message.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, dialogId, content, userId);
    }
}
