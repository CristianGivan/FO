package com.app.FO.model.expense;


import com.app.FO.model.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "expense_list")
public class ExpensesList {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expense_list_seq")
    @SequenceGenerator(name = "expense_list_seq",
            sequenceName = "expense_list_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "expense_list_id")
    private Long id;

    @Column(name = "name")
    private String taskListName;

    private User creater;

    private List<User> usersSharing;

    @OneToMany(mappedBy = "")
    private List<Expense> expenses;

}
