package com.example.yqg_backend.repository;

import com.example.yqg_backend.entity.Orderitem;
import com.example.yqg_backend.entity.OrderitemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderitemRepository extends JpaRepository<Orderitem, OrderitemId> {
}