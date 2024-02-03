package com.app.FO.model.account;

import com.app.FO.model.reminder.Reminder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "account_reminder")
public class AccountReminder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_reminder_seq")
    @SequenceGenerator(name = "account_reminder_seq",
            sequenceName = "account_reminder_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "account_reminder_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private Account account;

    @ManyToOne
    @JoinColumn(name = "reminder_id")
    @JsonIgnore
    private Reminder reminder;

    @Column(name = "account_date")
    private LocalDateTime accountDate;

    public AccountReminder() {
    }

    public AccountReminder(Account account, Reminder reminder) {
        this.account = account;
        this.reminder = reminder;
        this.accountDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "AccountReminder{" +
                "id=" + id +
                ", accountId=" + account.getId() +
                ", reminderId=" + reminder.getId() +
                ", accountDate=" + accountDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public LocalDateTime getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(LocalDateTime accountDate) {
        this.accountDate = accountDate;
    }
}
