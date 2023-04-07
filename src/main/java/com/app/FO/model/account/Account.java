package com.app.FO.model.account;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    @SequenceGenerator(name = "account_seq",
            sequenceName = "account_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "account_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "details")
    private String details;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    //todo cum ar trebui sa fac aici  sa fac dou coloane de tranzactii una d din care se cumpara si una din care se vande
    @OneToMany(mappedBy = "account")
    private List<AccountUser> accountUsers;

    @OneToMany(mappedBy = "account")
    private List<AccountTransaction> accountTransactionList;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", creatorId=" + creator.getId() +
                ", accountUsers=" + accountUsers +
                ", accountTransactions=" + accountTransactionList +
                '}';
    }
}
