package com.app.FO.model.expense;

import com.app.FO.model.Tag;
import com.app.FO.model.task.Task;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "expense_tag")
public class ExpenseTag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expense_tag_seq")
    @SequenceGenerator(name = "expense_tag_seq",
            sequenceName = "expense_tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "expense_tag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "expense_id")
    @JsonIgnore
    private Expense expense;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    @JsonIgnore
    private Tag tag;

    @Column(name = "link_date")
    private LocalDateTime linkDate;
}
