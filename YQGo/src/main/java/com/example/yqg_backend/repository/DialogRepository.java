package com.example.yqg_backend.repository;

import com.example.yqg_backend.entity.Dialog;
import com.example.yqg_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DialogRepository extends JpaRepository<Dialog, Integer> {
    @Query("select d from Dialog d where d.id=:id")
    List<Dialog> getDialogById(Integer id);
}