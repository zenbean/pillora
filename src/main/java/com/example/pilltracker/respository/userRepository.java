package com.mypillora.repository;

import com.mypillora.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
    // You can add custom queries later if needed
}
