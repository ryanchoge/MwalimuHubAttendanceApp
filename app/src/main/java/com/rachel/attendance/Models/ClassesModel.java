package com.rachel.attendance.Models;

public class ClassesModel {
    String title;
    String subjects;

    public ClassesModel(String title, String subjects) {
        this.title = title;
        this.subjects = subjects;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }
}
