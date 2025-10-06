package com.mypillora.service;

import com.mypillora.entity.Reminder;
import com.mypillora.repository.ReminderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReminderService {
    private final ReminderRepository repo;

    public ReminderService(ReminderRepository repo) {
        this.repo = repo;
    }

    public List<Reminder> getReminders(int userId) {
        return repo.findByUserId(userId);
    }
}
