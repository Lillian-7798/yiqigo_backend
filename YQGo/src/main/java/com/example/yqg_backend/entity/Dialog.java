package com.example.yqg_backend.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "dialog")
public class Dialog {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "dialogId", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId1")
    private User userId1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId2")
    private User userId2;

    @OneToMany(mappedBy = "dialog")
    private List<Message> messages = new ArrayList();

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public User getUserId2() {
        return userId2;
    }

    public void setUserId2(User userId2) {
        this.userId2 = userId2;
    }

    public User getUserId1() {
        return userId1;
    }

    public void setUserId1(User userId1) {
        this.userId1 = userId1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//TODO [JPA Buddy] generate columns from DB
}