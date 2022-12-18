package com.app.FO.model;

import com.app.FO.model.expense.Expense;
import com.app.FO.model.tasklist.TaskList;
import com.app.FO.model.topic.Topic;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Event {

    private String name;

    private List<Tag> tags;

    private List<Remainder> remainders;

    private List<Topic> topics;

    private List<TaskList> taskLists;

    private List<Expense> expenses;


}
