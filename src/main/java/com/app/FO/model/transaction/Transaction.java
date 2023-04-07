package com.app.FO.model.transaction;

import com.app.FO.model.account.AccountTransaction;
import com.app.FO.model.expenses.Expenses;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "transaction")
@Getter
@Setter
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_seq")
    @SequenceGenerator(name = "transaction_seq",
            sequenceName = "transaction_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "transaction_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "details")
    private String details;

    @Column(name = "amount")
    private Double amount;

    private LocalDateTime dateTime;
    @OneToMany(mappedBy = "account",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AccountTransaction> fromAccount;

    @OneToMany(mappedBy = "account",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AccountTransaction> toAccount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "expenses_id", referencedColumnName = "expenses_id")
    private Expenses expenses;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", details='" + details + '\'' +
                ", amount=" + amount +
                ", dateTime=" + dateTime +
                ", fromAccount=" + fromAccount +
                ", toAccount=" + toAccount +
                ", expensesId=" + expenses.getId() +
                ", userId=" + user.getId() +
                '}';
    }
}
