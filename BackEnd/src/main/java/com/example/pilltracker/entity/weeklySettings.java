package com.example.pilltracker.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "weeklySettings")
public class WeeklySettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "frequencyID")
    private Integer frequencyId;

    @Column private Boolean monday;
    @Column private Boolean tuesday;
    @Column private Boolean wednesday;
    @Column private Boolean thursday;
    @Column private Boolean friday;
    @Column private Boolean saturday;
    @Column private Boolean sunday;

    @OneToMany(mappedBy = "frequency", cascade = CascadeType.ALL)
    private List<PatientPills> pills;

    public WeeklySettings() {}

    // Getters and Setters
    public Integer getFrequencyId() { return frequencyId; }
    public void setFrequencyId(Integer frequencyId) { this.frequencyId = frequencyId; }
}
