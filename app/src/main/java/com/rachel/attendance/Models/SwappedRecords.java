package com.rachel.attendance.Models;

public class SwappedRecords {
    String day;
    String status;
    String subject;

    public SwappedRecords(String day, String status, String subject) {
        this.day = day;
        this.status = status;
        this.subject = subject;
    }

    public String getDay() {
        return day;
    }

    public String getStatus() {
        return status;
    }

    public String getSubject() {
        return subject;
    }
}
