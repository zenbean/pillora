package com.mypillora.service;

import com.mypillora.entity.UserInfo;
import com.mypillora.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserInfo> getAllUsers() {
        return userRepository.findAll();
    }

    public UserInfo addUser(UserInfo user) {
        return userRepository.save(user);
    }

    public UserInfo getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
