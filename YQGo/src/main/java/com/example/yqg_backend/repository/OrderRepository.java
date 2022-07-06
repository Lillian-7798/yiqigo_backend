package com.example.yqg_backend.repository;

import com.example.yqg_backend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByGroupBuyId(Integer gid);
    
    @Query(value = "SELECT MAX(o.number) from orders o where group_buy_id= ?1", nativeQuery = true)
    Integer getMaxNumber(Integer groupBuyId);
}