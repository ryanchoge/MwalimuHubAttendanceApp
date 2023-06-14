package com.rachel.attendance.Models;

public class AllCompletedClassModel {
    String title;
    String day;
    String subject;
    String status;

    public AllCompletedClassModel(String title, String day, String subject, String status) {
        this.title = title;
        this.day = day;
        this.subject = subject;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
