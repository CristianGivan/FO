package com.app.FO.model.tag;

import com.app.FO.model.tag.Tag;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tag_user")
public class TagUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_user_seq")
    @SequenceGenerator(name = "tag_user_seq",
            sequenceName = "tag_user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "tag_user_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    @JsonIgnore
    private Tag tag;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    public TagUser() {
    }

    @Override
    public String toString() {
        return "TagUser{" +
                "id=" + id +
                ", userId=" + user.getId() +
                ", tagId=" + tag.getId() +
                ", createdDate=" + createdDate +
                '}';
    }

    public TagUser(Tag tag,User user) {
        this.tag = tag;
        this.user = user;
        this.createdDate = LocalDateTime.now();
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

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
