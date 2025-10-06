package com.mypillora.service;

import com.mypillora.entity.PatientPills;
import com.mypillora.repository.PatientPillsRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientPillsService {
    private final PatientPillsRepository repo;

    public PatientPillsService(PatientPillsRepository repo) {
        this.repo = repo;
    }

    public List<PatientPills> getPillsByUser(int userId) {
        return repo.findByUserId(userId);
    }
    
    public PatientPills addPill(PatientPills pill) {
        return repo.save(pill);
}

}
