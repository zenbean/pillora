USE mypillora;

-- ==============================================
-- TESTING DATA INSERTS
-- ==============================================

-- Insert users into userInfo
INSERT INTO userInfo (firstName, lastName, personaType)
VALUES 
('Alice', 'Johnson', 'patient'),
('Bob', 'Smith', 'carer');

-- Insert login information (must reference valid userIDs)
INSERT INTO loginInfo (password, email, fk_loginInfo_userID)
VALUES 
('passAlice123', 'alice@example.com', 1),
('passBob123', 'bob@example.com', 2);

-- Insert weekly settings (example medication schedules)
INSERT INTO weeklySettings (monday, tuesday, wednesday, thursday, friday, saturday, sunday)
VALUES 
(1, 1, 1, 1, 1, 0, 0),  -- Weekday schedule
(0, 0, 0, 0, 0, 1, 1);  -- Weekend schedule

-- Insert dosage information
INSERT INTO dosage (numberOfPills, milligrams)
VALUES 
(1, 100.0),
(2, 50.0);

-- Insert patient pills (depends on userInfo, weeklySettings, dosage)
INSERT INTO patientPills (beforeOrAfterMeal, pillName, fk_patientPills_dosageID, fk_patientPillLog_userID, fk_patientPIllLog_frequencyID)
VALUES 
('before', 'Aspirin', 1, 1, 1),
('after', 'VitaminD', 2, 1, 2);

-- Insert pill log (depends on userInfo + patientPills)
INSERT INTO patientPillLog (timestamp, fk_patientPillLog_userID, fk_patientPillLog_pillID)
VALUES 
(NOW(), 1, 1),
(NOW(), 1, 2);

-- Insert reminder (depends on userInfo + dosage + patientPills)
INSERT INTO reminder (fk_reminder_userID, fk_reminder_dosageID, messageStructure, status, fk_reminder_pillID)
VALUES 
(1, 1, 'Take Aspirin before breakfast', 1, 1),
(1, 2, 'Take Vitamin D after lunch', 1, 2);

-- ==============================================
-- VERIFY DATA INTEGRITY THROUGH JOINED QUERIES
-- ==============================================

-- Check user, their login, and pills
SELECT 
    u.userID, u.firstName, u.lastName, u.personaType,
    l.email, p.pillName, d.numberOfPills, d.milligrams
FROM userInfo u
JOIN loginInfo l ON u.userID = l.fk_loginInfo_userID
JOIN patientPills p ON u.userID = p.fk_patientPillLog_userID
JOIN dosage d ON p.fk_patientPills_dosageID = d.dosageID;

-- Check pill schedules (weeklySettings link)
SELECT 
    p.pillName, w.monday, w.tuesday, w.wednesday, w.thursday, w.friday, w.saturday, w.sunday
FROM patientPills p
JOIN weeklySettings w ON p.fk_patientPIllLog_frequencyID = w.frequencyID;

-- Check reminders with user and dosage info
SELECT 
    r.reminderID, u.firstName, p.pillName, d.milligrams, r.messageStructure
FROM reminder r
JOIN userInfo u ON r.fk_reminder_userID = u.userID
JOIN dosage d ON r.fk_reminder_dosageID = d.dosageID
JOIN patientPills p ON r.fk_reminder_pillID = p.pillID;

-- ==============================================
-- TEST FOREIGN KEY VIOLATIONS
-- ==============================================

-- Should FAIL: referencing non-existent user (userID = 999)
INSERT INTO loginInfo (password, email, fk_loginInfo_userID)
VALUES ('badPassword', 'invalid@example.com', 999);

-- Should FAIL: inserting a pill with invalid dosageID
INSERT INTO patientPills (beforeOrAfterMeal, pillName, fk_patientPills_dosageID, fk_patientPillLog_userID, fk_patientPIllLog_frequencyID)
VALUES ('before', 'InvalidPill', 999, 1, 1);

-- Should FAIL: inserting a reminder for a non-existent pill
INSERT INTO reminder (fk_reminder_userID, fk_reminder_dosageID, messageStructure, status, fk_reminder_pillID)
VALUES (1, 1, 'Invalid pill reference', 0, 999);


