package com.app.FO.model.address;

import com.app.FO.model.person.PersonAddress;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @SequenceGenerator(name = "address_seq",
            sequenceName = "address_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "address_id")
    private Long id;

    @Column(name = "subject")
    private String subject;
    @Column(name = "googleLocation")
    private String googleLocation;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    @OneToMany(mappedBy = "address", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AddressUser> addressUserList;

    @OneToMany(mappedBy = "address", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AddressTag> addressTagList;

    @OneToMany(mappedBy = "address", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AddressReminder> addressReminderList;

    @OneToMany(mappedBy = "address", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AddressTopic> addressTopicList;

    @OneToMany(mappedBy = "address", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AddressTasks> addressTasksList;

    @OneToMany(mappedBy = "address", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PersonAddress> personAddressList;
    @OneToMany(mappedBy = "address", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AddressHistory> addressHistoryList;


    public Address() {
    }

    public Address(String subject, String googleLocation, User creator) {
        this.subject = subject;
        this.googleLocation = googleLocation;
        this.creator = creator;
        this.createdDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", googleLocation='" + googleLocation + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                ", addressUserList=" + addressUserList +
                ", addressTopicList=" + addressTopicList +
                ", addressTasksList=" + addressTasksList +
                ", addressUserList=" + addressUserList +
                ", addressTagList=" + addressTagList +
                ", addressReminderList=" + addressReminderList +
                ", personAddressList=" + personAddressList +
                ", addressHistoryList=" + addressHistoryList +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        if (subject == null) {
            subject = "";
        }
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGoogleLocation() {
        if (googleLocation == null) {
            googleLocation = "";
        }
        return googleLocation;
    }

    public void setGoogleLocation(String googleLocation) {
        this.googleLocation = googleLocation;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<AddressUser> getAddressUserList() {
        if (addressUserList == null) {
            addressUserList = new ArrayList<>();
        }
        return addressUserList;
    }

    public void setAddressUserList(List<AddressUser> addressUserList) {
        this.addressUserList = addressUserList;
    }

    public List<AddressTag> getAddressTagList() {
        if (addressTagList == null) {
            addressTagList = new ArrayList<>();
        }
        return addressTagList;
    }

    public void setAddressTagList(List<AddressTag> addressTagList) {
        this.addressTagList = addressTagList;
    }

    public List<AddressReminder> getAddressReminderList() {
        if (addressReminderList == null) {
            addressReminderList = new ArrayList<>();
        }
        return addressReminderList;
    }

    public void setAddressReminderList(List<AddressReminder> addressReminderList) {
        this.addressReminderList = addressReminderList;
    }


    public List<AddressTopic> getAddressTopicList() {
        if (addressTopicList == null) {
            addressTopicList = new ArrayList<>();
        }
        return addressTopicList;
    }

    public void setAddressTopicList(List<AddressTopic> addressTopicList) {
        this.addressTopicList = addressTopicList;
    }

    public List<AddressTasks> getAddressTasksList() {
        if (addressTasksList == null) {
            addressTasksList = new ArrayList<>();
        }
        return addressTasksList;
    }

    public void setAddressTasksList(List<AddressTasks> addressTasksList) {
        this.addressTasksList = addressTasksList;
    }

    public List<PersonAddress> getPersonAddressList() {
        if (personAddressList == null) {
            personAddressList = new ArrayList<>();
        }
        return personAddressList;
    }

    public void setPersonAddressList(List<PersonAddress> personAddressList) {
        this.personAddressList = personAddressList;
    }

    public List<AddressHistory> getAddressHistoryList() {
        if (addressHistoryList == null) {
            addressHistoryList = new ArrayList<>();
        }
        return addressHistoryList;
    }

    public void setAddressHistoryList(List<AddressHistory> addressHistoryList) {
        this.addressHistoryList = addressHistoryList;
    }
}
