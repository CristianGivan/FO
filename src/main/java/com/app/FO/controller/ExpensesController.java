package com.app.FO.controller;

import com.app.FO.mapper.dto.general.TextDTO;
import com.app.FO.mapper.dto.expenses.ExpensesDTO;
import com.app.FO.mapper.mappers.ExpensesDTOMapper;
import com.app.FO.model.expenses.Expenses;
import com.app.FO.service.expenses.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("expenses")
public class ExpensesController {
    private ExpensesService expensesService;

    private ExpensesDTOMapper expensesDTOMapper;

    @Autowired
    public ExpensesController(ExpensesService expensesService, ExpensesDTOMapper expensesDTOMapper) {
        this.expensesService = expensesService;
        this.expensesDTOMapper = expensesDTOMapper;
    }

    //-- PostMapping

    @PostMapping("/postNewExpenses")
    public ExpensesDTO postNewExpenses(@RequestBody TextDTO noteText) {
        Expenses expenses = expensesService.postExpenses(noteText.getText());
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }


    //-- PutMapping
    @PutMapping("/putSubjectToExpenses")
    public ExpensesDTO putSubjectToExpenses(@RequestParam Long expensesId, @RequestParam String subject) {
        Expenses expenses = expensesService.putSubjectToExpenses(expensesId, subject);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }

    @PutMapping("/putUserToExpenses")
    public ExpensesDTO putUserToExpenses(@RequestParam Long expensesId, @RequestParam Long userId) {
        Expenses expenses = expensesService.putUserToExpenses(expensesId, userId);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }

    @PutMapping("/putTagToExpenses")
    public ExpensesDTO putTagToExpenses(@RequestParam Long expensesId, @RequestParam Long tagId) {
        Expenses expenses = expensesService.putTagToExpenses(expensesId, tagId);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }


    @PutMapping("/putReminderToExpenses")
    public ExpensesDTO putReminderToExpenses(@RequestParam Long expensesId, @RequestParam Long reminderId) {
        Expenses expenses = expensesService.putReminderToExpenses(expensesId, reminderId);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }

    @PutMapping("/putTopicToExpenses")
    public ExpensesDTO putTopicToExpenses(@RequestParam Long expensesId, @RequestParam Long topicId) {
        Expenses expenses = expensesService.putTopicToExpenses(expensesId, topicId);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }

    @PutMapping("/putTasksToExpenses")
    public ExpensesDTO putTasksToExpenses(@RequestParam Long expensesId, @RequestParam Long tasksId) {
        Expenses expenses = expensesService.putTasksToExpenses(expensesId, tasksId);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }


    //-- DeleteMapping


    @DeleteMapping("/deleteUserFromExpenses")
    public ExpensesDTO deleteRoleFromExpenses(@RequestParam Long expensesId, @RequestParam Long userId) {
        Expenses expenses = expensesService.deleteUserFromExpenses(expensesId, userId);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }

    @DeleteMapping("/deleteTagFromExpenses")
    public ExpensesDTO deleteTagFromExpenses(@RequestParam Long expensesId, @RequestParam Long tagId) {
        Expenses expenses = expensesService.deleteTagFromExpenses(expensesId, tagId);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }

    @DeleteMapping("/deleteReminderFromExpenses")
    public ExpensesDTO deleteReminderFromExpenses(@RequestParam Long expensesId, @RequestParam Long reminderId) {
        Expenses expenses = expensesService.deleteReminderFromExpenses(expensesId, reminderId);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }


    @DeleteMapping("/deleteTopicFromExpenses")
    public ExpensesDTO deleteTopicFromExpenses(@RequestParam Long expensesId, @RequestParam Long topicId) {
        Expenses expenses = expensesService.deleteTopicFromExpenses(expensesId, topicId);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }

    @DeleteMapping("/deleteTasksFromExpenses")
    public ExpensesDTO deleteTasksFromExpenses(@RequestParam Long expensesId, @RequestParam Long tasksId) {
        Expenses expenses = expensesService.deleteTasksFromExpenses(expensesId, tasksId);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }

    @DeleteMapping("/deleteExpenses")
    public List<ExpensesDTO> deleteExpenses(@RequestParam Long expensesId) {
        List<Expenses> expensesList = expensesService.deleteExpenses(expensesId);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }


    //---GetMapping

    @GetMapping("/getAllExpenses")
    public List<ExpensesDTO> getAllExpenses() {
        List<Expenses> expensesList = expensesService.getAllExpenses();
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }


    @GetMapping("/getExpensesBySubject")
    public ExpensesDTO getExpensesBySubject(@RequestParam String subject) {
        Expenses expenses = expensesService.getExpensesBySubject(subject);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }

    @GetMapping("/getExpensesListBySubjectContains")
    public List<ExpensesDTO> getExpensesListBySubjectContains(@RequestParam String subjectContain) {
        List<Expenses> expensesList = expensesService.getExpensesListBySubjectContains(subjectContain);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }

    @GetMapping("/getExpensesById")
    public ExpensesDTO getExpensesById(@RequestParam Long expensesId) {
        Expenses expenses = expensesService.getExpensesByExpensesId(expensesId);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }


    @GetMapping("/getExpensesListByUserId")
    public List<ExpensesDTO> getExpensesListByUserId(@RequestParam Long userId) {
        List<Expenses> expensesList = expensesService.getExpensesListByUserId(userId);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }

    @GetMapping("/getExpensesListByTagId")
    public List<ExpensesDTO> getExpensesListByTagId(@RequestParam Long tagId) {
        List<Expenses> expensesList = expensesService.getExpensesListByTagId(tagId);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }

    @GetMapping("/getExpensesListByReminderId")
    public List<ExpensesDTO> getExpensesListByReminderId(@RequestParam Long reminderId) {
        List<Expenses> expensesList = expensesService.getExpensesListByReminderId(reminderId);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }

    @GetMapping("/getExpensesListByTopicId")
    public List<ExpensesDTO> getExpensesListByTopicId(@RequestParam Long topicId) {
        List<Expenses> expensesList = expensesService.getExpensesListByTopicId(topicId);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }

    @GetMapping("/getExpensesListByTasksId")
    public List<ExpensesDTO> getExpensesListByTasksId(@RequestParam Long tasksId) {
        List<Expenses> expensesList = expensesService.getExpensesListByTasksId(tasksId);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }


    //--- Other


}
