package com.example.yqg_backend.repository;

import com.example.yqg_backend.entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodRepository extends JpaRepository<Good, Integer> {
}