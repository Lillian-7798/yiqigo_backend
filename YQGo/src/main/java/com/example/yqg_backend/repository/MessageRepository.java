package com.example.yqg_backend.repository;

import com.example.yqg_backend.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}