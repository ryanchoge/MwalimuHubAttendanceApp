package com.rachel.attendance.Models;

import java.util.Date;

public class CalendarModel {
    private String formattedDate;
    private Date date;
    private boolean isSelected;

    public CalendarModel(String formattedDate, Date date, boolean isSelected) {
        this.formattedDate = formattedDate;
        this.date = date;
        this.isSelected = isSelected;
    }

    public String getFormattedDate() {
        return formattedDate;
    }

    public void setFormattedDate(String formattedDate) {
        this.formattedDate = formattedDate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}

