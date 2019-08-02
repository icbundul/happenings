package com.nativehappenings.happenings.api.viewmodel;

import java.util.Date;

public class HappeningViewModel extends BaseEntityViewModel {

    private String name;

    private Date dateFrom;

    private Date dateTo;

    private String text;

    private String textHr;

    //------------------------
    // GETTERS AND SETTERS
    //------------------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTextHr() {
        return textHr;
    }

    public void setTextHr(String textHr) {
        this.textHr = textHr;
    }
}
