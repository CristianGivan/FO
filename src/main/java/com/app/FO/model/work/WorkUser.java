package com.app.FO.model.work;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "work_user")
public class WorkUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "work_user_seq")
    @SequenceGenerator(name = "work_user_seq",
            sequenceName = "work_user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "work_user_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "work_id")
    @JsonIgnore
    private Work work;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public WorkUser() {
    }

    public WorkUser(Work work, User user) {
        this.work = work;
        this.user = user;
        this.linkDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "WorkUser{" +
                "id=" + id +
                ", workId=" + work.getId() +
                ", userId=" + user.getId() +
                ", linkDate=" + linkDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(LocalDateTime linkDate) {
        this.linkDate = linkDate;
    }

}
