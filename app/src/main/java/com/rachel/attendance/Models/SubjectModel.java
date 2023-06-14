package com.rachel.attendance.Models;

public class SubjectModel {
    String title;
    String topic;
    String time;

    public SubjectModel(String title, String topic, String time) {
        this.title = title;
        this.topic = topic;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
