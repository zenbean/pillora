package com.mypillora.service;

import com.mypillora.entity.PatientPillLog;
import com.mypillora.repository.PillLogRepository;
import org.springframework.stereotype.Service;

@Service
public class PillLogService {
    private final PillLogRepository repo;

    public PillLogService(PillLogRepository repo) {
        this.repo = repo;
    }

    public PatientPillLog logIntake(PatientPillLog log) {
        return repo.save(log);
    }
}
