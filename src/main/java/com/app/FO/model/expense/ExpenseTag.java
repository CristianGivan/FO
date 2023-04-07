package com.app.FO.model.expense;

import com.app.FO.model.tag.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "expense_tag")
@Getter
@Setter
@NoArgsConstructor
public class ExpenseTag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expense_tag_seq")
    @SequenceGenerator(name = "expense_tag_seq",
            sequenceName = "expense_tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "expense_tag_id")
    @Setter(AccessLevel.NONE)
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

    @Override
    public String toString() {
        return "ExpenseTag{" +
                "id=" + id +
                ", expenseId=" + expense.getId() +
                ", tagId=" + tag.getId() +
                ", linkDate=" + linkDate +
                '}';
    }
}
