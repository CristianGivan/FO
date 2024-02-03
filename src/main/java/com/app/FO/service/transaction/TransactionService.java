package com.app.FO.service.transaction;

import com.app.FO.config.DateTime;
import com.app.FO.config.ServiceAll;
import com.app.FO.exceptions.*;
import com.app.FO.model.account.Account;
import com.app.FO.model.account.TransactionAccount;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.tasks.Tasks;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.transaction.*;
import com.app.FO.model.user.User;
import com.app.FO.repository.transaction.TransactionRepository;
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


        Account fromAccount = serviceAll.getAccountFromUserIdAndAccountId(logInUser.getId(), fromAccountId);
        if (fromAccount == null) {
            throw new AccountNotFoundException("Account not found in your list");
        }
        TransactionAccount fromTransactionAccount = serviceAll.getTransactionAccount(fromAccountId, transaction.getId());
        if (fromTransactionAccount != null) {
            throw new AccountTransactionAlreadyExistException("The account already has the transaction");
        }

        Account toAccount = serviceAll.getAccountFromUserIdAndAccountId(logInUser.getId(), toAccountId);
        if (toAccount == null) {
            throw new AccountNotFoundException("Account not found in your list");
        }

        TransactionAccount toTransactionAccount = serviceAll.getTransactionAccount(toAccountId, transaction.getId());
        if (toTransactionAccount != null) {
            throw new AccountTransactionAlreadyExistException("The account already has the transaction");
        }


        fromTransactionAccount = new TransactionAccount(fromAccount, transaction, sum, "from");
        toTransactionAccount = new TransactionAccount(toAccount, transaction, sum, "to");

        transaction.getTransactionAccountList().add(fromTransactionAccount);
        transaction.getTransactionAccountList().add(toTransactionAccount);
        transaction.getTransactionUserList().add(transactionUser);
        transaction.setTransactionStatus(TransactionStatus.CREATED);
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

        transaction.setSum(sum);

        return transactionRepository.save(transaction);
    }


    public Transaction putPlanedDateToTransaction(Long transactionId, String planedDate) {
        LocalDateTime planedDateTime = DateTime.textToLocalDateTime(planedDate);
        //todo if the date is in past throw exception
        User logInUser = serviceAll.getLogInUser();
        Transaction transaction = transactionRepository.getTransactionFromUserIdByTransactionId(logInUser.getId(), transactionId);
        if (transaction == null) {
            throw new TransactionNotFoundException("Transaction not found in your list");
        }

        //todo recalculate all planed balance


        if (transaction.getPlanedDate().equals(planedDateTime)) {
            throw new TransactionAlreadyExistException("Transaction has already the same subject");
        }

        transaction.setPlanedDate(planedDateTime);

        return transactionRepository.save(transaction);
    }

    public Transaction putCompletedDateToTransaction(Long transactionId, String completedDate) {
        LocalDateTime completedDateTime = DateTime.textToLocalDateTime(completedDate);
        User logInUser = serviceAll.getLogInUser();
        Transaction transaction = transactionRepository.getTransactionFromUserIdByTransactionId(logInUser.getId(), transactionId);
        if (transaction == null) {
            throw new TransactionNotFoundException("Transaction not found in your list");
        }

        //todo check if the transaction can be done see balance and recalculate balance of accounts

        if (transaction.getTransactionStatus() == TransactionStatus.COMPLETED) {
            throw new TransactionAlreadyExistException("Transaction is already completed");
        }

        Account fromAccount = serviceAll.getTransactionAccountByDirection("from", transactionId).getAccount();
        Account toAccount = serviceAll.getTransactionAccountByDirection("to", transactionId).getAccount();
        Double transactionSum = transaction.getSum();

        fromAccount.setBalance(fromAccount.getBalance() - transactionSum);
        toAccount.setBalance(toAccount.getBalance() + transactionSum);

        transaction.setTransactionStatus(TransactionStatus.COMPLETED);
        transaction.setCompletedDate(completedDateTime);

        return transactionRepository.save(transaction);
    }

    public Transaction putTransactionStatusToTransaction(Long transactionId, String transactionStatusText, String dateText) {
        LocalDateTime date = DateTime.textToLocalDateTime(dateText);
        User logInUser = serviceAll.getLogInUser();
        Transaction transaction = transactionRepository.getTransactionFromUserIdByTransactionId(logInUser.getId(), transactionId);
        if (transaction == null) {
            throw new TransactionNotFoundException("Transaction not found in your list");
        }

        TransactionStatus newTransactionStatus = serviceAll.convertTransactionStatusTextToTransactionStatus(transactionStatusText);
        TransactionStatus transactionStatus = transaction.getTransactionStatus();

        if (transactionStatus == newTransactionStatus) {
            throw new TransactionAlreadyExistException("Transaction has already the same status");
        }

        Account fromAccount = serviceAll.getTransactionAccountByDirection("from", transactionId).getAccount();
        Account toAccount = serviceAll.getTransactionAccountByDirection("to", transactionId).getAccount();
        Double transactionSum = transaction.getSum();


        //todo for each chase detect if Balance of planed balance is ok
        if (newTransactionStatus == TransactionStatus.UNDEFINE & transactionStatus == TransactionStatus.COMPLETED) {
            fromAccount.setBalance(fromAccount.getBalance() + transactionSum);
            toAccount.setBalance(toAccount.getBalance() - transactionSum);
        }

        if (newTransactionStatus == TransactionStatus.CREATED & transactionStatus == TransactionStatus.COMPLETED) {
            fromAccount.setBalance(fromAccount.getBalance() + transactionSum);
            toAccount.setBalance(toAccount.getBalance() - transactionSum);
        }


        if (newTransactionStatus == TransactionStatus.PLANED & transactionStatus == TransactionStatus.COMPLETED) {
            fromAccount.setBalance(fromAccount.getBalance() + transactionSum);
            toAccount.setBalance(toAccount.getBalance() - transactionSum);
            transaction.setPlanedDate(date);
        }

        if (newTransactionStatus == TransactionStatus.PENDING & transactionStatus == TransactionStatus.COMPLETED) {
            fromAccount.setBalance(fromAccount.getBalance() + transactionSum);
            toAccount.setBalance(toAccount.getBalance() - transactionSum);
        }

        if (newTransactionStatus == TransactionStatus.COMPLETED) {
            fromAccount.setBalance(fromAccount.getBalance() - transactionSum);
            toAccount.setBalance(toAccount.getBalance() + transactionSum);
            transaction.setCompletedDate(date);
        }

        transaction.setTransactionStatus(newTransactionStatus);

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

        Tag tag = serviceAll.getTagFromUserIdByTagId(logInUser.getId(), tagId);
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

        // todo to be tested
        Long otherAccountId;
        if (direction.equals("from")) {
            otherAccountId = serviceAll.getTransactionAccountByDirection("to", transactionId).getId();
        } else if (direction.equals("to")) {
            otherAccountId = serviceAll.getTransactionAccountByDirection("to", transactionId).getId();
        } else {
            otherAccountId = 0L;
        }
        if (accountId == otherAccountId) {
            throw new TransactionNotFoundException("Transaction have already this account");
        }

        Account account = serviceAll.getAccountFromUserIdAndAccountId(logInUser.getId(), accountId);
        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }
        TransactionAccount transactionAccount = serviceAll.getTransactionAccount(accountId, transactionId);
        if (transactionAccount != null) {
            throw new AccountTransactionAlreadyExistException("The transaction already has the account");
        }

        TransactionAccount replacedTransactionAccount = serviceAll.getTransactionAccountByDirection(direction, transactionId);
        if (replacedTransactionAccount == null) {
            throw new AccountTransactionNotFoundException("The transaction not found at account");
        }

        Account replacedAccount = replacedTransactionAccount.getAccount();

        if (transaction.getTransactionStatus() == TransactionStatus.COMPLETED) {
            if (direction.equals("from")) {
                replacedAccount.setBalance(replacedAccount.getBalance() + transaction.getSum());
                account.setBalance(account.getBalance() - transaction.getSum());
            } else if (direction.equals("to")) {
                replacedAccount.setBalance(replacedAccount.getBalance() - transaction.getSum());
                account.setBalance(account.getBalance() + transaction.getSum());
            } else {
                throw new AccountTransactionNotFoundException("The direction is not specified correctly");
            }
        }

        transactionAccount = new TransactionAccount(account, transaction, transaction.getSum(), direction);
        transaction.getTransactionAccountList().add(transactionAccount);
        //todo for the future the transactionAccount to be moved to history
        replacedTransactionAccount.setDirection(replacedTransactionAccount.getDirection() + "-deleted");
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

        Tag tag = serviceAll.getTagFromUserIdByTagId(logInUser.getId(), tagId);
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

    public Transaction getTransactionByTransactionId(Long transactionId) {
        User logInUser = serviceAll.getLogInUser();
        Transaction transaction = transactionRepository.getTransactionFromUserIdByTransactionId(logInUser.getId(), transactionId);
        if (transaction == null) {
            throw new TransactionNotFoundException("No transaction found");
        }
        return transaction;
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


    public List<Transaction> getTransactionByPlanedDate(String planedDate) {
        LocalDateTime planedDateTime = DateTime.textToLocalDateTime(planedDate);
        User logInUser = serviceAll.getLogInUser();
        List<Transaction> transactionList = transactionRepository.getTransactionFromUserIdByPlanedDate(logInUser.getId(), planedDateTime);
        if (transactionList.isEmpty()) {
            throw new TransactionNotFoundException("No transaction found");
        }
        return transactionList;
    }

    public List<Transaction> getTransactionListByPlanedDateBetween(String planedDateMin, String planedDateMax) {
        LocalDateTime planedDateTimeMin = DateTime.textToLocalDateTime(planedDateMin);
        LocalDateTime planedDateTimeMax = DateTime.textToLocalDateTime(planedDateMax);
        User logInUser = serviceAll.getLogInUser();
        List<Transaction> transactionList = transactionRepository.getTransactionListFromUserIdByPlanedDateBetween(logInUser.getId(), planedDateTimeMin, planedDateTimeMax);
        if (transactionList.isEmpty()) {
            throw new TransactionNotFoundException("No transaction found");
        }
        return transactionList;
    }


    public List<Transaction> getTransactionByCompletedDate(String completedDate) {
        LocalDateTime completedDateTime = DateTime.textToLocalDateTime(completedDate);
        User logInUser = serviceAll.getLogInUser();
        List<Transaction> transactionList = transactionRepository.getTransactionFromUserIdByCompletedDate(logInUser.getId(), completedDateTime);
        if (transactionList.isEmpty()) {
            throw new TransactionNotFoundException("No transaction found");
        }
        return transactionList;
    }

    public List<Transaction> getTransactionListByCompletedDateBetween(String completedDateMin, String completedDateMax) {
        LocalDateTime completedDateTimeMin = DateTime.textToLocalDateTime(completedDateMin);
        LocalDateTime completedDateTimeMax = DateTime.textToLocalDateTime(completedDateMax);
        User logInUser = serviceAll.getLogInUser();
        List<Transaction> transactionList = transactionRepository.getTransactionListFromUserIdByCompletedDateBetween(logInUser.getId(), completedDateTimeMin, completedDateTimeMax);
        if (transactionList.isEmpty()) {
            throw new TransactionNotFoundException("No transaction found");
        }
        return transactionList;
    }

    public List<Transaction> getTransactionByTransactionStatus(String transactionStatusText) {

        TransactionStatus transactionStatus = serviceAll.convertTransactionStatusTextToTransactionStatus(transactionStatusText);

        User logInUser = serviceAll.getLogInUser();
        List<Transaction> transactionList = transactionRepository.getTransactionListFromUserIdByTransactionStatus(logInUser.getId(), transactionStatus.getValue());
        if (transactionList.isEmpty()) {
            throw new TransactionNotFoundException("No transaction found");
        }
        return transactionList;
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

    public List<Transaction> getTransactionListByAccountWithDirection(Long accountId, String direction) {
        User logInUser = serviceAll.getLogInUser();
        List<Transaction> transactionList = transactionRepository.getTransactionListFromUserIdByAccountIdByDirection(logInUser.getId(), accountId, direction);
        if (transactionList.isEmpty()) {
            throw new TransactionNotFoundException("No transaction found");
        }
        return transactionList;
    }


    //-- Other


}
