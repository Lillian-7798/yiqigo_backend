package com.example.yqg_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dialog")
@JsonIgnoreProperties({"userId1", "userId2"})
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
    private List<Message> messages = new ArrayList<>();

    @Column(name = "latestDate")
    private Timestamp latestDate;

    public Timestamp getLatestDate() {
        return latestDate;
    }

    public void setLatestDate(Timestamp latestDate) {
        this.latestDate = latestDate;
    }

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