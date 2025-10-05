package com.mypillora.repository;

import com.mypillora.entity.LoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LoginRepository extends JpaRepository<LoginInfo, Long> {
    Optional<LoginInfo> findByEmail(String email);
    // findByEmail automatically generates SQL `SELECT * FROM loginInfo WHERE email = ?`
}
