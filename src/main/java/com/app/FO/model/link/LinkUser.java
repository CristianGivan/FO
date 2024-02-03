package com.app.FO.model.link;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "link_user")
public class LinkUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "link_user_seq")
    @SequenceGenerator(name = "link_user_seq",
            sequenceName = "link_user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "link_user_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "link_id")
    @JsonIgnore
    private Link link;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public LinkUser() {
    }

    public LinkUser(Link link, User user) {
        this.user = user;
        this.link = link;
        this.linkDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "LinkTasks{" +
                "id=" + id +
                ", taskId=" + user.getId() +
                ", link=" + link.getId() +
                ", linkDate=" + linkDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public LocalDateTime getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(LocalDateTime linkDate) {
        this.linkDate = linkDate;
    }
}
