package com.example.yqg_backend.repository;

import com.example.yqg_backend.entity.Order;
import com.example.yqg_backend.entity.Userauth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserauthRepository extends JpaRepository<Userauth, Integer> {
    @Query("select u from Userauth u where u.username=:userName")
    Userauth getUserauthByName(String userName);
}