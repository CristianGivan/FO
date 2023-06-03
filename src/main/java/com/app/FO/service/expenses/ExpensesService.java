package com.app.FO.service.expenses;

import com.app.FO.exceptions.*;
import com.app.FO.model.expenses.*;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.tasks.Tasks;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;
import com.app.FO.repository.expenses.ExpensesRepository;
import com.app.FO.util.ServiceAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpensesService {
    private ExpensesRepository expensesRepository;

    private ServiceAll serviceAll;

    @Autowired
    public ExpensesService(ExpensesRepository expensesRepository, ServiceAll serviceAll) {
        this.expensesRepository = expensesRepository;
        this.serviceAll = serviceAll;
    }

//-- Post

    public Expenses postExpenses(String subject) {
        User logInUser = serviceAll.getLogInUser();

        Expenses expenses = expensesRepository.getExpensesFromUserIdBySubject(logInUser.getId(), subject);
        if (expenses != null) {
            throw new ExpensesAlreadyExistException("Expenses with this subject already exist");
        }

        expenses = expensesRepository.save(new Expenses(subject, logInUser));

        ExpensesUser expensesUser = new ExpensesUser(expenses, logInUser);
        expenses.getExpensesUserList().add(expensesUser);

        return expensesRepository.save(expenses);
    }

    //-- Put
    public Expenses putSubjectToExpenses(Long expensesId, String subject) {
        User logInUser = serviceAll.getLogInUser();
        Expenses expenses = expensesRepository.getExpensesFromUserIdByExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("Expenses not found in your list");
        }

        if (expenses.getSubject().equals(subject)) {
            throw new ExpensesAlreadyExistException("Expenses has already the same subject");
        }

        expenses.setSubject(subject);

        return expensesRepository.save(expenses);
    }

    public Expenses putUserToExpenses(Long expensesId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Expenses expenses = expensesRepository.getExpensesFromUserIdByExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("Expenses not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        ExpensesUser expensesUser = serviceAll.getExpensesUser(expensesId, userId);
        if (expensesUser != null) {
            throw new ExpensesUserAlreadyExistException("The expenses already has the user");
        }

        expensesUser = new ExpensesUser(expenses, user);
        expenses.getExpensesUserList().add(expensesUser);

        return expensesRepository.save(expenses);
    }

    public Expenses putTagToExpenses(Long expensesId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Expenses expenses = expensesRepository.getExpensesFromUserIdByExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("Expenses not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdAndTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        ExpensesTag expensesTag = serviceAll.getExpensesTag(expensesId, tagId);
        if (expensesTag != null) {
            throw new ExpensesTagAlreadyExistException("The expenses already has the tag");
        }

        expensesTag = new ExpensesTag(expenses, tag);
        expenses.getExpensesTagList().add(expensesTag);

        return expensesRepository.save(expenses);
    }


    public Expenses putReminderToExpenses(Long expensesId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Expenses expenses = expensesRepository.getExpensesFromUserIdByExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("Expenses not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        ExpensesReminder expensesReminder = serviceAll.getExpensesReminder(expensesId, reminderId);
        if (expensesReminder != null) {
            throw new ExpensesReminderAlreadyExistException("The expenses already has the reminder");
        }

        expensesReminder = new ExpensesReminder(expenses, reminder);
        expenses.getExpensesReminderList().add(expensesReminder);

        return expensesRepository.save(expenses);
    }

    public Expenses putTopicToExpenses(Long expensesId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Expenses expenses = expensesRepository.getExpensesFromUserIdByExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("Expenses not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        ExpensesTopic expensesTopic = serviceAll.getExpensesTopic(expensesId, topicId);
        if (expensesTopic != null) {
            throw new ExpensesTopicAlreadyExistException("The expenses already has the topic");
        }

        expensesTopic = new ExpensesTopic(expenses, topic);
        expenses.getExpensesTopicList().add(expensesTopic);
        return expensesRepository.save(expenses);
    }

    public Expenses putTasksToExpenses(Long expensesId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        Expenses expenses = expensesRepository.getExpensesFromUserIdByExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("Expenses not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found");
        }

        ExpensesTasks expensesTasks = serviceAll.getExpensesTasks(expensesId, tasksId);
        if (expensesTasks != null) {
            throw new ExpensesTasksAlreadyExistException("The expenses already has the tasks");
        }

        expensesTasks = new ExpensesTasks(expenses, tasks);
        expenses.getExpensesTasksList().add(expensesTasks);
        return expensesRepository.save(expenses);
    }


    //--Delete


    public Expenses deleteUserFromExpenses(Long expensesId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Expenses expenses = expensesRepository.getExpensesFromUserIdByExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("Expenses not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        ExpensesUser expensesUser = serviceAll.getExpensesUser(expensesId, userId);
        if (expensesUser == null) {
            throw new ExpensesUserNotFoundException("The expenses don't has the user");
        }
        expenses.getExpensesUserList().remove(expensesUser);

        return expensesRepository.save(expenses);
    }

    public Expenses deleteTagFromExpenses(Long expensesId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Expenses expenses = expensesRepository.getExpensesFromUserIdByExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("Expenses not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdAndTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        ExpensesTag expensesTag = serviceAll.getExpensesTag(expensesId, tagId);
        if (expensesTag == null) {
            throw new ExpensesTagNotFoundException("The expenses don't has the tag");
        }

        expenses.getExpensesTagList().remove(expensesTag);

        return expensesRepository.save(expenses);
    }

    public Expenses deleteReminderFromExpenses(Long expensesId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Expenses expenses = expensesRepository.getExpensesFromUserIdByExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("Expenses not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        ExpensesReminder expensesReminder = serviceAll.getExpensesReminder(expensesId, reminderId);
        if (expensesReminder == null) {
            throw new ExpensesReminderNotFoundException("The expenses don't has the reminder");
        }

        expenses.getExpensesReminderList().remove(expensesReminder);

        return expensesRepository.save(expenses);
    }

    public Expenses deleteTopicFromExpenses(Long expensesId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Expenses expenses = expensesRepository.getExpensesFromUserIdByExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("Expenses not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        ExpensesTopic expensesTopic = serviceAll.getExpensesTopic(expensesId, topicId);
        if (expensesTopic == null) {
            throw new ExpensesTasksNotFoundException("The expenses don't has the topic");
        }

        expenses.getExpensesTopicList().remove(expensesTopic);

        return expensesRepository.save(expenses);
    }

    public Expenses deleteTasksFromExpenses(Long expensesId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        Expenses expenses = expensesRepository.getExpensesFromUserIdByExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("Expenses not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found");
        }

        ExpensesTasks expensesTasks = serviceAll.getExpensesTasks(expensesId, tasksId);
        if (expensesTasks == null) {
            throw new ExpensesTasksNotFoundException("The expenses don't has the tasks");
        }

        expenses.getExpensesTasksList().remove(expensesTasks);

        return expensesRepository.save(expenses);
    }

    public List<Expenses> deleteExpenses(Long expensesId) {
        User logInUser = serviceAll.getLogInUser();

        Expenses expenses = expensesRepository.getExpensesFromUserIdByExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("Expenses not found in your list");
        }
        expensesRepository.delete(expenses);
        return getAllExpenses();
    }
    //-- GET


    public List<Expenses> getAllExpenses() {
        User logInUser = serviceAll.getLogInUser();
        List<Expenses> expensesList = expensesRepository.getExpensesListFromUserId(logInUser.getId());
        if (expensesList.isEmpty()) {
            throw new ExpensesNotFoundException("No expenses found");
        }
        return expensesList;
    }

    public Expenses getExpensesBySubject(String subject) {
        User logInUser = serviceAll.getLogInUser();
        Expenses expenses = expensesRepository.getExpensesFromUserIdBySubject(logInUser.getId(), subject);
        if (expenses == null) {
            throw new ExpensesNotFoundException("No expenses found");
        }
        return expenses;
    }

    public List<Expenses> getExpensesListBySubjectContains(String subjectContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Expenses> expensesList = expensesRepository.getExpensesListBySubjectContains(logInUser.getId(), subjectContains);
        if (expensesList.isEmpty()) {
            throw new ExpensesNotFoundException("No expenses found");
        }
        return expensesList;
    }

    public Expenses getExpensesByExpensesId(Long expensesId) {
        User logInUser = serviceAll.getLogInUser();
        Expenses expenses = expensesRepository.getExpensesFromUserIdByExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("No expenses found");
        }
        return expenses;
    }

    public List<Expenses> getExpensesListByUserId(Long userId) {
        User logInUser = serviceAll.getLogInUser();
        List<Expenses> expensesList = expensesRepository.getExpensesListFromUserIdByUserId(logInUser.getId(), userId);
        if (expensesList.isEmpty()) {
            throw new ExpensesNotFoundException("No expenses found");
        }
        return expensesList;
    }

    public List<Expenses> getExpensesListByTagId(Long tagId) {
        User logInUser = serviceAll.getLogInUser();
        List<Expenses> expensesList = expensesRepository.getExpensesListFromUserIdByTagId(logInUser.getId(), tagId);
        if (expensesList.isEmpty()) {
            throw new ExpensesNotFoundException("No expenses found");
        }
        return expensesList;
    }

    public List<Expenses> getExpensesListByReminderId(Long reminderId) {
        User logInUser = serviceAll.getLogInUser();
        List<Expenses> expensesList = expensesRepository.getExpensesListFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (expensesList.isEmpty()) {
            throw new ExpensesNotFoundException("No expenses found");
        }
        return expensesList;
    }

    public List<Expenses> getExpensesListByTopicId(Long topicId) {
        User logInUser = serviceAll.getLogInUser();
        List<Expenses> expensesList = expensesRepository.getExpensesListFromUserIdByTopicId(logInUser.getId(), topicId);
        if (expensesList.isEmpty()) {
            throw new ExpensesNotFoundException("No expenses found");
        }
        return expensesList;
    }

    public List<Expenses> getExpensesListByTasksId(Long tasksId) {
        User logInUser = serviceAll.getLogInUser();
        List<Expenses> expensesList = expensesRepository.getExpensesListFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (expensesList.isEmpty()) {
            throw new ExpensesNotFoundException("No expenses found");
        }
        return expensesList;
    }

    //-- Other


}
