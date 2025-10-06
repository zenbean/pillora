package com.mypillora.service;

import com.mypillora.entity.UserInfo;
import com.mypillora.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserInfo createUser(UserInfo user) {
        return userRepository.save(user);
    }

    public List<UserInfo> getAllUsers() {
        return userRepository.findAll();
    }
}
