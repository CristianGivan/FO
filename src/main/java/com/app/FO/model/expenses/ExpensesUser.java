package com.app.FO.model.expenses;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "expenses_user")
@Getter
@Setter
@NoArgsConstructor
public class ExpensesUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expenses_users_seq")
    @SequenceGenerator(name = "expenses_users_seq",
            sequenceName = "expenses_users_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "expenses_users_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "expenses_id")
    @JsonIgnore
    private Expenses expenses;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    @Override
    public String toString() {
        return "ExpensesUser{" +
                "id=" + id +
                ", userId=" + user.getId() +
                ", expensesId=" + expenses.getId() +
                ", linkDate=" + linkDate +
                '}';
    }
}
