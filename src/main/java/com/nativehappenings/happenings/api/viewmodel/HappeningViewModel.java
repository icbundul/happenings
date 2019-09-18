package com.nativehappenings.happenings.api.viewmodel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")
public class HappeningViewModel extends BaseEntityViewModel implements Serializable {

    @NotBlank
    private String name;

    @JsonFormat(pattern="dd.MM.yyyy")
    private Date dateFrom;

   @JsonFormat(pattern="dd.MM.yyyy")
    private Date dateTo;

    private String text;

    private String textHr;

   // @JsonManagedReference
    private HappeningTypeViewModel happeningType;

    //------------------------
    // GETTERS AND SETTERS
    //------------------------

    public HappeningViewModel() {
    }

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

    public HappeningTypeViewModel getHappeningType() {
        return happeningType;
    }

    public void setHappeningType(HappeningTypeViewModel happeningType) {
        this.happeningType = happeningType;
    }
}
