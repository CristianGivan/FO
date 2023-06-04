package com.app.FO.model.tag;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tag_history")
public class TagHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_history_seq")
    @SequenceGenerator(name = "tag_history_seq",
            sequenceName = "tag_history_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "tag_history_id")
    private Long id;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    @JsonIgnore
    private Tag tag;

    //todo o sa adaug si celelate lucri care le veau in History

    public TagHistory() {
    }

    @Override
    public String toString() {
        return "TagHistory{" +
                "id=" + id +
                ", modifiedDate=" + modifiedDate +
                ", userId=" + user.getId() +
                ", tagId=" + tag.getId() +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
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
}
