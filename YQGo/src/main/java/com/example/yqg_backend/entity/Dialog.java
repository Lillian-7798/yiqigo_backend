package com.example.yqg_backend.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Dialog {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @javax.persistence.Column(name = "dialogId")
    private int dialogId;

    public int getDialogId() {
        return dialogId;
    }

    public void setDialogId(int dialogId) {
        this.dialogId = dialogId;
    }

    @Basic
    @Column(name = "userId1")
    private Integer userId1;

    public Integer getUserId1() {
        return userId1;
    }

    public void setUserId1(Integer userId1) {
        this.userId1 = userId1;
    }

    @Basic
    @Column(name = "userId2")
    private Integer userId2;

    public Integer getUserId2() {
        return userId2;
    }

    public void setUserId2(Integer userId2) {
        this.userId2 = userId2;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="dialogId")
    private List<Message> messages;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dialog dialog = (Dialog) o;
        return dialogId == dialog.dialogId && Objects.equals(userId1, dialog.userId1) && Objects.equals(userId2, dialog.userId2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dialogId, userId1, userId2);
    }
}
