package com.mypillora.controller;

import com.mypillora.entity.PatientPills;
import com.mypillora.service.PatientPillsService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pills")
public class PatientPillsController {
    private final PatientPillsService service;

    public PatientPillsController(PatientPillsService service) {
        this.service = service;
    }

    @GetMapping("/{userId}")
    public List<PatientPills> getPills(@PathVariable int userId) {
        return service.getPillsByUser(userId);
    }

    @PostMapping
    public PatientPills addPill(@RequestBody PatientPills pill) {
        return service.addPill(pill);
}

}


