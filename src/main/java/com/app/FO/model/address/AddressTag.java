package com.app.FO.model.address;

import com.app.FO.model.tag.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "address_tag")
public class AddressTag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_tag_seq")
    @SequenceGenerator(name = "address_tag_seq",
            sequenceName = "address_tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "address_tag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "address_id")
    @JsonIgnore
    private Address address;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    @JsonIgnore
    private Tag tag;

    @Column(name = "address_date")
    private LocalDateTime addressDate;

    public AddressTag() {
    }

    public AddressTag(Address address, Tag tag) {
        this.address = address;
        this.tag = tag;
        this.addressDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "AddressTag{" +
                "id=" + id +
                ", addressId=" + address.getId() +
                ", tagId=" + tag.getId() +
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

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public LocalDateTime getAddressDate() {
        return addressDate;
    }

    public void setAddressDate(LocalDateTime addressDate) {
        this.addressDate = addressDate;
    }
}
