package com.app.FO.model.account;

import com.app.FO.model.tag.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "account_tag")
public class AccountTag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_tag_seq")
    @SequenceGenerator(name = "account_tag_seq",
            sequenceName = "account_tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "account_tag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private Account account;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    @JsonIgnore
    private Tag tag;

    @Column(name = "account_date")
    private LocalDateTime accountDate;

    public AccountTag() {
    }

    public AccountTag(Account account, Tag tag) {
        this.account = account;
        this.tag = tag;
        this.accountDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "AccountTag{" +
                "id=" + id +
                ", accountId=" + account.getId() +
                ", tagId=" + tag.getId() +
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

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public LocalDateTime getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(LocalDateTime accountDate) {
        this.accountDate = accountDate;
    }
}
