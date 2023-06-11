package com.app.FO.model.phoneNumber;

import com.app.FO.model.tag.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "phoneNumber_tag")
public class PhoneNumberTag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phoneNumber_tag_seq")
    @SequenceGenerator(name = "phoneNumber_tag_seq",
            sequenceName = "phoneNumber_tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "phoneNumber_tag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "phoneNumber_id")
    @JsonIgnore
    private PhoneNumber phoneNumber;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    @JsonIgnore
    private Tag tag;

    @Column(name = "phoneNumber_date")
    private LocalDateTime phoneNumberDate;

    public PhoneNumberTag() {
    }

    public PhoneNumberTag(PhoneNumber phoneNumber, Tag tag) {
        this.phoneNumber = phoneNumber;
        this.tag = tag;
        this.phoneNumberDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "PhoneNumberTag{" +
                "id=" + id +
                ", phoneNumberId=" + phoneNumber.getId() +
                ", tagId=" + tag.getId() +
                ", phoneNumberDate=" + phoneNumberDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public LocalDateTime getPhoneNumberDate() {
        return phoneNumberDate;
    }

    public void setPhoneNumberDate(LocalDateTime phoneNumberDate) {
        this.phoneNumberDate = phoneNumberDate;
    }
}
