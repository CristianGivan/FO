package com.app.FO.model.dates;

import com.app.FO.model.tag.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "dates_tag")
public class DatesTag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dates_tag_seq")
    @SequenceGenerator(name = "dates_tag_seq",
            sequenceName = "dates_tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "dates_tag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dates_id")
    @JsonIgnore
    private Dates dates;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    @JsonIgnore
    private Tag tag;

    @Column(name = "dates_date")
    private LocalDateTime datesDate;

    public DatesTag() {
    }

    public DatesTag(Dates dates, Tag tag) {
        this.dates = dates;
        this.tag = tag;
        this.datesDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "DatesTag{" +
                "id=" + id +
                ", datesId=" + dates.getId() +
                ", tagId=" + tag.getId() +
                ", datesDate=" + datesDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public LocalDateTime getDatesDate() {
        return datesDate;
    }

    public void setDatesDate(LocalDateTime datesDate) {
        this.datesDate = datesDate;
    }
}
