package com.app.FO.model.tag;

import com.app.FO.model.event.EventTag;
import com.app.FO.model.expense.ExpenseTag;
import com.app.FO.model.expenses.ExpensesTag;
import com.app.FO.model.note.NoteTag;
import com.app.FO.model.task.TaskTag;
import com.app.FO.model.topic.TopicTag;
import com.app.FO.model.user.UserTag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tag")
@Getter
@Setter
@NoArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_seq")
    @SequenceGenerator(name = "tag_seq",
            sequenceName = "tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "tag_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "tag")
    private String tagName;

    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "tag",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<UserTag> userTagList;

    @OneToMany(mappedBy = "tag")
    private List<NoteTag> noteTagList;
    @OneToMany(mappedBy = "tag")
    private List<TopicTag> topicTagList;

    @OneToMany(mappedBy = "tag")
    private List<TaskTag> taskTagList;

    @OneToMany(mappedBy = "tag")
    private List<ExpenseTag> expenseTagList;

    @OneToMany(mappedBy = "tag")
    private List<ExpensesTag> expensesTagList;

    @OneToMany(mappedBy = "tag")
    private List<EventTag> eventTagList;

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                ", userTags=" + userTagList +
                ", noteTags=" + noteTagList +
                ", topicTags=" + topicTagList +
                ", taskTags=" + taskTagList +
                ", expenseTags=" + expenseTagList +
                ", expensesTags=" + expensesTagList +
                ", eventTags=" + eventTagList +
                '}';
    }

    public List<UserTag> getUserTagList() {
        if (userTagList ==null){
            userTagList = new ArrayList<>();
        }
        return userTagList;
    }

}
