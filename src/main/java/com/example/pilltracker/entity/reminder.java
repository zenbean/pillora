package com.example.pilltracker.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reminder")
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reminderID")
    private Integer reminderId;

    @ManyToOne
    @JoinColumn(name = "fk_reminder_userID", nullable = false)
    private UserInfo user;

    @ManyToOne
    @JoinColumn(name = "fk_reminder_dosageID", nullable = false)
    private Dosage dosage;

    @ManyToOne
    @JoinColumn(name = "fk_reminder_pillID", nullable = false)
    private PatientPills pill;

    @Column(name = "messageStructure", nullable = false)
    private String messageStructure;

    @Column(name = "status", nullable = false)
    private Integer status;

    public Reminder() {}

    // Getters and Setters
    public Integer getReminderId() { return reminderId; }
    public void setReminderId(Integer reminderId) { this.reminderId = reminderId; }
}
