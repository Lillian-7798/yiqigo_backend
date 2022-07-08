package com.example.yqg_backend.daoimpl;

import com.example.yqg_backend.dao.UserDao;
import com.example.yqg_backend.entity.User;
import com.example.yqg_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(Integer userId) {
        return userRepository.getById(userId);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }
}
