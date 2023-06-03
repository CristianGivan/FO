package com.app.FO.controller;

import com.app.FO.mapper.dto.general.TextDTO;
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
    public ExpenseDTO postNewExpense(@RequestBody TextDTO noteText) {
        Expense expense = expenseService.postExpense(noteText.getText());
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }


    //-- PutMapping
    @PutMapping("/putSubjectToExpense")
    public ExpenseDTO putSubjectToExpense(@RequestParam Long expenseId, @RequestParam String subject) {
        Expense expense = expenseService.putSubjectToExpense(expenseId, subject);
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

    @GetMapping("/getExpenseById")
    public ExpenseDTO getExpenseById(@RequestParam Long expenseId) {
        Expense expense = expenseService.getExpenseByExpenseId(expenseId);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
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
