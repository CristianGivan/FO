package com.app.FO.service.expense;

import com.app.FO.config.DateTime;
import com.app.FO.config.ServiceAll;
import com.app.FO.exceptions.*;
import com.app.FO.model.expense.*;
import com.app.FO.model.expenses.Expenses;
import com.app.FO.model.expenses.ExpensesExpense;
import com.app.FO.model.product.Product;
import com.app.FO.model.product.ProductExpense;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.tasks.Tasks;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;
import com.app.FO.repository.expense.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

        Expense expense = expenseRepository.save(new Expense(subject, logInUser));

        ExpenseUser expenseUser = new ExpenseUser(expense, logInUser);
        expense.getExpenseUserList().add(expenseUser);

        return expenseRepository.save(expense);
    }

    //-- Put

    public Expense putCheckedToExpense(Long expenseId, Boolean checked) {
        User logInUser = serviceAll.getLogInUser();
        Expense expense = expenseRepository.getExpenseFromUserIdByExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("Expense not found in your list");
        }

        if (expense.getChecked().equals(checked)) {
            throw new ExpenseAlreadyExistException("Expense has already the same checked");
        }

        // todo what shall be add to expense and product

        expense.setChecked(checked);


        return expenseRepository.save(expense);
    }

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


    public Expense putCategoryToExpense(Long expenseId, String category) {
        User logInUser = serviceAll.getLogInUser();
        Expense expense = expenseRepository.getExpenseFromUserIdByExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("Expense not found in your list");
        }

        expense.setCategory(category);

        return expenseRepository.save(expense);
    }

    public Expense putQuantityToExpense(Long expenseId, Double quantity) {
        User logInUser = serviceAll.getLogInUser();
        Expense expense = expenseRepository.getExpenseFromUserIdByExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("Expense not found in your list");
        }

        if (expense.getQuantity().equals(quantity)) {
            throw new ExpenseAlreadyExistException("Expense has already the same quantity");
        }

        expense.setQuantity(quantity);
        if (expense.getUnitPrice() == 0.0) {
            expense.setTotalPrice(quantity * expense.getEstimatedTotalPrice());
        } else {
            expense.setTotalPrice(quantity * expense.getUnitPrice());
        }


        Product product = expense.getProductExpenseList().get(0).getProduct();
        //todo also the expenses shall be updated
        //todo shall be check if the calculation are ok
        if (product != null) {
            //todo not to check for>=2 but else
            if (product.getNumberForMeanQuantity() >= 2) {
                Double meanQuantity = ((product.getMeanQuantity() * product.getNumberForMeanQuantity()) - expense.getQuantity()) / product.getNumberForMeanQuantity() - 1;
                product.setMeanQuantity(((meanQuantity * product.getNumberForMeanQuantity()) + quantity) / product.getNumberForMeanQuantity() + 1);
            } else {
                product.setMeanQuantity(quantity);
            }
        }
        return expenseRepository.save(expense);
    }

    public Expense putUnitPriceToExpense(Long expenseId, Double unitPrice) {
        User logInUser = serviceAll.getLogInUser();
        Expense expense = expenseRepository.getExpenseFromUserIdByExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("Expense not found in your list");
        }

        if (expense.getUnitPrice().equals(unitPrice)) {
            throw new ExpenseAlreadyExistException("Expense has already the same unitPrice");
        }

        expense.setUnitPrice(unitPrice);
        if (expense.getQuantity() == 0.0) {
            expense.setEstimatedTotalPrice(unitPrice * expense.getMeanQuantity());
        } else {
            expense.setEstimatedTotalPrice(unitPrice * expense.getQuantity());
        }
        Product product = expense.getProductExpenseList().get(0).getProduct();

        //todo also the expenses shall be updated
        //todo shall be check if the calculation are ok

        if (product != null) {

            if (product.getNumberForMeanPrice() >= 2) {
                Double meanUnitPrice = ((product.getMeanUnitPrice() * product.getNumberForMeanPrice()) - expense.getUnitPrice()) / product.getNumberForMeanPrice() - 1;
                product.setMeanUnitPrice(((meanUnitPrice * product.getNumberForMeanPrice()) + unitPrice) / product.getNumberForMeanPrice() + 1);
            } else {
                product.setMeanUnitPrice(unitPrice);
            }
        }
        return expenseRepository.save(expense);
    }

    public Expense putTotalPriceToExpense(Long expenseId, Double totalPrice) {
        User logInUser = serviceAll.getLogInUser();
        Expense expense = expenseRepository.getExpenseFromUserIdByExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("Expense not found in your list");
        }

        if (expense.getTotalPrice().equals(totalPrice)) {
            throw new ExpenseAlreadyExistException("Expense has already the same totalPrice");
        }

        expense.setTotalPrice(totalPrice);

        return expenseRepository.save(expense);
    }

    public Expense putEstimatedTotalPriceToExpense(Long expenseId, Double estimatedEstimatedTotalPrice) {
        User logInUser = serviceAll.getLogInUser();
        Expense expense = expenseRepository.getExpenseFromUserIdByExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("Expense not found in your list");
        }

        if (expense.getEstimatedTotalPrice().equals(estimatedEstimatedTotalPrice)) {
            throw new ExpenseAlreadyExistException("Expense has already the same estimatedEstimatedTotalPrice");
        }

        expense.setEstimatedTotalPrice(estimatedEstimatedTotalPrice);

        return expenseRepository.save(expense);
    }

    public Expense putCheckedDateToExpense(Long expenseId, String checkedDate) {
        LocalDateTime checkedDateTime = DateTime.textToLocalDateTime(checkedDate);
        User logInUser = serviceAll.getLogInUser();
        Expense expense = expenseRepository.getExpenseFromUserIdByExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("Expense not found in your list");
        }

        expense.setCheckedDate(checkedDateTime);

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

        Tag tag = serviceAll.getTagFromUserIdByTagId(logInUser.getId(), tagId);
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

    public Expense putProductToExpense(Long expenseId, Long productId) {
        User logInUser = serviceAll.getLogInUser();

        Expense expense = expenseRepository.getExpenseFromUserIdByExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("Expense not found in your list");
        }
        if (!expense.getProductExpenseList().isEmpty()) {
            throw new ExpenseNotFoundException("A product is already in the list do you want to replace it?");
        }

        Product product = serviceAll.getProductFromUserIdAndProductId(logInUser.getId(), productId);
        if (product == null) {
            throw new ProductNotFoundException("Product not found");
        }

        ProductExpense productExpense = serviceAll.getProductExpense(expenseId, productId);
        if (productExpense != null) {
            throw new ProductExpenseAlreadyExistException("The expense already has the product");
        }


        if (expense.getChecked()) {
            product.setNumberOfBuys(product.getNumberOfBuys() + 1);
        }
        if (expense.getQuantity() != 0.0) {
            product.setMeanQuantity(((product.getMeanQuantity() * product.getNumberForMeanQuantity()) + expense.getQuantity()) / product.getNumberForMeanQuantity() + 1);
        }
        if (expense.getUnitPrice() != 0.0) {
            product.setMeanUnitPrice(((product.getMeanUnitPrice() * product.getNumberForMeanPrice()) + expense.getUnitPrice()) / product.getNumberForMeanPrice() + 1);
        }

        expense.setMeanQuantity(product.getMeanQuantity());
        expense.setMeanUnitPrice(product.getMeanUnitPrice());
        expense.setEstimatedTotalPrice(product.getMeanQuantity() * product.getMeanUnitPrice());
        productExpense = new ProductExpense(product, expense);
        expense.getProductExpenseList().add(productExpense);
        return expenseRepository.save(expense);
    }


    public Expense putExpensesToExpense(Long expenseId, Long expensesId) {
        User logInUser = serviceAll.getLogInUser();

        Expense expense = expenseRepository.getExpenseFromUserIdByExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("Expense not found in your list");
        }

        Expenses expenses = serviceAll.getExpensesFromUserIdAndExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("Expenses not found");
        }

        ExpensesExpense expensesExpense = serviceAll.getExpensesExpense(expenseId, expensesId);
        if (expensesExpense != null) {
            throw new ExpensesExpenseAlreadyExistException("The expense already has the expenses");
        }

        expensesExpense = new ExpensesExpense(expenses, expense);
        expense.getExpensesExpenseList().add(expensesExpense);
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

        Tag tag = serviceAll.getTagFromUserIdByTagId(logInUser.getId(), tagId);
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

    public Expense deleteProductFromExpense(Long expenseId, Long productId) {
        User logInUser = serviceAll.getLogInUser();

        Expense expense = expenseRepository.getExpenseFromUserIdByExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("Expense not found in your list");
        }

        Product product = serviceAll.getProductFromUserIdAndProductId(logInUser.getId(), productId);
        if (product == null) {
            throw new ProductNotFoundException("Product not found");
        }

        ProductExpense expenseProduct = serviceAll.getProductExpense(productId, expenseId);
        if (expenseProduct == null) {
            throw new ProductExpenseNotFoundException("The expense don't has the product");
        }

        expense.getProductExpenseList().remove(expenseProduct);

        return expenseRepository.save(expense);
    }

    public Expense deleteExpensesFromExpense(Long expenseId, Long expensesId) {
        User logInUser = serviceAll.getLogInUser();

        Expense expense = expenseRepository.getExpenseFromUserIdByExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("Expense not found in your list");
        }

        Expenses expenses = serviceAll.getExpensesFromUserIdAndExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("Expenses not found");
        }

        ExpensesExpense expenseExpenses = serviceAll.getExpensesExpense(expensesId, expenseId);
        if (expenseExpenses == null) {
            throw new ExpensesExpenseNotFoundException("The expense don't has the expenses");
        }

        expense.getExpensesExpenseList().remove(expenseExpenses);

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

    public Expense getExpenseByExpenseId(Long expenseId) {
        User logInUser = serviceAll.getLogInUser();
        Expense expense = expenseRepository.getExpenseFromUserIdByExpenseId(logInUser.getId(), expenseId);
        if (expense == null) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expense;
    }


    public List<Expense> getExpenseListByChecked(Boolean checked) {
        User logInUser = serviceAll.getLogInUser();
        List<Expense> expenseList = expenseRepository.getExpenseListFromUserIdByChecked(logInUser.getId(), checked);
        if (expenseList.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expenseList;
    }


    public List<Expense> getExpenseListBySubject(String subject) {
        User logInUser = serviceAll.getLogInUser();
        List<Expense> expenseList = expenseRepository.getExpenseFromUserIdBySubject(logInUser.getId(), subject);
        if (expenseList.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expenseList;
    }

    public List<Expense> getExpenseListBySubjectContains(String subjectContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Expense> expenseList = expenseRepository.getExpenseListBySubjectContains(logInUser.getId(), subjectContains);
        if (expenseList.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expenseList;
    }


    public List<Expense> getExpenseListByCategory(String category) {
        User logInUser = serviceAll.getLogInUser();
        List<Expense> expenseList = expenseRepository.getExpenseFromUserIdByCategory(logInUser.getId(), category);
        if (expenseList.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expenseList;
    }

    public List<Expense> getExpenseListByCategoryContains(String categoryContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Expense> expenseList = expenseRepository.getExpenseListByCategoryContains(logInUser.getId(), categoryContains);
        if (expenseList.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expenseList;
    }


    public List<Expense> getExpenseListByQuantity(Double quantity) {
        User logInUser = serviceAll.getLogInUser();
        List<Expense> expenseList = expenseRepository.getExpenseFromUserIdByQuantity(logInUser.getId(), quantity);
        if (expenseList.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expenseList;
    }

    public List<Expense> getExpenseListByQuantityBetween(Double quantityMin, Double quantityMax) {
        User logInUser = serviceAll.getLogInUser();
        List<Expense> expenseList = expenseRepository.getExpenseListFromUserIdByQuantityBetween(logInUser.getId(), quantityMin, quantityMax);
        if (expenseList.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expenseList;
    }


    public List<Expense> getExpenseListByUnitPrice(Double unitPrice) {
        User logInUser = serviceAll.getLogInUser();
        List<Expense> expenseList = expenseRepository.getExpenseFromUserIdByUnitPrice(logInUser.getId(), unitPrice);
        if (expenseList.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expenseList;
    }

    public List<Expense> getExpenseListByUnitPriceBetween(Double unitPriceMin, Double unitPriceMax) {
        User logInUser = serviceAll.getLogInUser();
        List<Expense> expenseList = expenseRepository.getExpenseListFromUserIdByUnitPriceBetween(logInUser.getId(), unitPriceMin, unitPriceMax);
        if (expenseList.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expenseList;
    }


    public List<Expense> getExpenseListByTotalPrice(Double totalPrice) {
        User logInUser = serviceAll.getLogInUser();
        List<Expense> expenseList = expenseRepository.getExpenseFromUserIdByTotalPrice(logInUser.getId(), totalPrice);
        if (expenseList.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expenseList;
    }

    public List<Expense> getExpenseListByTotalPriceBetween(Double totalPriceMin, Double totalPriceMax) {
        User logInUser = serviceAll.getLogInUser();
        List<Expense> expenseList = expenseRepository.getExpenseListFromUserIdByTotalPriceBetween(logInUser.getId(), totalPriceMin, totalPriceMax);
        if (expenseList.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expenseList;
    }


    public List<Expense> getExpenseListByEstimatedTotalPrice(Double estimatedTotalPrice) {
        User logInUser = serviceAll.getLogInUser();
        List<Expense> expenseList = expenseRepository.getExpenseFromUserIdByEstimatedTotalPrice(logInUser.getId(), estimatedTotalPrice);
        if (expenseList.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expenseList;
    }

    public List<Expense> getExpenseListByEstimatedTotalPriceBetween(Double estimatedTotalPriceMin, Double estimatedTotalPriceMax) {
        User logInUser = serviceAll.getLogInUser();
        List<Expense> expenseList = expenseRepository.getExpenseListFromUserIdByEstimatedTotalPriceBetween(logInUser.getId(), estimatedTotalPriceMin, estimatedTotalPriceMax);
        if (expenseList.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expenseList;
    }


    public List<Expense> getExpenseListByCheckedDate(String checkedDate) {
        LocalDateTime checkedDateTime = DateTime.textToLocalDateTime(checkedDate);
        User logInUser = serviceAll.getLogInUser();
        List<Expense> expenseList = expenseRepository.getExpenseFromUserIdByCheckedDate(logInUser.getId(), checkedDateTime);
        if (expenseList.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expenseList;
    }

    public List<Expense> getExpenseListByCheckedDateBetween(String checkedDateMin, String checkedDateMax) {
        LocalDateTime checkedDateTimeMin = DateTime.textToLocalDateTime(checkedDateMin);
        LocalDateTime checkedDateTimeMax = DateTime.textToLocalDateTime(checkedDateMax);
        User logInUser = serviceAll.getLogInUser();
        List<Expense> expenseList = expenseRepository.getExpenseListFromUserIdByCheckedDateBetween(logInUser.getId(), checkedDateTimeMin, checkedDateTimeMax);
        if (expenseList.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expenseList;
    }


    public Expense getExpenseByCreatedDate(String createdDate) {
        LocalDateTime createdDateTime = DateTime.textToLocalDateTime(createdDate);
        User logInUser = serviceAll.getLogInUser();
        Expense expense = expenseRepository.getExpenseFromUserIdByCreatedDate(logInUser.getId(), createdDateTime);
        if (expense == null) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expense;
    }

    public List<Expense> getExpenseListByCreatedDateBetween(String createdDateMin, String createdDateMax) {
        LocalDateTime createdDateTimeMin = DateTime.textToLocalDateTime(createdDateMin);
        LocalDateTime createdDateTimeMax = DateTime.textToLocalDateTime(createdDateMax);
        User logInUser = serviceAll.getLogInUser();
        List<Expense> expenseList = expenseRepository.getExpenseListFromUserIdByCreatedDateBetween(logInUser.getId(), createdDateTimeMin, createdDateTimeMax);
        if (expenseList.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expenseList;
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

    public List<Expense> getExpenseListByProductId(Long productId) {
        User logInUser = serviceAll.getLogInUser();
        List<Expense> expenseList = expenseRepository.getExpenseListFromUserIdByProductId(logInUser.getId(), productId);
        if (expenseList.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expenseList;
    }

    public List<Expense> getExpenseListByExpensesId(Long expensesId) {
        User logInUser = serviceAll.getLogInUser();
        List<Expense> expenseList = expenseRepository.getExpenseListFromUserIdByExpensesId(logInUser.getId(), expensesId);
        if (expenseList.isEmpty()) {
            throw new ExpenseNotFoundException("No expense found");
        }
        return expenseList;
    }


    //-- Other


}
