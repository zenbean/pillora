package com.mypillora.controller;

import com.mypillora.entity.PatientPillLog;
import com.mypillora.service.PillLogService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pill-log")
public class PillLogController {
    private final PillLogService service;

    public PillLogController(PillLogService service) {
        this.service = service;
    }

    @PostMapping
    public PatientPillLog logPill(@RequestBody PatientPillLog log) {
        return service.logIntake(log);
    }
}
