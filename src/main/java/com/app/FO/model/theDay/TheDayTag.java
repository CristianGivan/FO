package com.app.FO.model.theDay;

import com.app.FO.model.tag.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "the_day_tag")
public class TheDayTag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "the_day_tag_seq")
    @SequenceGenerator(name = "the_day_tag_seq",
            sequenceName = "the_day_tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "the_day_tag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "the_day_id")
    @JsonIgnore
    private TheDay theDay;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    @JsonIgnore
    private Tag tag;

    @Column(name = "the_day_date")
    private LocalDateTime theDayDate;

    public TheDayTag() {
    }

    public TheDayTag(TheDay theDay, Tag tag) {
        this.theDay = theDay;
        this.tag = tag;
        this.theDayDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "TheDayTag{" +
                "id=" + id +
                ", theDayId=" + theDay.getId() +
                ", tagId=" + tag.getId() +
                ", theDayDate=" + theDayDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TheDay getTheDay() {
        return theDay;
    }

    public void setTheDay(TheDay theDay) {
        this.theDay = theDay;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public LocalDateTime getTheDayDate() {
        return theDayDate;
    }

    public void setTheDayDate(LocalDateTime theDayDate) {
        this.theDayDate = theDayDate;
    }
}
