package com.mypillora.service;

import com.mypillora.entity.LoginInfo;
import com.mypillora.repository.LoginRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public boolean authenticate(String email, String password) {
        LoginInfo user = loginRepository.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }
}
