package com.mypillora.repository;

import com.mypillora.entity.LoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<LoginInfo, Integer> {
    LoginInfo findByEmail(String email);
}
