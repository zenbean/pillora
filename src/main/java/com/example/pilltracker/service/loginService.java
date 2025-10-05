package com.mypillora.service;

import com.mypillora.entity.LoginInfo;
import com.mypillora.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    // Check if email and password are valid
    public boolean verifyUser(String email, String password) {
        Optional<LoginInfo> loginOpt = loginRepository.findByEmail(email);
        if (loginOpt.isPresent()) {
            LoginInfo login = loginOpt.get();
            return login.getPassword().equals(password);
        }
        return false;
    }

    // Register new user login credentials
    public LoginInfo registerLogin(LoginInfo loginInfo) {
        return loginRepository.save(loginInfo);
    }
}
