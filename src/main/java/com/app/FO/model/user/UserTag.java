package com.app.FO.model.user;

import com.app.FO.model.tag.Tag;
import com.app.FO.model.topic.Topic;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_tag")
public class UserTag {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_tag_seq")
    @SequenceGenerator(name = "user_tag_seq",
            sequenceName = "user_tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "user_tag_id")
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

    public UserTag() {
    }

    @Override
    public String toString() {
        return "UserTag{" +
                "id=" + id +
                ", userId=" + user.getId() +
                ", tagId=" + tag.getId() +
                ", createdDate=" + createdDate +
                '}';
    }

    public UserTag(User user, Tag tag) {
        this.user = user;
        this.tag = tag;
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
