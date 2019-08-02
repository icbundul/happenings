package com.nativehappenings.happenings.model;

import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// @author ivanc 01.05.2019
@Entity
@Table(name = "Happenings")
public class Happening extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date dateFrom;

    @Temporal(TemporalType.DATE)
    private Date dateTo;

    @Column(name = "text", length = 6000)
    private String text;

    @Column(name = "textHr", length = 6000)
    private String textHr;

    @OneToMany(mappedBy = "happening")
    @OrderColumn
    private List<HappeningPlace> happeningPlaces = new ArrayList<>();

    //------------------------
    // Constructor
    //------------------------

    protected Happening() {
    }

    public Happening(String name, Date dateFrom, Date dateTo, String text, String textHr) {

        this();
        this.name = name;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.text = text;
        this.textHr = textHr;
        this.happeningPlaces = happeningPlaces;
    }

    public Happening(Long id, String name, Date dateFrom, Date dateTo, String text, String textHr) {

        this(name, dateFrom, dateTo, text, textHr);
        this.id = id;
    }

    //------------------------
    // GETTERS AND SETTERS
    //------------------------

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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
}
