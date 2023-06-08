package com.app.FO.controller;

import com.app.FO.mapper.dto.expense.ExpenseDTO;
import com.app.FO.mapper.mappers.ExpenseDTOMapper;
import com.app.FO.model.expense.Expense;
import com.app.FO.service.expense.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("expense")
public class ExpenseController {
    private ExpenseService expenseService;

    private ExpenseDTOMapper expenseDTOMapper;

    @Autowired
    public ExpenseController(ExpenseService expenseService, ExpenseDTOMapper expenseDTOMapper) {
        this.expenseService = expenseService;
        this.expenseDTOMapper = expenseDTOMapper;
    }

    //-- PostMapping

    @PostMapping("/postNewExpense")
    public ExpenseDTO postNewExpense(@RequestParam String name, @RequestParam String producer) {
        Expense expense = expenseService.postExpense(name, producer);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }


    //-- PutMapping

    @PutMapping("/putNameToExpense")
    public ExpenseDTO putNameToExpense(@RequestParam Long expenseId, @RequestParam String name) {
        Expense expense = expenseService.putNameToExpense(expenseId, name);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }

    @PutMapping("/putProducerToExpense")
    public ExpenseDTO putProducerToExpense(@RequestParam Long expenseId, @RequestParam String producer) {
        Expense expense = expenseService.putProducerToExpense(expenseId, producer);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }


    @PutMapping("/putCategoryToExpense")
    public ExpenseDTO putCategoryToExpense(@RequestParam Long expenseId, @RequestParam String category) {
        Expense expense = expenseService.putCategoryToExpense(expenseId, category);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }


    @PutMapping("/putUserToExpense")
    public ExpenseDTO putUserToExpense(@RequestParam Long expenseId, @RequestParam Long userId) {
        Expense expense = expenseService.putUserToExpense(expenseId, userId);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }

    @PutMapping("/putTagToExpense")
    public ExpenseDTO putTagToExpense(@RequestParam Long expenseId, @RequestParam Long tagId) {
        Expense expense = expenseService.putTagToExpense(expenseId, tagId);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }


    @PutMapping("/putReminderToExpense")
    public ExpenseDTO putReminderToExpense(@RequestParam Long expenseId, @RequestParam Long reminderId) {
        Expense expense = expenseService.putReminderToExpense(expenseId, reminderId);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }

    @PutMapping("/putTopicToExpense")
    public ExpenseDTO putTopicToExpense(@RequestParam Long expenseId, @RequestParam Long topicId) {
        Expense expense = expenseService.putTopicToExpense(expenseId, topicId);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }

    @PutMapping("/putTasksToExpense")
    public ExpenseDTO putTasksToExpense(@RequestParam Long expenseId, @RequestParam Long tasksId) {
        Expense expense = expenseService.putTasksToExpense(expenseId, tasksId);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }


    //-- DeleteMapping


    @DeleteMapping("/deleteUserFromExpense")
    public ExpenseDTO deleteRoleFromExpense(@RequestParam Long expenseId, @RequestParam Long userId) {
        Expense expense = expenseService.deleteUserFromExpense(expenseId, userId);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }

    @DeleteMapping("/deleteTagFromExpense")
    public ExpenseDTO deleteTagFromExpense(@RequestParam Long expenseId, @RequestParam Long tagId) {
        Expense expense = expenseService.deleteTagFromExpense(expenseId, tagId);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }

    @DeleteMapping("/deleteReminderFromExpense")
    public ExpenseDTO deleteReminderFromExpense(@RequestParam Long expenseId, @RequestParam Long reminderId) {
        Expense expense = expenseService.deleteReminderFromExpense(expenseId, reminderId);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }


    @DeleteMapping("/deleteTopicFromExpense")
    public ExpenseDTO deleteTopicFromExpense(@RequestParam Long expenseId, @RequestParam Long topicId) {
        Expense expense = expenseService.deleteTopicFromExpense(expenseId, topicId);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }

    @DeleteMapping("/deleteTasksFromExpense")
    public ExpenseDTO deleteTasksFromExpense(@RequestParam Long expenseId, @RequestParam Long tasksId) {
        Expense expense = expenseService.deleteTasksFromExpense(expenseId, tasksId);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }

    @DeleteMapping("/deleteExpense")
    public List<ExpenseDTO> deleteExpense(@RequestParam Long expenseId) {
        List<Expense> expenseList = expenseService.deleteExpense(expenseId);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }


    //---GetMapping

    @GetMapping("/getAllExpense")
    public List<ExpenseDTO> getAllExpense() {
        List<Expense> expenseList = expenseService.getAllExpense();
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }

    @GetMapping("/getExpenseById")
    public ExpenseDTO getExpenseById(@RequestParam Long expenseId) {
        Expense expense = expenseService.getExpenseByExpenseId(expenseId);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }

    @GetMapping("/getExpenseByName")
    public ExpenseDTO getExpenseByName(@RequestParam String name) {
        Expense expense = expenseService.getExpenseByName(name);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }

    @GetMapping("/getExpenseListByNameContains")
    public List<ExpenseDTO> getExpenseListByNameContains(@RequestParam String nameContain) {
        List<Expense> expenseList = expenseService.getExpenseListByNameContains(nameContain);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }


    @GetMapping("/getExpenseByProducer")
    public ExpenseDTO getExpenseByProducer(@RequestParam String producer) {
        Expense expense = expenseService.getExpenseByProducer(producer);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }

    @GetMapping("/getExpenseListByProducerContains")
    public List<ExpenseDTO> getExpenseListByProducerContains(@RequestParam String producerContain) {
        List<Expense> expenseList = expenseService.getExpenseListByProducerContains(producerContain);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }


    @GetMapping("/getExpenseBySubject")
    public ExpenseDTO getExpenseBySubject(@RequestParam String subject) {
        Expense expense = expenseService.getExpenseBySubject(subject);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }

    @GetMapping("/getExpenseListBySubjectContains")
    public List<ExpenseDTO> getExpenseListBySubjectContains(@RequestParam String subjectContain) {
        List<Expense> expenseList = expenseService.getExpenseListBySubjectContains(subjectContain);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }

    @GetMapping("/getExpenseByCategory")
    public ExpenseDTO getExpenseByCategory(@RequestParam String category) {
        Expense expense = expenseService.getExpenseByCategory(category);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }

    @GetMapping("/getExpenseListByCategoryContains")
    public List<ExpenseDTO> getExpenseListByCategoryContains(@RequestParam String categoryContain) {
        List<Expense> expenseList = expenseService.getExpenseListByCategoryContains(categoryContain);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }

    @GetMapping("/getExpenseByNumberOfBuys")
    public ExpenseDTO getExpenseByNumberOfBuys(@RequestParam Integer numberOfBuys) {
        Expense expense = expenseService.getExpenseByNumberOfBuys(numberOfBuys);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }

    @GetMapping("/getExpenseListByNumberOfBuysBetween")
    public List<ExpenseDTO> getExpenseListByNumberOfBuysBetween(@RequestParam Integer numberOfBuysMin, @RequestParam Integer numberOfBuysMax) {
        List<Expense> expenseList = expenseService.getExpenseListByNumberOfBuysBetween(numberOfBuysMin, numberOfBuysMax);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }

    @GetMapping("/getExpenseByNumberForMean")
    public ExpenseDTO getExpenseByNumberForMean(@RequestParam Integer numberForMean) {
        Expense expense = expenseService.getExpenseByNumberForMean(numberForMean);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }

    @GetMapping("/getExpenseListByNumberForMeanBetween")
    public List<ExpenseDTO> getExpenseListByNumberForMeanBetween(@RequestParam Integer numberForMeanMin, @RequestParam Integer numberForMeanMax) {
        List<Expense> expenseList = expenseService.getExpenseListByNumberForMeanBetween(numberForMeanMin, numberForMeanMax);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }

    @GetMapping("/getExpenseByMeanQuantity")
    public ExpenseDTO getExpenseByMeanQuantity(@RequestParam Double meanQuantity) {
        Expense expense = expenseService.getExpenseByMeanQuantity(meanQuantity);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }

    @GetMapping("/getExpenseListByMeanQuantityBetween")
    public List<ExpenseDTO> getExpenseListByMeanQuantityBetween(@RequestParam Double meanQuantityMin, @RequestParam Double meanQuantityMax) {
        List<Expense> expenseList = expenseService.getExpenseListByMeanQuantityBetween(meanQuantityMin, meanQuantityMax);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }

    @GetMapping("/getExpenseByMeanUnitPrice")
    public ExpenseDTO getExpenseByMeanUnitPrice(@RequestParam Double meanUnitPrice) {
        Expense expense = expenseService.getExpenseByMeanUnitPrice(meanUnitPrice);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }

    @GetMapping("/getExpenseListByMeanUnitPriceBetween")
    public List<ExpenseDTO> getExpenseListByMeanUnitPriceBetween(@RequestParam Double meanUnitPriceMin, @RequestParam Double meanUnitPriceMax) {
        List<Expense> expenseList = expenseService.getExpenseListByMeanUnitPriceBetween(meanUnitPriceMin, meanUnitPriceMax);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }

    @GetMapping("/getExpenseByCreatedDate")
    public ExpenseDTO getExpenseByCreatedDate(@RequestParam String createdDate) {
        Expense expense = expenseService.getExpenseByCreatedDate(createdDate);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }

    @GetMapping("/getExpenseListByCreatedDateBetween")
    public List<ExpenseDTO> getExpenseListByCreatedDateBetween(@RequestParam String createdDateMin, @RequestParam String createdDateMax) {
        List<Expense> expenseList = expenseService.getExpenseListByCreatedDateBetween(createdDateMin, createdDateMax);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }

    @GetMapping("/getExpenseListByUserId")
    public List<ExpenseDTO> getExpenseListByUserId(@RequestParam Long userId) {
        List<Expense> expenseList = expenseService.getExpenseListByUserId(userId);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }

    @GetMapping("/getExpenseListByTagId")
    public List<ExpenseDTO> getExpenseListByTagId(@RequestParam Long tagId) {
        List<Expense> expenseList = expenseService.getExpenseListByTagId(tagId);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }

    @GetMapping("/getExpenseListByReminderId")
    public List<ExpenseDTO> getExpenseListByReminderId(@RequestParam Long reminderId) {
        List<Expense> expenseList = expenseService.getExpenseListByReminderId(reminderId);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }

    @GetMapping("/getExpenseListByTopicId")
    public List<ExpenseDTO> getExpenseListByTopicId(@RequestParam Long topicId) {
        List<Expense> expenseList = expenseService.getExpenseListByTopicId(topicId);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }

    @GetMapping("/getExpenseListByTasksId")
    public List<ExpenseDTO> getExpenseListByTasksId(@RequestParam Long tasksId) {
        List<Expense> expenseList = expenseService.getExpenseListByTasksId(tasksId);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }


    //--- Other


}
