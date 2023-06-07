package com.app.FO.controller;

import com.app.FO.mapper.dto.expenses.ExpensesDTO;
import com.app.FO.mapper.dto.general.TextDTO;
import com.app.FO.mapper.mappers.ExpensesDTOMapper;
import com.app.FO.model.expenses.Expenses;
import com.app.FO.service.expenses.ExpensesService;
import io.swagger.annotations.ApiOperation;
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

    @PutMapping("/putTypeToExpenses")
    public ExpensesDTO putTypeToExpenses(@RequestParam Long expensesId, @RequestParam String type) {
        Expenses expenses = expensesService.putTypeToExpenses(expensesId, type);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }

    @PutMapping("/putShopToExpenses")
    public ExpensesDTO putShopToExpenses(@RequestParam Long expensesId, @RequestParam String shop) {
        Expenses expenses = expensesService.putShopToExpenses(expensesId, shop);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }


    @PutMapping("/putPayedDateToExpenses")
    @ApiOperation(value = "Formatter \"yyyy-MM-dd HH:mm:ss\" 2023.06.01 13:14:15")
    public ExpensesDTO putPayedDateToExpenses(@RequestParam Long expensesId, @RequestParam String payedDate) {
        Expenses expenses = expensesService.putPayedDateToExpenses(expensesId, payedDate);
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

    @PutMapping("/putExpenseToExpenses")
    public ExpensesDTO putExpenseToExpenses(@RequestParam Long expensesId, @RequestParam Long expenseId) {
        Expenses expenses = expensesService.putExpenseToExpenses(expensesId, expenseId);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }

    @PutMapping("/putAccountToExpenses")
    public ExpensesDTO putAccountToExpenses(@RequestParam Long expensesId, @RequestParam Long accountId) {
        Expenses expenses = expensesService.putAccountToExpenses(expensesId, accountId);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }

    @PutMapping("/putPayerToExpenses")
    public ExpensesDTO putPayerToExpenses(@RequestParam Long expensesId, @RequestParam Long payerId) {
        Expenses expenses = expensesService.putPayerToExpenses(expensesId, payerId);
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

    @DeleteMapping("/deleteExpenseFromExpenses")
    public ExpensesDTO deleteExpenseFromExpenses(@RequestParam Long expensesId, @RequestParam Long expenseId) {
        Expenses expenses = expensesService.deleteExpenseFromExpenses(expensesId, expenseId);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }

    @DeleteMapping("/deleteAccountFromExpenses")
    public ExpensesDTO deleteAccountFromExpenses(@RequestParam Long expensesId, @RequestParam Long accountId) {
        Expenses expenses = expensesService.deleteAccountFromExpenses(expensesId, accountId);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }

    @DeleteMapping("/deletePayerFromExpenses")
    public ExpensesDTO deletePayerFromExpenses(@RequestParam Long expensesId, @RequestParam Long payerId) {
        Expenses expenses = expensesService.deletePayerFromExpenses(expensesId, payerId);
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


    @GetMapping("/getExpensesById")
    public ExpensesDTO getExpensesById(@RequestParam Long expensesId) {
        Expenses expenses = expensesService.getExpensesByExpensesId(expensesId);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
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


    @GetMapping("/getExpensesByType")
    public ExpensesDTO getExpensesByType(@RequestParam String subject) {
        Expenses expenses = expensesService.getExpensesByType(subject);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }

    @GetMapping("/getExpensesListByTypeContains")
    public List<ExpensesDTO> getExpensesListByTypeContains(@RequestParam String subjectContain) {
        List<Expenses> expensesList = expensesService.getExpensesListByTypeContains(subjectContain);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }

    @GetMapping("/getExpensesByShop")
    public ExpensesDTO getExpensesByShop(@RequestParam String shop) {
        Expenses expenses = expensesService.getExpensesByShop(shop);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }

    @GetMapping("/getExpensesListByShopContains")
    public List<ExpensesDTO> getExpensesListByShopContains(@RequestParam String shopContain) {
        List<Expenses> expensesList = expensesService.getExpensesListByShopContains(shopContain);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }


    @GetMapping("/getExpensesByCheckedPrice")
    public ExpensesDTO getExpensesByCheckedPrice(@RequestParam Double checkedPrice) {
        Expenses expenses = expensesService.getExpensesByCheckedPrice(checkedPrice);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }

    @GetMapping("/getExpensesListByCheckedPriceBetween")
    public List<ExpensesDTO> getExpensesListByCheckedPriceBetween(@RequestParam Double checkedPriceMin, @RequestParam Double checkedPriceMax) {
        List<Expenses> expensesList = expensesService.getExpensesListByCheckedPriceBetween(checkedPriceMin, checkedPriceMax);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }


    @GetMapping("/getExpensesByTotalPrice")
    public ExpensesDTO getExpensesByTotalPrice(@RequestParam Double totalPriceBetween) {
        Expenses expenses = expensesService.getExpensesByTotalPrice(totalPriceBetween);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }

    @GetMapping("/getExpensesListByTotalPriceBetween")
    public List<ExpensesDTO> getExpensesListByTotalPriceBetween(@RequestParam Double totalPriceMin, @RequestParam Double totalPriceMax) {
        List<Expenses> expensesList = expensesService.getExpensesListByTotalPriceBetween(totalPriceMin, totalPriceMax);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }


    @GetMapping("/getExpensesByPayedDate")
    public ExpensesDTO getExpensesByPayedDate(@RequestParam String payedDate) {
        Expenses expenses = expensesService.getExpensesByPayedDate(payedDate);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }

    @GetMapping("/getExpensesListByPayedDateBetween")
    public List<ExpensesDTO> getExpensesListByPayedDateBetween(@RequestParam String payedDateMin, @RequestParam String payedDateMax) {
        List<Expenses> expensesList = expensesService.getExpensesListByPayedDateBetween(payedDateMin, payedDateMax);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }

    @GetMapping("/getExpensesByCreatedDate")
    public ExpensesDTO getExpensesByCreatedDate(@RequestParam String createdDate) {
        Expenses expenses = expensesService.getExpensesByCreatedDate(createdDate);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }

    @GetMapping("/getExpensesListByCreatedDateBetween")
    public List<ExpensesDTO> getExpensesListByCreatedDateBetween(@RequestParam String payedDateMin, @RequestParam String payedDateMax) {
        List<Expenses> expensesList = expensesService.getExpensesListByCreatedDateBetween(payedDateMin, payedDateMax);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
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


    @GetMapping("/getExpensesListByExpenseId")
    public List<ExpensesDTO> getExpensesListByExpenseId(@RequestParam Long expenseId) {
        List<Expenses> expensesList = expensesService.getExpensesListByExpenseId(expenseId);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }


    @GetMapping("/getExpensesListByAccountId")
    public List<ExpensesDTO> getExpensesListByAccountId(@RequestParam Long accountId) {
        List<Expenses> expensesList = expensesService.getExpensesListByAccountId(accountId);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }


    @GetMapping("/getExpensesListByPayerId")
    public List<ExpensesDTO> getExpensesListByPayerId(@RequestParam Long payerId) {
        List<Expenses> expensesList = expensesService.getExpensesListByPayerId(payerId);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }

    //--- Other


}
