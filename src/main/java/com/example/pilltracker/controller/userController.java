package com.mypillora.controller;

import com.mypillora.entity.UserInfo;
import com.mypillora.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserInfo> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public UserInfo addUser(@RequestBody UserInfo user) {
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public UserInfo getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
