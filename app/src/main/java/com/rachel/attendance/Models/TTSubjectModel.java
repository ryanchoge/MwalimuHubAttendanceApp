package com.rachel.attendance.Models;

public class TTSubjectModel {
    String Title;
    String time;

    public TTSubjectModel(String title, String time) {
        Title = title;
        this.time = time;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
