package com.app.FO.model.expenses;

import com.app.FO.model.tag.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "expenses_tag")
@Getter
@Setter
@NoArgsConstructor
public class ExpensesTag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expenses_tag_seq")
    @SequenceGenerator(name = "expenses_tag_seq",
            sequenceName = "expenses_tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "expenses_tag_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "expenses_id")
    @JsonIgnore
    private Expenses expenses;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    @JsonIgnore
    private Tag tag;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    @Override
    public String toString() {
        return "ExpensesTag{" +
                "id=" + id +
                ", expensesId=" + expenses.getId() +
                ", tagId=" + tag.getId() +
                ", linkDate=" + linkDate +
                '}';
    }
}
