package com.example.yqg_backend.repository;

import com.example.yqg_backend.entity.Message;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    @Query("select m from Message m where m.dialog.id=:id")
    List<Message> getMessageByDiaId(Integer id);
}