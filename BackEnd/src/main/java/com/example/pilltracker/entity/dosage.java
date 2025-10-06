package com.example.pilltracker.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "dosage")
public class Dosage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dosageID")
    private Integer dosageId;

    @Column(name = "numberOfPills", nullable = false)
    private Integer numberOfPills;

    @Column(name = "milligrams", nullable = false)
    private Float milligrams;

    @OneToMany(mappedBy = "dosage", cascade = CascadeType.ALL)
    private List<PatientPills> pills;

    @OneToMany(mappedBy = "dosage", cascade = CascadeType.ALL)
    private List<Reminder> reminders;

    public Dosage() {}

    // Getters and Setters
    public Integer getDosageId() { return dosageId; }
    public void setDosageId(Integer dosageId) { this.dosageId = dosageId; }
}
