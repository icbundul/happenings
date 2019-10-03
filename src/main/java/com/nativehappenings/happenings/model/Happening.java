package com.nativehappenings.happenings.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// @author ivanc 01.05.2019
@Entity
@Table(name = "Happenings")
public class Happening extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String name;

    @JsonFormat(pattern="dd.MM.yyyy")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;

    @JsonFormat(pattern="dd.MM.yyyy")
    @Temporal(TemporalType.DATE)
    private Date dateTo;

    @Column(name = "text", length = 6000)
    private String text;

    @Column(name = "textHr", length = 6000)
    private String textHr;

    @OneToMany(mappedBy = "happening", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HappeningPlace> happeningPlaces = new ArrayList<>();

    @ManyToOne(optional = true)
    private HappeningType happeningType;

    //------------------------
    // Constructor
    //------------------------

    protected Happening() {
    }

    public Happening(String name, Date dateFrom, Date dateTo, String text, String textHr,
                     HappeningType happeningType, String notes, List<HappeningPlace> happeningPlaces) {

        this();
        super.setNotes(notes);
        this.name = name;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.text = text;
        this.textHr = textHr;
        this.happeningType = happeningType;
        this.happeningPlaces = happeningPlaces;
    }

    public Happening(Long id, String name, Date dateFrom, Date dateTo, String text, String textHr,
                     HappeningType happeningType, String notes, List<HappeningPlace> happeningPlaces) {

        this(name, dateFrom, dateTo, text, textHr, happeningType, notes, happeningPlaces);
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

    public HappeningType getHappeningType() {
        return happeningType;
    }

    public void setHappeningType(HappeningType happeningType) {
        this.happeningType = happeningType;
    }

    public List<HappeningPlace> getHappeningPlaces() {
        return happeningPlaces;
    }

    public void setHappeningPlaces(List<HappeningPlace> happeningPlaces) {
        this.happeningPlaces = happeningPlaces;
    }
}
