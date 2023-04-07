package com.app.FO.model.expenses;

import com.app.FO.model.event.EventExpense;
import com.app.FO.model.expense.Expense;
import com.app.FO.model.transaction.Transaction;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "expenses")
@Getter
@Setter
@NoArgsConstructor
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expense_seq")
    @SequenceGenerator(name = "expense_seq",
            sequenceName = "expense_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "expenses_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "name")
    private String taskListName;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    @OneToMany(mappedBy = "expenses")
    private List<ExpensesUser> ExpensesUsers;

    @OneToMany(mappedBy = "expenses")
    private List<Expense> expenseList;

    @OneToMany(mappedBy = "expenses")
    private List<ExpensesTag> expensesTagList;

    @OneToOne(mappedBy = "expenses",cascade = CascadeType.ALL)
    private Transaction transaction;

    @OneToMany(mappedBy = "expenses")
    private List<EventExpense> eventExpensesList;

    @Override
    public String toString() {
        return "Expenses{" +
                "id=" + id +
                ", taskListName='" + taskListName + '\'' +
                ", creatorId=" + creator.getId() +
                ", ExpensesUser=" + ExpensesUsers +
                ", expenses=" + expenseList +
                ", expensesTags=" + expensesTagList +
                ", transactionId=" + transaction.getId() +
                ", eventExpens=" + eventExpensesList +
                '}';
    }
}
