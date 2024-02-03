package com.app.FO.service.transaction;

import com.app.FO.config.DateTime;
import com.app.FO.exceptions.*;
import com.app.FO.model.account.Account;
import com.app.FO.model.account.AccountTransaction;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.tasks.Tasks;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.transaction.*;
import com.app.FO.model.user.User;
import com.app.FO.repository.transaction.TransactionRepository;
import com.app.FO.util.ServiceAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {
    private TransactionRepository transactionRepository;

    private ServiceAll serviceAll;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, ServiceAll serviceAll) {
        this.transactionRepository = transactionRepository;
        this.serviceAll = serviceAll;
    }

//-- Post

    public Transaction postTransaction(String subject, Double sum, Long fromAccountId, Long toAccountId) {
        User logInUser = serviceAll.getLogInUser();

        Transaction transaction = transactionRepository.getTransactionFromUserIdBySubject(logInUser.getId(), subject);
        if (transaction != null) {
            throw new TransactionAlreadyExistException("Transaction with this subject already exist");
        }

        transaction = transactionRepository.save(new Transaction(subject, logInUser, sum));

        TransactionUser transactionUser = new TransactionUser(transaction, logInUser);
        transaction.getTransactionUserList().add(transactionUser);

        Account fromAccount = serviceAll.getAccountFromUserIdAndAccountId(logInUser.getId(), fromAccountId);
        if (fromAccount == null) {
            throw new AccountNotFoundException("Account not found in your list");
        }
        AccountTransaction fromAccountTransaction = serviceAll.getAccountTransaction(fromAccountId, transaction.getId());
        if (fromAccountTransaction != null) {
            throw new AccountTransactionAlreadyExistException("The account already has the transaction");
        }

        Account toAccount = serviceAll.getAccountFromUserIdAndAccountId(logInUser.getId(), toAccountId);
        if (toAccount == null) {
            throw new AccountNotFoundException("Account not found in your list");
        }
        AccountTransaction toAccountTransaction = serviceAll.getAccountTransaction(toAccountId, transaction.getId());
        if (fromAccountTransaction != null) {
            throw new AccountTransactionAlreadyExistException("The account already has the transaction");
        }


        fromAccountTransaction = new AccountTransaction(fromAccount, transaction, transaction.getSum(), "from");
        toAccountTransaction = new AccountTransaction(toAccount, transaction, transaction.getSum(), "to");

        transaction.getAccountTransactionList().add(fromAccountTransaction);
        transaction.getAccountTransactionList().add(toAccountTransaction);
        fromAccount.setBalance(fromAccount.getBalance() - sum);
        toAccount.setBalance(toAccount.getBalance() + sum);
        return transactionRepository.save(transaction);
    }

    //-- Put
    public Transaction putSubjectToTransaction(Long transactionId, String subject) {
        User logInUser = serviceAll.getLogInUser();
        Transaction transaction = transactionRepository.getTransactionFromUserIdByTransactionId(logInUser.getId(), transactionId);
        if (transaction == null) {
            throw new TransactionNotFoundException("Transaction not found in your list");
        }

        if (transaction.getSubject().equals(subject)) {
            throw new TransactionAlreadyExistException("Transaction has already the same subject");
        }

        transaction.setSubject(subject);

        return transactionRepository.save(transaction);
    }

    public Transaction putTypeToTransaction(Long transactionId, String type) {
        User logInUser = serviceAll.getLogInUser();
        Transaction transaction = transactionRepository.getTransactionFromUserIdByTransactionId(logInUser.getId(), transactionId);
        if (transaction == null) {
            throw new TransactionNotFoundException("Transaction not found in your list");
        }

        if (transaction.getType().equals(type)) {
            throw new TransactionAlreadyExistException("Transaction has already the same type");
        }

        transaction.setType(type);

        return transactionRepository.save(transaction);
    }

    public Transaction putSumToTransaction(Long transactionId, Double sum) {
        //todo update also the balance from accounts
        User logInUser = serviceAll.getLogInUser();
        Transaction transaction = transactionRepository.getTransactionFromUserIdByTransactionId(logInUser.getId(), transactionId);
        if (transaction == null) {
            throw new TransactionNotFoundException("Transaction not found in your list");
        }

        if (transaction.getSum().equals(sum)) {
            throw new TransactionAlreadyExistException("Transaction has already the same sum");
        }

        Double sumDifference = sum - transaction.getSum();

        Account fromAccount = serviceAll.getAccountTransactionByDirection("from", transactionId).getAccount();
        Account toAccount = serviceAll.getAccountTransactionByDirection("to", transactionId).getAccount();


        fromAccount.setBalance(fromAccount.getBalance() + sumDifference);
        toAccount.setBalance(toAccount.getBalance() + sumDifference);

        transaction.setSum(sum);

        return transactionRepository.save(transaction);
    }

    public Transaction putUserToTransaction(Long transactionId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Transaction transaction = transactionRepository.getTransactionFromUserIdByTransactionId(logInUser.getId(), transactionId);
        if (transaction == null) {
            throw new TransactionNotFoundException("Transaction not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        TransactionUser transactionUser = serviceAll.getTransactionUser(transactionId, userId);
        if (transactionUser != null) {
            throw new TransactionUserAlreadyExistException("The transaction already has the user");
        }

        transactionUser = new TransactionUser(transaction, user);
        transaction.getTransactionUserList().add(transactionUser);

        return transactionRepository.save(transaction);
    }

    public Transaction putTagToTransaction(Long transactionId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Transaction transaction = transactionRepository.getTransactionFromUserIdByTransactionId(logInUser.getId(), transactionId);
        if (transaction == null) {
            throw new TransactionNotFoundException("Transaction not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdAndTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        TransactionTag transactionTag = serviceAll.getTransactionTag(transactionId, tagId);
        if (transactionTag != null) {
            throw new TransactionTagAlreadyExistException("The transaction already has the tag");
        }

        transactionTag = new TransactionTag(transaction, tag);
        transaction.getTransactionTagList().add(transactionTag);

        return transactionRepository.save(transaction);
    }


    public Transaction putReminderToTransaction(Long transactionId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Transaction transaction = transactionRepository.getTransactionFromUserIdByTransactionId(logInUser.getId(), transactionId);
        if (transaction == null) {
            throw new TransactionNotFoundException("Transaction not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        TransactionReminder transactionReminder = serviceAll.getTransactionReminder(transactionId, reminderId);
        if (transactionReminder != null) {
            throw new TransactionReminderAlreadyExistException("The transaction already has the reminder");
        }

        transactionReminder = new TransactionReminder(transaction, reminder);
        transaction.getTransactionReminderList().add(transactionReminder);

        return transactionRepository.save(transaction);
    }

    public Transaction putTopicToTransaction(Long transactionId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Transaction transaction = transactionRepository.getTransactionFromUserIdByTransactionId(logInUser.getId(), transactionId);
        if (transaction == null) {
            throw new TransactionNotFoundException("Transaction not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        TransactionTopic transactionTopic = serviceAll.getTransactionTopic(transactionId, topicId);
        if (transactionTopic != null) {
            throw new TransactionTopicAlreadyExistException("The transaction already has the topic");
        }

        transactionTopic = new TransactionTopic(transaction, topic);
        transaction.getTransactionTopicList().add(transactionTopic);
        return transactionRepository.save(transaction);
    }

    public Transaction putTasksToTransaction(Long transactionId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        Transaction transaction = transactionRepository.getTransactionFromUserIdByTransactionId(logInUser.getId(), transactionId);
        if (transaction == null) {
            throw new TransactionNotFoundException("Transaction not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found");
        }

        TransactionTasks transactionTasks = serviceAll.getTransactionTasks(transactionId, tasksId);
        if (transactionTasks != null) {
            throw new TransactionTasksAlreadyExistException("The transaction already has the tasks");
        }

        transactionTasks = new TransactionTasks(transaction, tasks);
        transaction.getTransactionTasksList().add(transactionTasks);
        return transactionRepository.save(transaction);
    }

    public Transaction putAccountToTransaction(Long transactionId, Long accountId, String direction) {
        //todo update balance of the previous account
        User logInUser = serviceAll.getLogInUser();

        Transaction transaction = transactionRepository.getTransactionFromUserIdByTransactionId(logInUser.getId(), transactionId);
        if (transaction == null) {
            throw new TransactionNotFoundException("Transaction not found in your list");
        }

        Account account = serviceAll.getAccountFromUserIdAndAccountId(logInUser.getId(), accountId);
        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }
        AccountTransaction accountTransaction = serviceAll.getAccountTransaction(accountId, transactionId);
        if (accountTransaction != null) {
            throw new AccountTransactionAlreadyExistException("The transaction already has the account");
        }

        AccountTransaction replacedAccountTransaction = serviceAll.getAccountTransactionByDirection(direction, transactionId);
        if (replacedAccountTransaction == null) {
            throw new AccountTransactionNotFoundException("The transaction not found at account");
        }
        Account replacedAccount = replacedAccountTransaction.getAccount();

        if (direction.equals("from")) {
            replacedAccount.setBalance(replacedAccount.getBalance() + transaction.getSum());
            account.setBalance(account.getBalance() - transaction.getSum());
        } else if (direction.equals("to")) {
            replacedAccount.setBalance(replacedAccount.getBalance() - transaction.getSum());
            account.setBalance(account.getBalance() + transaction.getSum());
        } else {
            throw new AccountTransactionNotFoundException("The direction is not specified correctly");
        }

        accountTransaction = new AccountTransaction(account, transaction, transaction.getSum(), direction);
        transaction.getAccountTransactionList().add(accountTransaction);
        //todo for the future the accountTransaction to be moved to history
        replacedAccountTransaction.setDirection(replacedAccountTransaction.getDirection() + " deleted");
        return transactionRepository.save(transaction);
    }

    //--Delete


    public Transaction deleteUserFromTransaction(Long transactionId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Transaction transaction = transactionRepository.getTransactionFromUserIdByTransactionId(logInUser.getId(), transactionId);
        if (transaction == null) {
            throw new TransactionNotFoundException("Transaction not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        TransactionUser transactionUser = serviceAll.getTransactionUser(transactionId, userId);
        if (transactionUser == null) {
            throw new TransactionUserNotFoundException("The transaction don't has the user");
        }
        transaction.getTransactionUserList().remove(transactionUser);

        return transactionRepository.save(transaction);
    }

    public Transaction deleteTagFromTransaction(Long transactionId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Transaction transaction = transactionRepository.getTransactionFromUserIdByTransactionId(logInUser.getId(), transactionId);
        if (transaction == null) {
            throw new TransactionNotFoundException("Transaction not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdAndTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        TransactionTag transactionTag = serviceAll.getTransactionTag(transactionId, tagId);
        if (transactionTag == null) {
            throw new TransactionTagNotFoundException("The transaction don't has the tag");
        }

        transaction.getTransactionTagList().remove(transactionTag);

        return transactionRepository.save(transaction);
    }

    public Transaction deleteReminderFromTransaction(Long transactionId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Transaction transaction = transactionRepository.getTransactionFromUserIdByTransactionId(logInUser.getId(), transactionId);
        if (transaction == null) {
            throw new TransactionNotFoundException("Transaction not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        TransactionReminder transactionReminder = serviceAll.getTransactionReminder(transactionId, reminderId);
        if (transactionReminder == null) {
            throw new TransactionReminderNotFoundException("The transaction don't has the reminder");
        }

        transaction.getTransactionReminderList().remove(transactionReminder);

        return transactionRepository.save(transaction);
    }

    public Transaction deleteTopicFromTransaction(Long transactionId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Transaction transaction = transactionRepository.getTransactionFromUserIdByTransactionId(logInUser.getId(), transactionId);
        if (transaction == null) {
            throw new TransactionNotFoundException("Transaction not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        TransactionTopic transactionTopic = serviceAll.getTransactionTopic(transactionId, topicId);
        if (transactionTopic == null) {
            throw new TransactionTasksNotFoundException("The transaction don't has the topic");
        }

        transaction.getTransactionTopicList().remove(transactionTopic);

        return transactionRepository.save(transaction);
    }

    public Transaction deleteTasksFromTransaction(Long transactionId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        Transaction transaction = transactionRepository.getTransactionFromUserIdByTransactionId(logInUser.getId(), transactionId);
        if (transaction == null) {
            throw new TransactionNotFoundException("Transaction not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found");
        }

        TransactionTasks transactionTasks = serviceAll.getTransactionTasks(transactionId, tasksId);
        if (transactionTasks == null) {
            throw new TransactionTasksNotFoundException("The transaction don't has the tasks");
        }

        transaction.getTransactionTasksList().remove(transactionTasks);

        return transactionRepository.save(transaction);
    }

    public List<Transaction> deleteTransaction(Long transactionId) {
        User logInUser = serviceAll.getLogInUser();

        Transaction transaction = transactionRepository.getTransactionFromUserIdByTransactionId(logInUser.getId(), transactionId);
        if (transaction == null) {
            throw new TransactionNotFoundException("Transaction not found in your list");
        }
        transactionRepository.delete(transaction);
        return getAllTransaction();
    }
    //-- GET


    public List<Transaction> getAllTransaction() {
        User logInUser = serviceAll.getLogInUser();
        List<Transaction> transactionList = transactionRepository.getTransactionListFromUserId(logInUser.getId());
        if (transactionList.isEmpty()) {
            throw new TransactionNotFoundException("No transaction found");
        }
        return transactionList;
    }

    public Transaction getTransactionBySubject(String subject) {
        User logInUser = serviceAll.getLogInUser();
        Transaction transaction = transactionRepository.getTransactionFromUserIdBySubject(logInUser.getId(), subject);
        if (transaction == null) {
            throw new TransactionNotFoundException("No transaction found");
        }
        return transaction;
    }

    public List<Transaction> getTransactionListBySubjectContains(String subjectContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Transaction> transactionList = transactionRepository.getTransactionListFromUserIdBySubjectContains(logInUser.getId(), subjectContains);
        if (transactionList.isEmpty()) {
            throw new TransactionNotFoundException("No transaction found");
        }
        return transactionList;
    }


    public Transaction getTransactionByType(String type) {
        User logInUser = serviceAll.getLogInUser();
        Transaction transaction = transactionRepository.getTransactionFromUserIdByType(logInUser.getId(), type);
        if (transaction == null) {
            throw new TransactionNotFoundException("No transaction found");
        }
        return transaction;
    }

    public List<Transaction> getTransactionListByTypeContains(String typeContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Transaction> transactionList = transactionRepository.getTransactionListFromUserIdByTypeContains(logInUser.getId(), typeContains);
        if (transactionList.isEmpty()) {
            throw new TransactionNotFoundException("No transaction found");
        }
        return transactionList;
    }


    public Transaction getTransactionBySum(Double sum) {
        User logInUser = serviceAll.getLogInUser();
        Transaction transaction = transactionRepository.getTransactionFromUserIdBySum(logInUser.getId(), sum);
        if (transaction == null) {
            throw new TransactionNotFoundException("No transaction found");
        }
        return transaction;
    }

    public List<Transaction> getTransactionListBySumBetween(Double sumMin, Double sumMax) {
        User logInUser = serviceAll.getLogInUser();
        List<Transaction> transactionList = transactionRepository.getTransactionListFromUserIdBySumBetween(logInUser.getId(), sumMin, sumMax);
        if (transactionList.isEmpty()) {
            throw new TransactionNotFoundException("No transaction found");
        }
        return transactionList;
    }

    public Transaction getTransactionByCreatedDate(String createdDate) {
        LocalDateTime createdDateTime = DateTime.textToLocalDateTime(createdDate);
        User logInUser = serviceAll.getLogInUser();
        Transaction transaction = transactionRepository.getTransactionFromUserIdByCreatedDate(logInUser.getId(), createdDateTime);
        if (transaction == null) {
            throw new TransactionNotFoundException("No transaction found");
        }
        return transaction;
    }

    public List<Transaction> getTransactionListByCreatedDateBetween(String createdDateMin, String createdDateMax) {
        LocalDateTime createdDateTimeMin = DateTime.textToLocalDateTime(createdDateMin);
        LocalDateTime createdDateTimeMax = DateTime.textToLocalDateTime(createdDateMax);
        User logInUser = serviceAll.getLogInUser();
        List<Transaction> transactionList = transactionRepository.getTransactionListFromUserIdByCreatedDateBetween(logInUser.getId(), createdDateTimeMin, createdDateTimeMax);
        if (transactionList.isEmpty()) {
            throw new TransactionNotFoundException("No transaction found");
        }
        return transactionList;
    }

    public Transaction getTransactionByTransactionId(Long transactionId) {
        User logInUser = serviceAll.getLogInUser();
        Transaction transaction = transactionRepository.getTransactionFromUserIdByTransactionId(logInUser.getId(), transactionId);
        if (transaction == null) {
            throw new TransactionNotFoundException("No transaction found");
        }
        return transaction;
    }

    public List<Transaction> getTransactionListByUserId(Long userId) {
        User logInUser = serviceAll.getLogInUser();
        List<Transaction> transactionList = transactionRepository.getTransactionListFromUserIdByUserId(logInUser.getId(), userId);
        if (transactionList.isEmpty()) {
            throw new TransactionNotFoundException("No transaction found");
        }
        return transactionList;
    }

    public List<Transaction> getTransactionListByTagId(Long tagId) {
        User logInUser = serviceAll.getLogInUser();
        List<Transaction> transactionList = transactionRepository.getTransactionListFromUserIdByTagId(logInUser.getId(), tagId);
        if (transactionList.isEmpty()) {
            throw new TransactionNotFoundException("No transaction found");
        }
        return transactionList;
    }

    public List<Transaction> getTransactionListByReminderId(Long reminderId) {
        User logInUser = serviceAll.getLogInUser();
        List<Transaction> transactionList = transactionRepository.getTransactionListFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (transactionList.isEmpty()) {
            throw new TransactionNotFoundException("No transaction found");
        }
        return transactionList;
    }

    public List<Transaction> getTransactionListByTopicId(Long topicId) {
        User logInUser = serviceAll.getLogInUser();
        List<Transaction> transactionList = transactionRepository.getTransactionListFromUserIdByTopicId(logInUser.getId(), topicId);
        if (transactionList.isEmpty()) {
            throw new TransactionNotFoundException("No transaction found");
        }
        return transactionList;
    }

    public List<Transaction> getTransactionListByTasksId(Long tasksId) {
        User logInUser = serviceAll.getLogInUser();
        List<Transaction> transactionList = transactionRepository.getTransactionListFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (transactionList.isEmpty()) {
            throw new TransactionNotFoundException("No transaction found");
        }
        return transactionList;
    }

    public List<Transaction> getTransactionListByAccountByDirection(Long accountId, String direction) {
        User logInUser = serviceAll.getLogInUser();
        List<Transaction> transactionList = transactionRepository.getTransactionListFromUserIdByAccountIdByDirection(logInUser.getId(), accountId, direction);
        if (transactionList.isEmpty()) {
            throw new TransactionNotFoundException("No transaction found");
        }
        return transactionList;
    }


    //-- Other


}
