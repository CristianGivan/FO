package com.app.FO.model.address;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "address_user")
public class AddressUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_user_seq")
    @SequenceGenerator(name = "address_user_seq",
            sequenceName = "address_user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "address_user_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "address_id")
    @JsonIgnore
    private Address address;

    @Column(name = "address_date")
    private LocalDateTime addressDate;

    public AddressUser() {
    }

    public AddressUser(Address address, User user) {
        this.user = user;
        this.address = address;
        this.addressDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "AddressTasks{" +
                "id=" + id +
                ", taskId=" + user.getId() +
                ", address=" + address.getId() +
                ", addressDate=" + addressDate +
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDateTime getAddressDate() {
        return addressDate;
    }

    public void setAddressDate(LocalDateTime addressDate) {
        this.addressDate = addressDate;
    }
}
