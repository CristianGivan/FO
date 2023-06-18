package com.app.FO.service.account;

import com.app.FO.config.DateTime;
import com.app.FO.config.ServiceAll;
import com.app.FO.exceptions.*;
import com.app.FO.model.account.*;
import com.app.FO.model.expenses.Expenses;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.tasks.Tasks;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.transaction.Transaction;
import com.app.FO.model.user.User;
import com.app.FO.repository.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    private ServiceAll serviceAll;

    @Autowired
    public AccountService(AccountRepository accountRepository, ServiceAll serviceAll) {
        this.accountRepository = accountRepository;
        this.serviceAll = serviceAll;
    }

    //-- Post

    public Account postAccount(String subject) {
        User logInUser = serviceAll.getLogInUser();

        Account account = accountRepository.getAccountFromUserIdBySubject(logInUser.getId(), subject);
        if (account != null) {
            throw new AccountAlreadyExistException("Account with this subject already exist");
        }

        account = accountRepository.save(new Account(subject, logInUser));

        AccountUser accountUser = new AccountUser(account, logInUser);
        account.getAccountUserList().add(accountUser);

        return accountRepository.save(account);
    }

    //-- Put
    public Account putSubjectToAccount(Long accountId, String subject) {
        User logInUser = serviceAll.getLogInUser();
        Account account = accountRepository.getAccountFromUserIdByAccountId(logInUser.getId(), accountId);
        if (account == null) {
            throw new AccountNotFoundException("Account not found in your list");
        }

        if (account.getSubject().equals(subject)) {
            throw new AccountAlreadyExistException("Account has already the same subject");
        }

        account.setSubject(subject);

        return accountRepository.save(account);
    }

    public Account putTypeToAccount(Long accountId, String type) {
        User logInUser = serviceAll.getLogInUser();
        Account account = accountRepository.getAccountFromUserIdByAccountId(logInUser.getId(), accountId);
        if (account == null) {
            throw new AccountNotFoundException("Account not found in your list");
        }

        account.setType(type);

        return accountRepository.save(account);
    }

    public Account putCreatedDateToAccount(Long accountId, String createdDate) {
        LocalDateTime createdDateTime = DateTime.textToLocalDateTime(createdDate);
        User logInUser = serviceAll.getLogInUser();
        Account account = accountRepository.getAccountFromUserIdByAccountId(logInUser.getId(), accountId);
        if (account == null) {
            throw new AccountNotFoundException("Account not found in your list");
        }

        if (account.getCreatedDate().equals(createdDateTime)) {
            throw new AccountAlreadyExistException("Account has already the same created date");
        }

        account.setCreatedDate(createdDateTime);

        return accountRepository.save(account);
    }

    public Account putUserToAccount(Long accountId, Long userId) {
        User logInUser = serviceAll.getLogInUser();
        Account account = accountRepository.getAccountFromUserIdByAccountId(logInUser.getId(), accountId);
        if (account == null) {
            throw new AccountNotFoundException("Account not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        AccountUser accountUser = serviceAll.getAccountUser(accountId, userId);
        if (accountUser != null) {
            throw new AccountUserAlreadyExistException("The account already has the user");
        }

        accountUser = new AccountUser(account, user);
        account.getAccountUserList().add(accountUser);

        return accountRepository.save(account);
    }

    public Account putTagToAccount(Long accountId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Account account = accountRepository.getAccountFromUserIdByAccountId(logInUser.getId(), accountId);
        if (account == null) {
            throw new AccountNotFoundException("Account not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdByTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        AccountTag accountTag = serviceAll.getAccountTag(accountId, tagId);
        if (accountTag != null) {
            throw new AccountTagAlreadyExistException("The account already has the tag");
        }

        accountTag = new AccountTag(account, tag);
        account.getAccountTagList().add(accountTag);

        return accountRepository.save(account);
    }


    public Account putReminderToAccount(Long accountId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Account account = accountRepository.getAccountFromUserIdByAccountId(logInUser.getId(), accountId);
        if (account == null) {
            throw new AccountNotFoundException("Account not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        AccountReminder accountReminder = serviceAll.getAccountReminder(accountId, reminderId);
        if (accountReminder != null) {
            throw new AccountReminderAlreadyExistException("The account already has the reminder");
        }

        accountReminder = new AccountReminder(account, reminder);
        account.getAccountReminderList().add(accountReminder);

        return accountRepository.save(account);
    }

    public Account putTopicToAccount(Long accountId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Account account = accountRepository.getAccountFromUserIdByAccountId(logInUser.getId(), accountId);
        if (account == null) {
            throw new AccountNotFoundException("Account not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        AccountTopic accountTopic = serviceAll.getAccountTopic(accountId, topicId);
        if (accountTopic != null) {
            throw new AccountTopicAlreadyExistException("The account already has the topic");
        }

        accountTopic = new AccountTopic(account, topic);
        account.getAccountTopicList().add(accountTopic);
        return accountRepository.save(account);
    }

    public Account putTasksToAccount(Long accountId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        Account account = accountRepository.getAccountFromUserIdByAccountId(logInUser.getId(), accountId);
        if (account == null) {
            throw new AccountNotFoundException("Account not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found");
        }

        AccountTasks accountTasks = serviceAll.getAccountTasks(accountId, tasksId);
        if (accountTasks != null) {
            throw new AccountTasksAlreadyExistException("The account already has the tasks");
        }

        accountTasks = new AccountTasks(account, tasks);
        account.getAccountTasksList().add(accountTasks);
        return accountRepository.save(account);
    }

    public Account putExpensesToAccount(Long accountId, Long expensesId) {
        User logInUser = serviceAll.getLogInUser();

        Account account = accountRepository.getAccountFromUserIdByAccountId(logInUser.getId(), accountId);
        if (account == null) {
            throw new AccountNotFoundException("Account not found in your list");
        }

        Expenses expenses = serviceAll.getExpensesFromUserIdAndExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("Expenses not found");
        }

        AccountExpenses accountExpenses = serviceAll.getAccountExpenses(accountId, expensesId);
        if (accountExpenses != null) {
            throw new AccountExpensesAlreadyExistException("The account already has the expenses");
        }

        accountExpenses = new AccountExpenses(account, expenses, expenses.getCheckedPrice());
        account.getAccountExpensesList().add(accountExpenses);
        return accountRepository.save(account);
    }

//    public Account putTransactionToAccount(Long accountId, Long transactionId) {
//        User logInUser = serviceAll.getLogInUser();
//
//        Account account = accountRepository.getAccountFromUserIdByAccountId(logInUser.getId(), accountId);
//        if (account == null) {
//            throw new AccountNotFoundException("Account not found in your list");
//        }
//
//        Transaction transaction = serviceAll.getTransactionFromUserIdAndTransactionId(logInUser.getId(), transactionId);
//        if (transaction == null) {
//            throw new TransactionNotFoundException("Transaction not found");
//        }
//
//        AccountTransaction accountTransaction = serviceAll.getAccountTransaction(accountId, transactionId);
//        if (accountTransaction != null) {
//            throw new AccountTransactionAlreadyExistException("The account already has the transaction");
//        }
//
//        accountTransaction = new AccountTransaction(account, transaction, transaction.getSum());
//        account.getAccountTransactionList().add(accountTransaction);
//        return accountRepository.save(account);
//    }

    //--Delete


    public Account deleteUserFromAccount(Long accountId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Account account = accountRepository.getAccountFromUserIdByAccountId(logInUser.getId(), accountId);
        if (account == null) {
            throw new AccountNotFoundException("Account not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        AccountUser accountUser = serviceAll.getAccountUser(accountId, userId);
        if (accountUser == null) {
            throw new AccountUserNotFoundException("The account don't has the user");
        }
        account.getAccountUserList().remove(accountUser);

        return accountRepository.save(account);
    }

    public Account deleteTagFromAccount(Long accountId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Account account = accountRepository.getAccountFromUserIdByAccountId(logInUser.getId(), accountId);
        if (account == null) {
            throw new AccountNotFoundException("Account not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdByTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        AccountTag accountTag = serviceAll.getAccountTag(accountId, tagId);
        if (accountTag == null) {
            throw new AccountTagNotFoundException("The account don't has the tag");
        }

        account.getAccountTagList().remove(accountTag);

        return accountRepository.save(account);
    }

    public Account deleteReminderFromAccount(Long accountId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Account account = accountRepository.getAccountFromUserIdByAccountId(logInUser.getId(), accountId);
        if (account == null) {
            throw new AccountNotFoundException("Account not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        AccountReminder accountReminder = serviceAll.getAccountReminder(accountId, reminderId);
        if (accountReminder == null) {
            throw new AccountReminderNotFoundException("The account don't has the reminder");
        }

        account.getAccountReminderList().remove(accountReminder);

        return accountRepository.save(account);
    }

    public Account deleteTopicFromAccount(Long accountId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Account account = accountRepository.getAccountFromUserIdByAccountId(logInUser.getId(), accountId);
        if (account == null) {
            throw new AccountNotFoundException("Account not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        AccountTopic accountTopic = serviceAll.getAccountTopic(accountId, topicId);
        if (accountTopic == null) {
            throw new AccountTasksNotFoundException("The account don't has the topic");
        }

        account.getAccountTopicList().remove(accountTopic);

        return accountRepository.save(account);
    }

    public Account deleteTasksFromAccount(Long accountId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        Account account = accountRepository.getAccountFromUserIdByAccountId(logInUser.getId(), accountId);
        if (account == null) {
            throw new AccountNotFoundException("Account not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found");
        }

        AccountTasks accountTasks = serviceAll.getAccountTasks(accountId, tasksId);
        if (accountTasks == null) {
            throw new AccountTasksNotFoundException("The account don't has the tasks");
        }

        account.getAccountTasksList().remove(accountTasks);

        return accountRepository.save(account);
    }

    public Account deleteExpensesFromAccount(Long accountId, Long expensesId) {
        User logInUser = serviceAll.getLogInUser();

        Account account = accountRepository.getAccountFromUserIdByAccountId(logInUser.getId(), accountId);
        if (account == null) {
            throw new AccountNotFoundException("Account not found in your list");
        }

        Expenses expenses = serviceAll.getExpensesFromUserIdAndExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("Expenses not found");
        }

        AccountExpenses accountExpenses = serviceAll.getAccountExpenses(accountId, expensesId);
        if (accountExpenses == null) {
            throw new AccountExpensesNotFoundException("The account don't has the expenses");
        }
        // todo tbc
//        Double sum  =expenses.total

        account.getAccountExpensesList().remove(accountExpenses);

        return accountRepository.save(account);
    }

    public Account deleteTransactionFromAccount(Long accountId, Long transactionId) {
        User logInUser = serviceAll.getLogInUser();

        Account account = accountRepository.getAccountFromUserIdByAccountId(logInUser.getId(), accountId);
        if (account == null) {
            throw new AccountNotFoundException("Account not found in your list");
        }

        Transaction transaction = serviceAll.getTransactionFromUserIdAndTransactionId(logInUser.getId(), transactionId);
        if (transaction == null) {
            throw new TransactionNotFoundException("Transaction not found");
        }

        AccountTransaction accountTransaction = serviceAll.getAccountTransaction(accountId, transactionId);
        if (accountTransaction == null) {
            throw new AccountTransactionNotFoundException("The account don't has the transaction");
        }

        account.getAccountTransactionList().remove(accountTransaction);

        return accountRepository.save(account);
    }

    public List<Account> deleteAccount(Long accountId) {
        User logInUser = serviceAll.getLogInUser();

        Account account = accountRepository.getAccountFromUserIdByAccountId(logInUser.getId(), accountId);
        if (account == null) {
            throw new AccountNotFoundException("Account not found in your list");
        }
        accountRepository.delete(account);
        return getAllAccount();
    }


    //-- GET


    public List<Account> getAllAccount() {
        User logInUser = serviceAll.getLogInUser();
        List<Account> accountList = accountRepository.getAccountListFromUserId(logInUser.getId());
        if (accountList.isEmpty()) {
            throw new AccountNotFoundException("No account found");
        }
        return accountList;
    }

    public Account getAccountByAccountId(Long accountId) {
        User logInUser = serviceAll.getLogInUser();
        Account account = accountRepository.getAccountFromUserIdByAccountId(logInUser.getId(), accountId);
        if (account == null) {
            throw new AccountNotFoundException("No account found");
        }
        return account;
    }

    public Account getAccountBySubject(String subject) {
        User logInUser = serviceAll.getLogInUser();
        Account account = accountRepository.getAccountFromUserIdBySubject(logInUser.getId(), subject);
        if (account == null) {
            throw new AccountNotFoundException("No account found");
        }
        return account;
    }

    public List<Account> getAccountListBySubjectContains(String subjectContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Account> accountList = accountRepository.getAccountListFromUserIdBySubjectContains(logInUser.getId(), subjectContains);
        if (accountList.isEmpty()) {
            throw new AccountNotFoundException("No account found");
        }
        return accountList;
    }

    public Account getAccountByType(String type) {
        User logInUser = serviceAll.getLogInUser();
        Account account = accountRepository.getAccountFromUserIdByType(logInUser.getId(), type);
        if (account == null) {
            throw new AccountNotFoundException("No account found");
        }
        return account;
    }

    public List<Account> getAccountByTypeContains(String typeContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Account> accountList = accountRepository.getAccountListFromUserIdByTypeContains(logInUser.getId(), typeContains);
        if (accountList.isEmpty()) {
            throw new AccountNotFoundException("No account found");
        }
        return accountList;
    }

    public Account getAccountByBalance(Double balance) {
        User logInUser = serviceAll.getLogInUser();
        Account account = accountRepository.getAccountFromUserIdByBalance(logInUser.getId(), balance);
        if (account == null) {
            throw new AccountNotFoundException("No account found");
        }
        return account;
    }

    public List<Account> getAccountByBalanceBetween(Double balanceMin, Double balanceMax) {
        User logInUser = serviceAll.getLogInUser();
        List<Account> accountList = accountRepository.getAccountListFromUserIdByBalanceBetween(logInUser.getId(), balanceMin, balanceMax);
        if (accountList.isEmpty()) {
            throw new AccountNotFoundException("No account found");
        }
        return accountList;
    }

    public Account getAccountByCreatedDate(String createdDate) {
        LocalDateTime createdDateTime = DateTime.textToLocalDateTime(createdDate);
        User logInUser = serviceAll.getLogInUser();
        Account account = accountRepository.getAccountFromUserIdByCreatedDate(logInUser.getId(), createdDateTime);
        if (account == null) {
            throw new AccountNotFoundException("No account found");
        }
        return account;
    }

    public List<Account> getAccountListByCreatedDateBetween(String createdDateMin, String createdDateMax) {
        LocalDateTime createdDateTimeMin = DateTime.textToLocalDateTime(createdDateMin);
        LocalDateTime createdDateTimeMax = DateTime.textToLocalDateTime(createdDateMax);
        User logInUser = serviceAll.getLogInUser();
        List<Account> accountList = accountRepository.getAccountListFromUserIdByCreatedDateBetween(logInUser.getId(), createdDateTimeMin, createdDateTimeMax);
        if (accountList.isEmpty()) {
            throw new AccountNotFoundException("No account found");
        }
        return accountList;
    }


    public List<Account> getAccountListByUserId(Long userId) {
        User logInUser = serviceAll.getLogInUser();
        List<Account> accountList = accountRepository.getAccountListFromUserIdByUserId(logInUser.getId(), userId);
        if (accountList.isEmpty()) {
            throw new AccountNotFoundException("No account found");
        }
        return accountList;
    }

    public List<Account> getAccountListByTagId(Long tagId) {
        User logInUser = serviceAll.getLogInUser();
        List<Account> accountList = accountRepository.getAccountListFromUserIdByTagId(logInUser.getId(), tagId);
        if (accountList.isEmpty()) {
            throw new AccountNotFoundException("No account found");
        }
        return accountList;
    }

    public List<Account> getAccountListByReminderId(Long reminderId) {
        User logInUser = serviceAll.getLogInUser();
        List<Account> accountList = accountRepository.getAccountListFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (accountList.isEmpty()) {
            throw new AccountNotFoundException("No account found");
        }
        return accountList;
    }

    public List<Account> getAccountListByTopicId(Long topicId) {
        User logInUser = serviceAll.getLogInUser();
        List<Account> accountList = accountRepository.getAccountListFromUserIdByTopicId(logInUser.getId(), topicId);
        if (accountList.isEmpty()) {
            throw new AccountNotFoundException("No account found");
        }
        return accountList;
    }

    public List<Account> getAccountListByTasksId(Long tasksId) {
        User logInUser = serviceAll.getLogInUser();
        List<Account> accountList = accountRepository.getAccountListFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (accountList.isEmpty()) {
            throw new AccountNotFoundException("No account found");
        }
        return accountList;
    }

    public List<Account> getAccountListByExpenses(Long tasksId) {
        User logInUser = serviceAll.getLogInUser();
        List<Account> accountList = accountRepository.getAccountListFromUserIdByExpensesId(logInUser.getId(), tasksId);
        if (accountList.isEmpty()) {
            throw new AccountNotFoundException("No account found");
        }
        return accountList;
    }

    public List<Account> getAccountListByTransaction(Long transactionId) {
        User logInUser = serviceAll.getLogInUser();
        List<Account> accountList = accountRepository.getAccountListFromUserIdByTransactionId(logInUser.getId(), transactionId);
        if (accountList.isEmpty()) {
            throw new AccountNotFoundException("No account found");
        }
        return accountList;
    }

    //-- Other


}
