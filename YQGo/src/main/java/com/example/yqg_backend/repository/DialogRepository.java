package com.example.yqg_backend.repository;

import com.example.yqg_backend.entity.Dialog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DialogRepository extends JpaRepository<Dialog, Integer> {
}