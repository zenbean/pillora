package com.mypillora.controller;

import com.mypillora.entity.Reminder;
import com.mypillora.service.ReminderService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reminders")
public class ReminderController {
    private final ReminderService service;

    public ReminderController(ReminderService service) {
        this.service = service;
    }

    @GetMapping("/{userId}")
    public List<Reminder> getReminders(@PathVariable int userId) {
        return service.getReminders(userId);
    }
}
