package com.app.FO.model.account;

import com.app.FO.model.transaction.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "account_transaction")
@Getter
@Setter
@NoArgsConstructor
public class AccountTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_transaction_seq")
    @SequenceGenerator(name = "account_transaction_seq",
            sequenceName = "account_transaction_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "account_transaction_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    // todo trebuie sa vad cum modelez asta o fac cu un singur acount sau o fac cu form to
    @ManyToOne
    @JoinColumn(name = "transaction_id")
    @JsonIgnore
    private Transaction  transaction;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private Account account;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public AccountTransaction() {
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "id=" + id +
                ", transactionId=" + transaction.getId() +
                ", accountId=" + account.getId() +
                ", linkDate=" + linkDate +
                '}';
    }
}
