package com.app.FO.model.expense;

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
@Table(name = "expense")
@Getter
@Setter
@NoArgsConstructor
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expense_seq")
    @SequenceGenerator(name = "expense_seq",
            sequenceName = "expense_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "expense_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "name")
    private String expanseName;

    @Column(name = "details")
    private String details;

    @Column(name = "quantity")
    private double quantity;

    @Column(name = "unit")
    private String unit;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "created_date")
    private LocalDateTime createDate;

    @Column(name = "paid_date")
    private LocalDateTime paidDate;

    @Column(name = "market")
    private String market;

    @ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "creator_id")
    @JsonIgnore
    private User creator;

    @ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "payer_id")
    @JsonIgnore
    private User payer;

    @OneToMany(mappedBy = "expense", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpenseTag> expenseTags;

    @ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "expenses_id")
    @JsonIgnore
    private Expenses expenses;

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", expanseName='" + expanseName + '\'' +
                ", details='" + details + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                ", unitPrice=" + unitPrice +
                ", createDate=" + createDate +
                ", paidDate=" + paidDate +
                ", market='" + market + '\'' +
                ", creatorId=" + creator.getId() +
                ", payerId=" + payer.getId() +
                ", expenseTags=" + expenseTags +
                ", expensesId=" + expenses.getId() +
                '}';
    }
}
