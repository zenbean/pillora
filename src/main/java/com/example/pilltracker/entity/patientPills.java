package com.example.pilltracker.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "patientPills")
public class PatientPills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pillID")
    private Integer pillId;

    @Column(name = "beforeOrAfterMeal", nullable = false)
    private String beforeOrAfterMeal;

    @Column(name = "pillName", nullable = false)
    private String pillName;

    @ManyToOne
    @JoinColumn(name = "fk_patientPills_dosageID", nullable = false)
    private Dosage dosage;

    @ManyToOne
    @JoinColumn(name = "fk_patientPillLog_userID", nullable = false)
    private UserInfo user;

    @ManyToOne
    @JoinColumn(name = "fk_patientPIllLog_frequencyID", nullable = false)
    private WeeklySettings frequency;

    @OneToMany(mappedBy = "pill", cascade = CascadeType.ALL)
    private List<PatientPillLog> pillLogs;

    @OneToMany(mappedBy = "pill", cascade = CascadeType.ALL)
    private List<Reminder> reminders;

    public PatientPills() {}

    // Getters and Setters
    public Integer getPillId() { return pillId; }
    public void setPillId(Integer pillId) { this.pillId = pillId; }
}
