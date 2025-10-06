package com.example.pilltracker.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "patientPillLog")
public class PatientPillLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "logID")
    private Integer logId;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "fk_patientPillLog_userID", nullable = false)
    private UserInfo user;

    @ManyToOne
    @JoinColumn(name = "fk_patientPillLog_pillID", nullable = false)
    private PatientPills pill;

    public PatientPillLog() {}

    // Getters and Setters
    public Integer getLogId() { return logId; }
    public void setLogId(Integer logId) { this.logId = logId; }
}
