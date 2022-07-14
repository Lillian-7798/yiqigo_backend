package com.example.yqg_backend.repository;

import com.example.yqg_backend.entity.Dialog;
import com.example.yqg_backend.entity.Groupbuy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface DialogRepository extends JpaRepository<Dialog, Integer> {

}