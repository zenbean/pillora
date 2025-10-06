package com.mypillora.repository;

import com.mypillora.entity.PatientPills;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PatientPillsRepository extends JpaRepository<PatientPills, Integer> {
    List<PatientPills> findByUserId(int userId);
}
