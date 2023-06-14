package com.rachel.attendance.Models;

public class UpcomingCModel {
    String day;
    String subject;
    String time;

    public UpcomingCModel(String day, String subject, String time) {
        this.day = day;
        this.subject = subject;
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
