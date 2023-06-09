package com.app.FO.model.address;

import com.app.FO.model.tasks.Tasks;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "address_tasks")
public class AddressTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_tasks_seq")
    @SequenceGenerator(name = "address_tasks_seq",
            sequenceName = "address_tasks_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "address_tasks_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    @JsonIgnore
    private Tasks tasks;

    @ManyToOne
    @JoinColumn(name = "address_id")
    @JsonIgnore
    private Address address;

    @Column(name = "address_date")
    private LocalDateTime addressDate;

    public AddressTasks() {
    }

    public AddressTasks(Address address, Tasks tasks) {
        this.address = address;
        this.tasks = tasks;
        this.addressDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "AddressTaskss{" +
                "id=" + id +
                ", tasksId=" + tasks.getId() +
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

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
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
