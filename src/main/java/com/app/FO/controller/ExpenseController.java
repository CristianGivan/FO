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
    public ExpenseDTO postNewExpense(@RequestParam String subject) {
        Expense expense = expenseService.postExpense(subject);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }


    //-- PutMapping

    @PutMapping("/putCheckedToExpense")
    public ExpenseDTO putCheckedToExpense(@RequestParam Long expenseId, @RequestParam Boolean checked) {
        Expense expense = expenseService.putCheckedToExpense(expenseId, checked);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }


    @PutMapping("/putSubjectToExpense")
    public ExpenseDTO putSubjectToExpense(@RequestParam Long expenseId, @RequestParam String subject) {
        Expense expense = expenseService.putSubjectToExpense(expenseId, subject);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }


    @PutMapping("/putCategoryToExpense")
    public ExpenseDTO putCategoryToExpense(@RequestParam Long expenseId, @RequestParam String category) {
        Expense expense = expenseService.putCategoryToExpense(expenseId, category);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }

    @PutMapping("/putQuantityToExpense")
    public ExpenseDTO putQuantityToExpense(@RequestParam Long expenseId, @RequestParam Double quantity) {
        Expense expense = expenseService.putQuantityToExpense(expenseId, quantity);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }


    @PutMapping("/putUnitPriceToExpense")
    public ExpenseDTO putUnitPriceToExpense(@RequestParam Long expenseId, @RequestParam Double unitPrice) {
        Expense expense = expenseService.putUnitPriceToExpense(expenseId, unitPrice);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }


    @PutMapping("/putTotalPriceToExpense")
    public ExpenseDTO putTotalPriceToExpense(@RequestParam Long expenseId, @RequestParam Double totalPrice) {
        Expense expense = expenseService.putTotalPriceToExpense(expenseId, totalPrice);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }


    @PutMapping("/putEstimatedTotalPriceToExpense")
    public ExpenseDTO putEstimatedTotalPriceToExpense(@RequestParam Long expenseId, @RequestParam Double estimatedTotalPrice) {
        Expense expense = expenseService.putEstimatedTotalPriceToExpense(expenseId, estimatedTotalPrice);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }

    @PutMapping("/putCheckedDateToExpense")
    public ExpenseDTO putCheckedDateToExpense(@RequestParam Long expenseId, @RequestParam String checkedDate) {
        Expense expense = expenseService.putCheckedDateToExpense(expenseId, checkedDate);
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

    @PutMapping("/putProductToExpense")
    public ExpenseDTO putProductToExpense(@RequestParam Long expenseId, @RequestParam Long productId) {
        Expense expense = expenseService.putProductToExpense(expenseId, productId);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }


    @PutMapping("/putExpensesToExpense")
    public ExpenseDTO putExpensesToExpense(@RequestParam Long expenseId, @RequestParam Long expensesId) {
        Expense expense = expenseService.putExpensesToExpense(expenseId, expensesId);
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


    @DeleteMapping("/deleteProductFromExpense")
    public ExpenseDTO deleteProductFromExpense(@RequestParam Long expenseId, @RequestParam Long productId) {
        Expense expense = expenseService.deleteProductFromExpense(expenseId, productId);
        return expenseDTOMapper.expenseToExpenseDTO(expense);
    }

    @DeleteMapping("/deleteExpensesFromExpense")
    public ExpenseDTO deleteExpensesFromExpense(@RequestParam Long expenseId, @RequestParam Long expensesId) {
        Expense expense = expenseService.deleteExpensesFromExpense(expenseId, expensesId);
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

    @GetMapping("/getExpenseListByChecked")
    public List<ExpenseDTO> getExpenseListByChecked(@RequestParam Boolean checked) {
        List<Expense> expenseList = expenseService.getExpenseListByChecked(checked);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }


    @GetMapping("/getExpenseListBySubject")
    public List<ExpenseDTO> getExpenseListBySubject(@RequestParam String subject) {
        List<Expense> expenseList = expenseService.getExpenseListBySubject(subject);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }

    @GetMapping("/getExpenseListBySubjectContains")
    public List<ExpenseDTO> getExpenseListBySubjectContains(@RequestParam String subjectContain) {
        List<Expense> expenseList = expenseService.getExpenseListBySubjectContains(subjectContain);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }

    @GetMapping("/getExpenseListByCategory")
    public List<ExpenseDTO> getExpenseListByCategory(@RequestParam String category) {
        List<Expense> expenseList = expenseService.getExpenseListByCategory(category);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }

    @GetMapping("/getExpenseListByCategoryContains")
    public List<ExpenseDTO> getExpenseListByCategoryContains(@RequestParam String categoryContain) {
        List<Expense> expenseList = expenseService.getExpenseListByCategoryContains(categoryContain);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }

    @GetMapping("/getExpenseListByQuantity")
    public List<ExpenseDTO> getExpenseListByQuantity(@RequestParam Double quantity) {
        List<Expense> expenseList = expenseService.getExpenseListByQuantity(quantity);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }

    @GetMapping("/getExpenseListByQuantityBetween")
    public List<ExpenseDTO> getExpenseListByQuantityBetween(@RequestParam Double quantityMin, @RequestParam Double quantityMax) {
        List<Expense> expenseList = expenseService.getExpenseListByQuantityBetween(quantityMin, quantityMax);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }

    @GetMapping("/getExpenseListByUnitPrice")
    public List<ExpenseDTO> getExpenseListByUnitPrice(@RequestParam Double unitPrice) {
        List<Expense> expenseList = expenseService.getExpenseListByUnitPrice(unitPrice);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }

    @GetMapping("/getExpenseListByUnitPriceBetween")
    public List<ExpenseDTO> getExpenseListByUnitPriceBetween(@RequestParam Double unitPriceMin, @RequestParam Double unitPriceMax) {
        List<Expense> expenseList = expenseService.getExpenseListByUnitPriceBetween(unitPriceMin, unitPriceMax);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }

    @GetMapping("/getExpenseListByTotalPrice")
    public List<ExpenseDTO> getExpenseListByTotalPrice(@RequestParam Double totalPrice) {
        List<Expense> expenseList = expenseService.getExpenseListByTotalPrice(totalPrice);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }

    @GetMapping("/getExpenseListByTotalPriceBetween")
    public List<ExpenseDTO> getExpenseListByTotalPriceBetween(@RequestParam Double totalPriceMin, @RequestParam Double totalPriceMax) {
        List<Expense> expenseList = expenseService.getExpenseListByTotalPriceBetween(totalPriceMin, totalPriceMax);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }

    @GetMapping("/getExpenseListByEstimatedTotalPrice")
    public List<ExpenseDTO> getExpenseByListEstimatedTotalPrice(@RequestParam Double estimatedTotalPrice) {
        List<Expense> expenseList = expenseService.getExpenseListByEstimatedTotalPrice(estimatedTotalPrice);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }

    @GetMapping("/getExpenseListByEstimatedTotalPriceBetween")
    public List<ExpenseDTO> getExpenseListByEstimatedTotalPriceBetween(@RequestParam Double estimatedTotalPriceMin, @RequestParam Double estimatedTotalPriceMax) {
        List<Expense> expenseList = expenseService.getExpenseListByEstimatedTotalPriceBetween(estimatedTotalPriceMin, estimatedTotalPriceMax);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }

    @GetMapping("/getExpenseListByCheckedDate")
    public List<ExpenseDTO> getExpenseListByCheckedDate(@RequestParam String checkedDate) {
        List<Expense> expenseList = expenseService.getExpenseListByCheckedDate(checkedDate);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }

    @GetMapping("/getExpenseListByCheckedDateBetween")
    public List<ExpenseDTO> getExpenseListByCheckedDateBetween(@RequestParam String checkedDateMin, @RequestParam String checkedDateMax) {
        List<Expense> expenseList = expenseService.getExpenseListByCheckedDateBetween(checkedDateMin, checkedDateMax);
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


    @GetMapping("/getExpenseListByProductId")
    public List<ExpenseDTO> getExpenseListByProductId(@RequestParam Long productId) {
        List<Expense> expenseList = expenseService.getExpenseListByProductId(productId);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }

    @GetMapping("/getExpenseListByExpensesId")
    public List<ExpenseDTO> getExpenseListByExpensesId(@RequestParam Long expensesId) {
        List<Expense> expenseList = expenseService.getExpenseListByExpensesId(expensesId);
        return expenseDTOMapper.expenseListToExpenseDTOList(expenseList);
    }
    //--- Other


}
