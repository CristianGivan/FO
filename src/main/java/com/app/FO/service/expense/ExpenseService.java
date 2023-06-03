package com.app.FO.service.expense;

import com.app.FO.exceptions.*;
import com.app.FO.model.expense.*;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.tasks.Tasks;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;
import com.app.FO.repository.expense.ExpenseRepository;
import com.app.FO.util.ServiceAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private ExpenseRepository expenseRepository;

    private ServiceAll serviceAll;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository, ServiceAll serviceAll) {
        this.expenseRepository = expenseRepository;
        this.serviceAll = serviceAll;
    }

//-- Post

    public Expense postExpense(String subject) {
        User logInUser = serviceAll.getLogInUser();

        Expense expense = expenseRepository.getExpenseFromUserIdBySubject(logInUser.getId(), subject);
        if (expense != null) {
            throw new ExpenseAlreadyExistException("Expense with this subject already exist");
        }

        expense = expenseRepository.save(new Expense(subject, logInUser));

        ExpenseUser expenseUser = new ExpenseUser(expense, logInUser);
        expense.getExpenseUserList().add(expenseUser);

        return expenseRepository.save(expense);
    }

    //-- Put
    public Expense putSubjectToExpense(Long expenseId, String subject) {
        User logInUser = serviceAll.getLogInUser();
        Expense expense = expenseRepository.getExpenseFromUserIdByExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("Expense not found in your list");
        }

        if (expense.getSubject().equals(subject)) {
            throw new ExpenseAlreadyExistException("Expense has already the same subject");
        }

        expense.setSubject(subject);

        return expenseRepository.save(expense);
    }

    public Expense putUserToExpense(Long expenseId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Expense expense = expenseRepository.getExpenseFromUserIdByExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("Expense not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        ExpenseUser expenseUser = serviceAll.getExpenseUser(expenseId, userId);
        if (expenseUser != null) {
            throw new ExpenseUserAlreadyExistException("The expense already has the user");
        }

        expenseUser = new ExpenseUser(expense, user);
        expense.getExpenseUserList().add(expenseUser);

        return expenseRepository.save(expense);
    }

    public Expense putTagToExpense(Long expenseId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Expense expense = expenseRepository.getExpenseFromUserIdByExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("Expense not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdAndTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        ExpenseTag expenseTag = serviceAll.getExpenseTag(expenseId, tagId);
        if (expenseTag != null) {
            throw new ExpenseTagAlreadyExistException("The expense already has the tag");
        }

        expenseTag = new ExpenseTag(expense, tag);
        expense.getExpenseTagList().add(expenseTag);

        return expenseRepository.save(expense);
    }


    public Expense putReminderToExpense(Long expenseId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Expense expense = expenseRepository.getExpenseFromUserIdByExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("Expense not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        ExpenseReminder expenseReminder = serviceAll.getExpenseReminder(expenseId, reminderId);
        if (expenseReminder != null) {
            throw new ExpenseReminderAlreadyExistException("The expense already has the reminder");
        }

        expenseReminder = new ExpenseReminder(expense, reminder);
        expense.getExpenseReminderList().add(expenseReminder);

        return expenseRepository.save(expense);
    }

    public Expense putTopicToExpense(Long expenseId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Expense expense = expenseRepository.getExpenseFromUserIdByExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("Expense not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        ExpenseTopic expenseTopic = serviceAll.getExpenseTopic(expenseId, topicId);
        if (expenseTopic != null) {
            throw new ExpenseTopicAlreadyExistException("The expense already has the topic");
        }

        expenseTopic = new ExpenseTopic(expense, topic);
        expense.getExpenseTopicList().add(expenseTopic);
        return expenseRepository.save(expense);
    }

    public Expense putTasksToExpense(Long expenseId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        Expense expense = expenseRepository.getExpenseFromUserIdByExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("Expense not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found");
        }

        ExpenseTasks expenseTasks = serviceAll.getExpenseTasks(expenseId, tasksId);
        if (expenseTasks != null) {
            throw new ExpenseTasksAlreadyExistException("The expense already has the tasks");
        }

        expenseTasks = new ExpenseTasks(expense, tasks);
        expense.getExpenseTasksList().add(expenseTasks);
        return expenseRepository.save(expense);
    }


    //--Delete


    public Expense deleteUserFromExpense(Long expenseId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Expense expense = expenseRepository.getExpenseFromUserIdByExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("Expense not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        ExpenseUser expenseUser = serviceAll.getExpenseUser(expenseId, userId);
        if (expenseUser == null) {
            throw new ExpenseUserNotFoundException("The expense don't has the user");
        }
        expense.getExpenseUserList().remove(expenseUser);

        return expenseRepository.save(expense);
    }

    public Expense deleteTagFromExpense(Long expenseId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Expense expense = expenseRepository.getExpenseFromUserIdByExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("Expense not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdAndTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        ExpenseTag expenseTag = serviceAll.getExpenseTag(expenseId, tagId);
        if (expenseTag == null) {
            throw new ExpenseTagNotFoundException("The expense don't has the tag");
        }

        expense.getExpenseTagList().remove(expenseTag);

        return expenseRepository.save(expense);
    }

    public Expense deleteReminderFromExpense(Long expenseId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Expense expense = expenseRepository.getExpenseFromUserIdByExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("Expense not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        ExpenseReminder expenseReminder = serviceAll.getExpenseReminder(expenseId, reminderId);
        if (expenseReminder == null) {
            throw new ExpenseReminderNotFoundException("The expense don't has the reminder");
        }

        expense.getExpenseReminderList().remove(expenseReminder);

        return expenseRepository.save(expense);
    }

    public Expense deleteTopicFromExpense(Long expenseId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Expense expense = expenseRepository.getExpenseFromUserIdByExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("Expense not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        ExpenseTopic expenseTopic = serviceAll.getExpenseTopic(expenseId, topicId);
        if (expenseTopic == null) {
            throw new ExpenseTasksNotFoundException("The expense don't has the topic");
        }

        expense.getExpenseTopicList().remove(expenseTopic);

        return expenseRepository.save(expense);
    }

    public Expense deleteTasksFromExpense(Long expenseId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        Expense expense = expenseRepository.getExpenseFromUserIdByExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("Expense not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found");
        }

        ExpenseTasks expenseTasks = serviceAll.getExpenseTasks(expenseId, tasksId);
        if (expenseTasks == null) {
            throw new ExpenseTasksNotFoundException("The expense don't has the tasks");
        }

        expense.getExpenseTasksList().remove(expenseTasks);

        return expenseRepository.save(expense);
    }

    public List<Expense> deleteExpense(Long expenseId) {
        User logInUser = serviceAll.getLogInUser();

        Expense expense = expenseRepository.getExpenseFromUserIdByExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("Expense not found in your list");
        }
        expenseRepository.delete(expense);
        return getAllExpense();
    }
    //-- GET


    public List<Expense> getAllExpense() {
        User logInUser = serviceAll.getLogInUser();
        List<Expense> expenseList = expenseRepository.getExpenseListFromUserId(logInUser.getId());
        if (expenseList.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expenseList;
    }

    public Expense getExpenseBySubject(String subject) {
        User logInUser = serviceAll.getLogInUser();
        Expense expense = expenseRepository.getExpenseFromUserIdBySubject(logInUser.getId(), subject);
        if (expense == null) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expense;
    }

    public List<Expense> getExpenseListBySubjectContains(String subjectContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Expense> expenseList = expenseRepository.getExpenseListBySubjectContains(logInUser.getId(), subjectContains);
        if (expenseList.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expenseList;
    }

    public Expense getExpenseByExpenseId(Long expenseId) {
        User logInUser = serviceAll.getLogInUser();
        Expense expense = expenseRepository.getExpenseFromUserIdByExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expense;
    }

    public List<Expense> getExpenseListByUserId(Long userId) {
        User logInUser = serviceAll.getLogInUser();
        List<Expense> expenseList = expenseRepository.getExpenseListFromUserIdByUserId(logInUser.getId(), userId);
        if (expenseList.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expenseList;
    }

    public List<Expense> getExpenseListByTagId(Long tagId) {
        User logInUser = serviceAll.getLogInUser();
        List<Expense> expenseList = expenseRepository.getExpenseListFromUserIdByTagId(logInUser.getId(), tagId);
        if (expenseList.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expenseList;
    }

    public List<Expense> getExpenseListByReminderId(Long reminderId) {
        User logInUser = serviceAll.getLogInUser();
        List<Expense> expenseList = expenseRepository.getExpenseListFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (expenseList.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expenseList;
    }

    public List<Expense> getExpenseListByTopicId(Long topicId) {
        User logInUser = serviceAll.getLogInUser();
        List<Expense> expenseList = expenseRepository.getExpenseListFromUserIdByTopicId(logInUser.getId(), topicId);
        if (expenseList.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expenseList;
    }

    public List<Expense> getExpenseListByTasksId(Long tasksId) {
        User logInUser = serviceAll.getLogInUser();
        List<Expense> expenseList = expenseRepository.getExpenseListFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (expenseList.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expenseList;
    }

    //-- Other


}
