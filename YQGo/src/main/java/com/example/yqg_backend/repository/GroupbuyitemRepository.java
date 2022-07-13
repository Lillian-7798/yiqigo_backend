package com.example.yqg_backend.repository;

import com.example.yqg_backend.entity.Groupbuyitem;
import com.example.yqg_backend.entity.GroupbuyitemId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GroupbuyitemRepository extends JpaRepository<Groupbuyitem, GroupbuyitemId> {

}