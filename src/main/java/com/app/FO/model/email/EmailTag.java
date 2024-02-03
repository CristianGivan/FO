package com.app.FO.model.email;

import com.app.FO.model.tag.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "email_tag")
public class EmailTag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_tag_seq")
    @SequenceGenerator(name = "email_tag_seq",
            sequenceName = "email_tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "email_tag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "email_id")
    @JsonIgnore
    private Email email;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    @JsonIgnore
    private Tag tag;

    @Column(name = "email_date")
    private LocalDateTime emailDate;

    public EmailTag() {
    }

    public EmailTag(Email email, Tag tag) {
        this.email = email;
        this.tag = tag;
        this.emailDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "EmailTag{" +
                "id=" + id +
                ", emailId=" + email.getId() +
                ", tagId=" + tag.getId() +
                ", emailDate=" + emailDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public LocalDateTime getEmailDate() {
        return emailDate;
    }

    public void setEmailDate(LocalDateTime emailDate) {
        this.emailDate = emailDate;
    }
}
