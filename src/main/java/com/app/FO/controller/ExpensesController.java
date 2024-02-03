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

    @PutMapping("/putExpensesStatusToExpenses")
    public ExpensesDTO putExpensesStatusToExpenses(@RequestParam Long expensesId, @RequestParam String expensesStatus, @RequestParam String date) {
        Expenses expenses = expensesService.putExpensesStatusToExpenses(expensesId, expensesStatus, date);
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


    @PutMapping("/putPersonToExpenses")
    public ExpensesDTO putPersonToExpenses(@RequestParam Long expensesId, @RequestParam Long personId) {
        Expenses expenses = expensesService.putPersonToExpenses(expensesId, personId);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }

    @PutMapping("/putShopToExpenses")
    public ExpensesDTO putShopToExpenses(@RequestParam Long expensesId, @RequestParam Long shopId) {
        Expenses expenses = expensesService.putShopToExpenses(expensesId, shopId);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }


    @PutMapping("/putExpenseToExpenses")
    public ExpensesDTO putExpenseToExpenses(@RequestParam Long expensesId, @RequestParam Long expenseId) {
        Expenses expenses = expensesService.putExpenseToExpenses(expensesId, expenseId);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }

    @PutMapping("/putCheckedToExpenseToExpenses")
    public ExpensesDTO putCheckedToExpenseToExpenses(@RequestParam Long expensesId, @RequestParam Long expenseId, @RequestParam Boolean checked) {
        Expenses expenses = expensesService.putCheckedToExpenseToExpenses(expensesId, expenseId, checked);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }

    @PutMapping("/putAccountToExpenses")
    public ExpensesDTO putAccountToExpenses(@RequestParam Long expensesId, @RequestParam Long accountId) {
        Expenses expenses = expensesService.putAccountToExpenses(expensesId, accountId);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }

    @PutMapping("/putAccountToExpensesWithAmount")
    public ExpensesDTO putAccountToExpensesWithAmount(@RequestParam Long expensesId, @RequestParam Long accountId, @RequestParam Double sumFromAccount) {
        Expenses expenses = expensesService.putAccountToExpensesWithAmount(expensesId, accountId, sumFromAccount);
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

    @DeleteMapping("/deletePersonFromExpenses")
    public ExpensesDTO deletePersonFromExpenses(@RequestParam Long expensesId, @RequestParam Long personId) {
        Expenses expenses = expensesService.deletePersonFromExpenses(expensesId, personId);
        return expensesDTOMapper.expensesToExpensesDTO(expenses);
    }

    @DeleteMapping("/deleteShopFromExpenses")
    public ExpensesDTO deleteShopFromExpenses(@RequestParam Long expensesId) {
        Expenses expenses = expensesService.deleteShopFromExpenses(expensesId);
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


    @GetMapping("/getExpensesListBySubject")
    public List<ExpensesDTO> getExpensesListBySubject(@RequestParam String subject) {
        List<Expenses> expensesList = expensesService.getExpensesListBySubject(subject);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }

    @GetMapping("/getExpensesListBySubjectContains")
    public List<ExpensesDTO> getExpensesListBySubjectContains(@RequestParam String subjectContain) {
        List<Expenses> expensesList = expensesService.getExpensesListBySubjectContains(subjectContain);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }


    @GetMapping("/getExpensesListByType")
    public List<ExpensesDTO> getExpensesListByType(@RequestParam String type) {
        List<Expenses> expensesList = expensesService.getExpensesListByType(type);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }

    @GetMapping("/getExpensesListByTypeContains")
    public List<ExpensesDTO> getExpensesListByTypeContains(@RequestParam String typeContains) {
        List<Expenses> expensesList = expensesService.getExpensesListByTypeContains(typeContains);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }

    @GetMapping("/getExpensesListByExpensesStatus")
    public List<ExpensesDTO> getExpensesListByExpensesStatus(@RequestParam String expensesStatus) {
        List<Expenses> expensesList = expensesService.getExpensesListByExpensesStatus(expensesStatus);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }


    @GetMapping("/getExpensesListByExpensesNumber")
    public List<ExpensesDTO> getExpensesByExpensesNumber(@RequestParam Integer expensesNumber) {
        List<Expenses> expensesList = expensesService.getExpensesListByExpenseNumber(expensesNumber);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }

    @GetMapping("/getExpensesListByExpensesNumberBetween")
    public List<ExpensesDTO> getExpensesListByExpensesNumberBetween(@RequestParam Integer expensesNumberMin, @RequestParam Integer expensesNumberMax) {
        List<Expenses> expensesList = expensesService.getExpensesListByExpenseNumberBetween(expensesNumberMin, expensesNumberMax);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }

    @GetMapping("/getExpensesListByCheckedNumber")
    public List<ExpensesDTO> getExpensesByCheckedNumber(@RequestParam Integer checkedNumber) {
        List<Expenses> expensesList = expensesService.getExpensesListByCheckedNumber(checkedNumber);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }

    @GetMapping("/getExpensesListByCheckedNumberBetween")
    public List<ExpensesDTO> getExpensesListByCheckedNumberBetween(@RequestParam Integer checkedNumberMin, @RequestParam Integer checkedNumberMax) {
        List<Expenses> expensesList = expensesService.getExpensesListByCheckedNumberBetween(checkedNumberMin, checkedNumberMax);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }

    @GetMapping("/getExpensesListByCheckedPrice")
    public List<ExpensesDTO> getExpensesListByCheckedPrice(@RequestParam Double checkedPrice) {
        List<Expenses> expensesList = expensesService.getExpensesListByCheckedPrice(checkedPrice);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }

    @GetMapping("/getExpensesListByCheckedPriceBetween")
    public List<ExpensesDTO> getExpensesListByCheckedPriceBetween(@RequestParam Double checkedPriceMin, @RequestParam Double checkedPriceMax) {
        List<Expenses> expensesList = expensesService.getExpensesListByCheckedPriceBetween(checkedPriceMin, checkedPriceMax);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }


    @GetMapping("/getExpensesListByTotalPrice")
    public List<ExpensesDTO> getExpensesListByTotalPrice(@RequestParam Double totalPriceBetween) {
        List<Expenses> expensesList = expensesService.getExpensesListByTotalPrice(totalPriceBetween);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }

    @GetMapping("/getExpensesListByTotalPriceBetween")
    public List<ExpensesDTO> getExpensesListByTotalPriceBetween(@RequestParam Double totalPriceMin, @RequestParam Double totalPriceMax) {
        List<Expenses> expensesList = expensesService.getExpensesListByTotalPriceBetween(totalPriceMin, totalPriceMax);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }

    @GetMapping("/getExpensesListByEstimatedTotalPrice")
    public List<ExpensesDTO> getExpensesListByEstimatedTotalPrice(@RequestParam Double EstimatedTotalPriceBetween) {
        List<Expenses> expensesList = expensesService.getExpensesListByEstimatedTotalPrice(EstimatedTotalPriceBetween);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }

    @GetMapping("/getExpensesListByEstimatedTotalPriceBetween")
    public List<ExpensesDTO> getExpensesListByEstimatedTotalPriceBetween(@RequestParam Double EstimatedTotalPriceMin, @RequestParam Double EstimatedTotalPriceMax) {
        List<Expenses> expensesList = expensesService.getExpensesListByEstimatedTotalPriceBetween(EstimatedTotalPriceMin, EstimatedTotalPriceMax);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }

    @GetMapping("/getExpensesListByPayedDate")
    public List<ExpensesDTO> getExpensesListByPayedDate(@RequestParam String payedDate) {
        List<Expenses> expensesList = expensesService.getExpensesListByPayedDate(payedDate);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
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


    @GetMapping("/getExpensesListByPersonId")
    public List<ExpensesDTO> getExpensesListByPersonId(@RequestParam Long personId) {
        List<Expenses> expensesList = expensesService.getExpensesListByPersonId(personId);
        return expensesDTOMapper.expensesListToExpensesDTOList(expensesList);
    }

    @GetMapping("/getExpensesListByShopId")
    public List<ExpensesDTO> getExpensesListByShopId(@RequestParam Long shopId) {
        List<Expenses> expensesList = expensesService.getExpensesListByShopId(shopId);
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


    //--- Other


}
