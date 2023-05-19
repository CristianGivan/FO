package com.app.FO.model.user;

import com.app.FO.model.user.Role;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_seq")
    @SequenceGenerator(name = "user_role_seq",
            sequenceName = "user_role_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "user_role_id")
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "role_id")
    @JsonIgnore
    private Role role;

    @Column(name = "date")
    private LocalDateTime allocatedDay;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;


    public UserRole() {
    }

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
        this.allocatedDay =LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", user_id=" + user.getId() +
                ", role_id =" + role.getId() +
                ", allocatedDay=" + allocatedDay +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getAllocatedDay() {
        return allocatedDay;
    }

    public void setAllocatedDay(LocalDateTime allocatedDay) {
        this.allocatedDay = allocatedDay;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
