package com.app.FO.model.address;

import com.app.FO.model.reminder.Reminder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "address_reminder")
public class AddressReminder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_reminder_seq")
    @SequenceGenerator(name = "address_reminder_seq",
            sequenceName = "address_reminder_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "address_reminder_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "address_id")
    @JsonIgnore
    private Address address;

    @ManyToOne
    @JoinColumn(name = "reminder_id")
    @JsonIgnore
    private Reminder reminder;

    @Column(name = "address_date")
    private LocalDateTime addressDate;

    public AddressReminder() {
    }

    public AddressReminder(Address address, Reminder reminder) {
        this.address = address;
        this.reminder = reminder;
        this.addressDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "AddressReminder{" +
                "id=" + id +
                ", addressId=" + address.getId() +
                ", reminderId=" + reminder.getId() +
                ", addressDate=" + addressDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public LocalDateTime getAddressDate() {
        return addressDate;
    }

    public void setAddressDate(LocalDateTime addressDate) {
        this.addressDate = addressDate;
    }
}
