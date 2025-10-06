package com.mypillora.repository;

import com.mypillora.entity.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReminderRepository extends JpaRepository<Reminder, Integer> {
    List<Reminder> findByUserId(int userId);
}
