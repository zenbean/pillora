package com.example.pilltracker.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "loginInfo")
public class LoginInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loginID")
    private Integer loginId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "fk_loginInfo_userID", nullable = false)
    private UserInfo user;

    public LoginInfo() {}

    // Getters and Setters
    public Integer getLoginId() { return loginId; }
    public void setLoginId(Integer loginId) { this.loginId = loginId; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public UserInfo getUser() { return user; }
    public void setUser(UserInfo user) { this.user = user; }
}
