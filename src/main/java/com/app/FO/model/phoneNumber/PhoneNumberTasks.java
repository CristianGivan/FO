package com.app.FO.model.phoneNumber;

import com.app.FO.model.tasks.Tasks;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "phoneNumber_tasks")
public class PhoneNumberTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phoneNumber_tasks_seq")
    @SequenceGenerator(name = "phoneNumber_tasks_seq",
            sequenceName = "phoneNumber_tasks_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "phoneNumber_tasks_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    @JsonIgnore
    private Tasks tasks;

    @ManyToOne
    @JoinColumn(name = "phoneNumber_id")
    @JsonIgnore
    private PhoneNumber phoneNumber;

    @Column(name = "phoneNumber_date")
    private LocalDateTime phoneNumberDate;

    public PhoneNumberTasks() {
    }

    public PhoneNumberTasks(PhoneNumber phoneNumber, Tasks tasks) {
        this.phoneNumber = phoneNumber;
        this.tasks = tasks;
        this.phoneNumberDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "PhoneNumberTaskss{" +
                "id=" + id +
                ", tasksId=" + tasks.getId() +
                ", phoneNumber=" + phoneNumber.getId() +
                ", phoneNumberDate=" + phoneNumberDate +
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

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getPhoneNumberDate() {
        return phoneNumberDate;
    }

    public void setPhoneNumberDate(LocalDateTime phoneNumberDate) {
        this.phoneNumberDate = phoneNumberDate;
    }
}
