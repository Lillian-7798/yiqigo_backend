package com.example.yqg_backend.repository;

import com.example.yqg_backend.entity.Groupbuy;
import com.example.yqg_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupbuyRepository extends JpaRepository<Groupbuy, Integer> {
   @Query(value = "SELECT gb FROM Groupbuy gb WHERE gb.user=:user")
   List<Groupbuy> findByUserId(@Param("user") User user);

    @Query(value = "SELECT gb FROM Groupbuy gb WHERE gb.id=:groupBuyId")
    Groupbuy findByGroupBuyId(@Param("groupBuyId") Integer groupBuyId);
}