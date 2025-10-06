package com.example.pilltracker.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "userInfo")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private Integer userId;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "personaType", nullable = false)
    private PersonaType personaType;

    // Relationships
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<LoginInfo> loginInfoList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PatientPills> patientPills;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reminder> reminders;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PatientPillLog> pillLogs;

    // Enum for personaType
    public enum PersonaType {
        patient, carer
    }

    public UserInfo() {}

    // Getters and Setters
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public PersonaType getPersonaType() { return personaType; }
    public void setPersonaType(PersonaType personaType) { this.personaType = personaType; }
}
