package com.mypillora.controller;

import com.mypillora.entity.LoginInfo;
import com.mypillora.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*") // Allows frontend access
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/verify")
    public String verifyLogin(@RequestParam String email, @RequestParam String password) {
        boolean valid = loginService.verifyUser(email, password);
        return valid ? "Login successful" : "Invalid credentials";
    }

    @PostMapping("/register")
    public LoginInfo registerLogin(@RequestBody LoginInfo loginInfo) {
        return loginService.registerLogin(loginInfo);
    }
}
