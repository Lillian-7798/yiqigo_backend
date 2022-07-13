package com.example.yqg_backend.repository;

import com.example.yqg_backend.entity.Order;
import com.example.yqg_backend.entity.User;
import com.example.yqg_backend.entity.Userauth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.id=:id")
    User getUserById(Integer id);


    @Query("select u from User u where u.name=:name")
    User getUserByName(String name);
}

