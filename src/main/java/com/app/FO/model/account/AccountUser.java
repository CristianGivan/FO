package com.app.FO.model.account;

//import com.app.FO.model.expenses.Expenses;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "account_users")
@Getter
@Setter
@NoArgsConstructor
public class AccountUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_users_seq")
    @SequenceGenerator(name = "account_users_seq",
            sequenceName = "account_users_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "account_users_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private Account account;

    @Column(name = "link_date")
    private LocalDateTime linkDate;


    @Override
    public String toString() {
        return "AccountUser{" +
                "id=" + id +
                ", userId=" + user.getId() +
                ", accountId=" + account.getId() +
                ", linkDate=" + linkDate +
                '}';
    }
}
