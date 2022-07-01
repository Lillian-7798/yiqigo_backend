package com.example.yqg_backend.repository;

import com.example.yqg_backend.entity.Groupbuyitem;
import com.example.yqg_backend.entity.GroupbuyitemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupbuyitemRepository extends JpaRepository<Groupbuyitem, GroupbuyitemId> {
}