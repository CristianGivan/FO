package com.app.FO.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_role")
@Getter
@Setter
@NoArgsConstructor
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_seq")
    @SequenceGenerator(name = "user_role_seq",
            sequenceName = "user_role_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "user_role_id")
    @Setter(AccessLevel.NONE)
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

    public UserRole(User user, Role role, LocalDateTime allocatedDay) {
        this.user = user;
        this.role = role;
        this.allocatedDay = allocatedDay;
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
}
