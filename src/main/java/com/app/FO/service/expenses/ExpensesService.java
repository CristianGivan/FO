package com.app.FO.service.expenses;

import com.app.FO.config.DateTime;
import com.app.FO.exceptions.*;
import com.app.FO.model.account.Account;
import com.app.FO.model.account.AccountExpenses;
import com.app.FO.model.expense.Expense;
import com.app.FO.model.expenses.*;
import com.app.FO.model.person.Person;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.tasks.Tasks;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;
import com.app.FO.repository.expenses.ExpensesRepository;
import com.app.FO.util.ServiceAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public Expenses putTypeToExpenses(Long expensesId, String type) {
        User logInUser = serviceAll.getLogInUser();
        Expenses expenses = expensesRepository.getExpensesFromUserIdByExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("Expenses not found in your list");
        }
//
//        if (expenses.getType().equals(type)) {
//            throw new ExpensesAlreadyExistException("Expenses has already the same type");
//        }

        expenses.setType(type);

        return expensesRepository.save(expenses);
    }

    public Expenses putShopToExpenses(Long expensesId, String shop) {
        User logInUser = serviceAll.getLogInUser();
        Expenses expenses = expensesRepository.getExpensesFromUserIdByExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("Expenses not found in your list");
        }

//        if (expenses.getShop().equals(shop)) {
//            throw new ExpensesAlreadyExistException("Expenses has already the same shop");
//        }

        expenses.setShop(shop);

        return expensesRepository.save(expenses);
    }

    public Expenses putPayedDateToExpenses(Long expensesId, String payedDate) {
        LocalDateTime payedDateTime = DateTime.textToLocalDateTime(payedDate);
        User logInUser = serviceAll.getLogInUser();
        Expenses expenses = expensesRepository.getExpensesFromUserIdByExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("Expenses not found in your list");
        }

//        if (expenses.getPayedDate().equals(payedDateTime)) {
//            throw new ExpensesAlreadyExistException("Expenses has already the same payed date");
//        }

        expenses.setPayedDate(payedDateTime);

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

        Tag tag = serviceAll.getTagFromUserIdByTagId(logInUser.getId(), tagId);
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

    public Expenses putExpenseToExpenses(Long expensesId, Long expenseId) {
        User logInUser = serviceAll.getLogInUser();

        Expenses expenses = expensesRepository.getExpensesFromUserIdByExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("Expenses not found in your list");
        }

        Expense expense = serviceAll.getExpenseFromUserIdAndExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("Expense not found");
        }

        ExpensesExpense expensesExpense = serviceAll.getExpensesExpense(expensesId, expenseId);
        if (expensesExpense != null) {
            throw new ExpensesExpenseAlreadyExistException("The expenses already has the expense");
        }

        expensesExpense = new ExpensesExpense(expenses, expense, logInUser);
        expenses.getExpensesExpenseList().add(expensesExpense);
        return expensesRepository.save(expenses);
    }

    public Expenses putAccountToExpenses(Long expensesId, Long accountId) {
        //todo check is the sum is added
        User logInUser = serviceAll.getLogInUser();

        Expenses expenses = expensesRepository.getExpensesFromUserIdByExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("Expenses not found in your list");
        }

        Account account = serviceAll.getAccountFromUserIdAndAccountId(logInUser.getId(), accountId);
        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }

        AccountExpenses accountExpenses = serviceAll.getAccountExpenses(expensesId, accountId);
        if (accountExpenses != null) {
            throw new AccountExpensesAlreadyExistException("The expenses already has the account");
        }

        accountExpenses = new AccountExpenses(account, expenses, expenses.getCheckedPrice());
        expenses.getAccountExpensesList().add(accountExpenses);
        return expensesRepository.save(expenses);
    }

    public Expenses putAccountToExpensesWithAmount(Long expensesId, Long accountId, Double amount) {
        //todo add more account to an expenses
        User logInUser = serviceAll.getLogInUser();

        Expenses expenses = expensesRepository.getExpensesFromUserIdByExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("Expenses not found in your list");
        }

        Account account = serviceAll.getAccountFromUserIdAndAccountId(logInUser.getId(), accountId);
        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }//todo maybe asked for update

        AccountExpenses accountExpenses = serviceAll.getAccountExpenses(expensesId, accountId);
        if (accountExpenses != null) {
            throw new AccountExpensesAlreadyExistException("The expenses already has the account");
        }

        accountExpenses = new AccountExpenses(account, expenses, amount);
        expenses.getAccountExpensesList().add(accountExpenses);
        return expensesRepository.save(expenses);
    }


    public Expenses putPayerToExpenses(Long expensesId, Long personId) {
        User logInUser = serviceAll.getLogInUser();

        Expenses expenses = expensesRepository.getExpensesFromUserIdByExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("Expenses not found in your list");
        }

        Person person = serviceAll.getPersonFromUserIdAndPersonId(logInUser.getId(), personId);
        if (person == null) {
            throw new PersonNotFoundException("Person not found");
        }

        ExpensesPerson expensesPerson = serviceAll.getExpensesPerson(expensesId, personId);
        if (expensesPerson != null) {
            throw new ExpensesPersonAlreadyExistException("The expenses already has the person");
        }

        expensesPerson = new ExpensesPerson(expenses, person);
        expenses.getExpensesPersonList().add(expensesPerson);
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

        Tag tag = serviceAll.getTagFromUserIdByTagId(logInUser.getId(), tagId);
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

    public Expenses deleteExpenseFromExpenses(Long expensesId, Long expenseId) {
        User logInUser = serviceAll.getLogInUser();

        Expenses expenses = expensesRepository.getExpensesFromUserIdByExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("Expenses not found in your list");
        }

        Expense expense = serviceAll.getExpenseFromUserIdAndExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("Expense not found");
        }

        ExpensesExpense expensesExpense = serviceAll.getExpensesExpense(expensesId, expenseId);
        if (expensesExpense == null) {
            throw new ExpensesExpenseNotFoundException("The expenses don't has the expense");
        }

        expenses.getExpensesExpenseList().remove(expensesExpense);

        return expensesRepository.save(expenses);
    }

    public Expenses deleteAccountFromExpenses(Long expensesId, Long accountId) {
        //todo check how to add money back to account

        User logInUser = serviceAll.getLogInUser();

        Expenses expenses = expensesRepository.getExpensesFromUserIdByExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("Expenses not found in your list");
        }

        Account account = serviceAll.getAccountFromUserIdAndAccountId(logInUser.getId(), accountId);
        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }

        AccountExpenses accountExpenses = serviceAll.getAccountExpenses(expensesId, accountId);
        if (accountExpenses == null) {
            throw new AccountExpensesNotFoundException("The expenses don't has the account");
        }

        expenses.getAccountExpensesList().remove(accountExpenses);

        return expensesRepository.save(expenses);
    }

    public Expenses deletePayerFromExpenses(Long expensesId, Long personId) {
        User logInUser = serviceAll.getLogInUser();

        Expenses expenses = expensesRepository.getExpensesFromUserIdByExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("Expenses not found in your list");
        }

        Person person = serviceAll.getPersonFromUserIdAndPersonId(logInUser.getId(), personId);
        if (person == null) {
            throw new PersonNotFoundException("Person not found");
        }

        ExpensesPerson expensesPerson = serviceAll.getExpensesPerson(expensesId, personId);
        if (expensesPerson == null) {
            throw new ExpensesPersonNotFoundException("The expenses don't has the person");
        }

        expenses.getExpensesPersonList().remove(expensesPerson);

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

    public Expenses getExpensesByExpensesId(Long expensesId) {
        User logInUser = serviceAll.getLogInUser();
        Expenses expenses = expensesRepository.getExpensesFromUserIdByExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("No expenses found");
        }
        return expenses;
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

    public Expenses getExpensesByType(String type) {
        User logInUser = serviceAll.getLogInUser();
        Expenses expenses = expensesRepository.getExpensesFromUserIdByType(logInUser.getId(), type);
        if (expenses == null) {
            throw new ExpensesNotFoundException("No expenses found");
        }
        return expenses;
    }

    public List<Expenses> getExpensesListByTypeContains(String typeContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Expenses> expensesList = expensesRepository.getExpensesListByTypeContains(logInUser.getId(), typeContains);
        if (expensesList.isEmpty()) {
            throw new ExpensesNotFoundException("No expenses found");
        }
        return expensesList;
    }

    public Expenses getExpensesByShop(String shop) {
        User logInUser = serviceAll.getLogInUser();
        Expenses expenses = expensesRepository.getExpensesFromUserIdByShop(logInUser.getId(), shop);
        if (expenses == null) {
            throw new ExpensesNotFoundException("No expenses found");
        }
        return expenses;
    }

    public List<Expenses> getExpensesListByShopContains(String shopContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Expenses> expensesList = expensesRepository.getExpensesListFromUserIdByShopContains(logInUser.getId(), shopContains);
        if (expensesList.isEmpty()) {
            throw new ExpensesNotFoundException("No expenses found");
        }
        return expensesList;
    }

    public Expenses getExpensesByCheckedPrice(Double checkedPrice) {
        User logInUser = serviceAll.getLogInUser();
        Expenses expenses = expensesRepository.getExpensesFromUserIdByCheckedPrice(logInUser.getId(), checkedPrice);
        if (expenses == null) {
            throw new ExpensesNotFoundException("No expenses found");
        }
        return expenses;
    }

    public List<Expenses> getExpensesListByCheckedPriceBetween(Double checkedPriceMin, Double checkedPriceMax) {
        User logInUser = serviceAll.getLogInUser();
        List<Expenses> expensesList = expensesRepository.getExpensesListFromUserIdByCheckedPriceBetween(logInUser.getId(), checkedPriceMin, checkedPriceMax);
        if (expensesList.isEmpty()) {
            throw new ExpensesNotFoundException("No expenses found");
        }
        return expensesList;
    }


    public Expenses getExpensesByTotalPrice(Double totalPrice) {
        User logInUser = serviceAll.getLogInUser();
        Expenses expenses = expensesRepository.getExpensesFromUserIdByTotalPrice(logInUser.getId(), totalPrice);
        if (expenses == null) {
            throw new ExpensesNotFoundException("No expenses found");
        }
        return expenses;
    }

    public List<Expenses> getExpensesListByTotalPriceBetween(Double totalPriceMin, Double totalPriceMax) {
        User logInUser = serviceAll.getLogInUser();
        List<Expenses> expensesList = expensesRepository.getExpensesListFromUserIdByTotalPriceBetween(logInUser.getId(), totalPriceMin, totalPriceMax);
        if (expensesList.isEmpty()) {
            throw new ExpensesNotFoundException("No expenses found");
        }
        return expensesList;
    }

    public Expenses getExpensesByPayedDate(String payedDate) {
        LocalDateTime payedDateTime = DateTime.textToLocalDateTime(payedDate);
        User logInUser = serviceAll.getLogInUser();
        Expenses expenses = expensesRepository.getExpensesFromUserIdByPayedDate(logInUser.getId(), payedDateTime);
        if (expenses == null) {
            throw new ExpensesNotFoundException("No expenses found");
        }
        return expenses;
    }

    public List<Expenses> getExpensesListByPayedDateBetween(String payedDateMin, String payedDateMax) {
        LocalDateTime payedDateTimeMin = DateTime.textToLocalDateTime(payedDateMin);
        LocalDateTime payedDateTimeMax = DateTime.textToLocalDateTime(payedDateMax);
        User logInUser = serviceAll.getLogInUser();
        List<Expenses> expensesList = expensesRepository.getExpensesListFromUserIdByPayedDateBetween(logInUser.getId(), payedDateTimeMin, payedDateTimeMax);
        if (expensesList.isEmpty()) {
            throw new ExpensesNotFoundException("No expenses found");
        }
        return expensesList;
    }

    public Expenses getExpensesByCreatedDate(String createdDate) {
        LocalDateTime createdDateTime = DateTime.textToLocalDateTime(createdDate);
        User logInUser = serviceAll.getLogInUser();
        Expenses expenses = expensesRepository.getExpensesFromUserIdByCreatedDate(logInUser.getId(), createdDateTime);
        if (expenses == null) {
            throw new ExpensesNotFoundException("No expenses found");
        }
        return expenses;
    }

    public List<Expenses> getExpensesListByCreatedDateBetween(String createdDateMin, String createdDateMax) {
        LocalDateTime createdDateTimeMin = DateTime.textToLocalDateTime(createdDateMin);
        LocalDateTime createdDateTimeMax = DateTime.textToLocalDateTime(createdDateMax);
        User logInUser = serviceAll.getLogInUser();
        List<Expenses> expensesList = expensesRepository.getExpensesListFromUserIdByCreatedDateBetween(logInUser.getId(), createdDateTimeMin, createdDateTimeMax);
        if (expensesList.isEmpty()) {
            throw new ExpensesNotFoundException("No expenses found");
        }
        return expensesList;
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

    public List<Expenses> getExpensesListByExpenseId(Long expenseId) {
        User logInUser = serviceAll.getLogInUser();
        List<Expenses> expensesList = expensesRepository.getExpensesListFromUserIdByExpenseId(logInUser.getId(), expenseId);
        if (expensesList.isEmpty()) {
            throw new ExpensesNotFoundException("No expenses found");
        }
        return expensesList;
    }

    public List<Expenses> getExpensesListByAccountId(Long accountId) {
        User logInUser = serviceAll.getLogInUser();
        List<Expenses> expensesList = expensesRepository.getExpensesListFromUserIdByAccountId(logInUser.getId(), accountId);
        if (expensesList.isEmpty()) {
            throw new ExpensesNotFoundException("No expenses found");
        }
        return expensesList;
    }

    public List<Expenses> getExpensesListByPayerId(Long payerId) {
        User logInUser = serviceAll.getLogInUser();
        List<Expenses> expensesList = expensesRepository.getExpensesListFromUserIdByPayerId(logInUser.getId(), payerId);
        if (expensesList.isEmpty()) {
            throw new ExpensesNotFoundException("No expenses found");
        }
        return expensesList;
    }

    //-- Other


}
