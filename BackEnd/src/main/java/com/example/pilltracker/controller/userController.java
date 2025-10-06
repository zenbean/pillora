package com.mypillora.controller;

import com.mypillora.entity.UserInfo;
import com.mypillora.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserInfo createUser(@RequestBody UserInfo user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<UserInfo> getAllUsers() {
        return userService.getAllUsers();
    }
}
