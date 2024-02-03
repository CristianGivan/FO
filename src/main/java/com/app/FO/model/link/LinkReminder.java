package com.app.FO.model.link;

import com.app.FO.model.reminder.Reminder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "link_reminder")
public class LinkReminder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "link_reminder_seq")
    @SequenceGenerator(name = "link_reminder_seq",
            sequenceName = "link_reminder_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "link_reminder_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "link_id")
    @JsonIgnore
    private Link link;

    @ManyToOne
    @JoinColumn(name = "reminder_id")
    @JsonIgnore
    private Reminder reminder;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public LinkReminder() {
    }

    public LinkReminder(Link link, Reminder reminder) {
        this.link = link;
        this.reminder = reminder;
        this.linkDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "LinkReminder{" +
                "id=" + id +
                ", linkId=" + link.getId() +
                ", reminderId=" + reminder.getId() +
                ", linkDate=" + linkDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public LocalDateTime getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(LocalDateTime linkDate) {
        this.linkDate = linkDate;
    }
}
