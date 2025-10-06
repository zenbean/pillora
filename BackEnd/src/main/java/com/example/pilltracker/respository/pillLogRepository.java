package com.mypillora.repository;

import com.mypillora.entity.PatientPillLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PillLogRepository extends JpaRepository<PatientPillLog, Integer> {}
