package com.app.FO.model.tryLearn;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "prs_prs")
public class PrsPrs {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prs_prs_seq")
    @SequenceGenerator(name = "prs_prs_seq",
            sequenceName = "prs_prs_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "prs_prs_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "prs_id")
    @JsonIgnore
    private Prs prs;

    @ManyToOne
    @JoinColumn(name = "related_prs_id")
    @JsonIgnore
    private Prs relatedPrs;

    @Column(name = "linked_date")
    private LocalDateTime linkedDate;

    public PrsPrs() {
    }

    public PrsPrs(Prs prs, Prs relatedPrs) {
        this.prs = prs;
        this.relatedPrs = relatedPrs;
        this.linkedDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "PrsPrs{" +
                "id=" + id +
                ", prsId=" + prs.getId() +
                ", relatedPrsId=" + relatedPrs.getId() +
                ", prsDate=" + linkedDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Prs getPrs() {
        return prs;
    }

    public void setPrs(Prs prs) {
        this.prs = prs;
    }

    public Prs getRelatedPrs() {
        return relatedPrs;
    }

    public void setRelatedPrs(Prs relatedPrs) {
        this.relatedPrs = relatedPrs;
    }

    public LocalDateTime getLinkedDate() {
        return linkedDate;
    }

    public void setLinkedDate(LocalDateTime linkedDate) {
        this.linkedDate = linkedDate;
    }
}
