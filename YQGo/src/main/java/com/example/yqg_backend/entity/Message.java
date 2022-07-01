package com.example.yqg_backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "messageId", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dialogId")
    private Dialog dialog;

    @Column(name = "content", length = 200)
    private String content;

    @Column(name = "userId")
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Dialog getDialog() {
        return dialog;
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
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

}