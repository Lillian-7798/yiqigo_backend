package com.example.yqg_backend.repository;

import com.example.yqg_backend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByGroupBuyId(Integer gid);
}