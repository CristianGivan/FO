package com.app.FO.controller;

import com.app.FO.mapper.dto.general.TextDTO;
import com.app.FO.mapper.dto.transaction.TransactionDTO;
import com.app.FO.mapper.mappers.TransactionDTOMapper;
import com.app.FO.model.transaction.Transaction;
import com.app.FO.service.transaction.TransactionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {
    private TransactionService transactionService;

    private TransactionDTOMapper transactionDTOMapper;

    @Autowired
    public TransactionController(TransactionService transactionService, TransactionDTOMapper transactionDTOMapper) {
        this.transactionService = transactionService;
        this.transactionDTOMapper = transactionDTOMapper;
    }

    //-- PostMapping

    @PostMapping("/postNewTransaction")
    public TransactionDTO postNewTransaction(@RequestParam TextDTO noteText, @RequestParam Double sum, @RequestParam Long fromAccountId, @RequestParam Long toAccountId) {
        Transaction transaction = transactionService.postTransaction(noteText.getText(), sum, fromAccountId, toAccountId);
        return transactionDTOMapper.transactionToTransactionDTO(transaction);
    }


    //-- PutMapping
    @PutMapping("/putSubjectToTransaction")
    public TransactionDTO putSubjectToTransaction(@RequestParam Long transactionId, @RequestParam String subject) {
        Transaction transaction = transactionService.putSubjectToTransaction(transactionId, subject);
        return transactionDTOMapper.transactionToTransactionDTO(transaction);
    }

    @PutMapping("/putTypeToTransaction")
    public TransactionDTO putTypeToTransaction(@RequestParam Long transactionId, @RequestParam String type) {
        Transaction transaction = transactionService.putTypeToTransaction(transactionId, type);
        return transactionDTOMapper.transactionToTransactionDTO(transaction);
    }

    @PutMapping("/putSumToTransaction")
    public TransactionDTO putSumToTransaction(@RequestParam Long transactionId, @RequestParam Double sum) {
        Transaction transaction = transactionService.putSumToTransaction(transactionId, sum);
        return transactionDTOMapper.transactionToTransactionDTO(transaction);
    }

    @PutMapping("/putPlanedDateToTransaction")
    public TransactionDTO putPlanedDateToTransaction(@RequestParam Long transactionId, @RequestParam String planedDate) {
        Transaction transaction = transactionService.putPlanedDateToTransaction(transactionId, planedDate);
        return transactionDTOMapper.transactionToTransactionDTO(transaction);
    }

    @PutMapping("/putCompletedDateToTransaction")

    public TransactionDTO putCompletedDateToTransaction(@RequestParam Long transactionId, @RequestParam String completedDate) {

        Transaction transaction = transactionService.putCompletedDateToTransaction(transactionId, completedDate);
        return transactionDTOMapper.transactionToTransactionDTO(transaction);
    }


    @PutMapping("/putTransactionStatusToTransaction")
    public TransactionDTO putTransactionStatusToTransaction(@RequestParam Long transactionId, @RequestParam String transactionStatus, @RequestParam String date) {
        Transaction transaction = transactionService.putTransactionStatusToTransaction(transactionId, transactionStatus, date);
        return transactionDTOMapper.transactionToTransactionDTO(transaction);
    }

    @PutMapping("/putUserToTransaction")
    public TransactionDTO putUserToTransaction(@RequestParam Long transactionId, @RequestParam Long userId) {
        Transaction transaction = transactionService.putUserToTransaction(transactionId, userId);
        return transactionDTOMapper.transactionToTransactionDTO(transaction);
    }

    @PutMapping("/putTagToTransaction")
    public TransactionDTO putTagToTransaction(@RequestParam Long transactionId, @RequestParam Long tagId) {
        Transaction transaction = transactionService.putTagToTransaction(transactionId, tagId);
        return transactionDTOMapper.transactionToTransactionDTO(transaction);
    }


    @PutMapping("/putReminderToTransaction")
    public TransactionDTO putReminderToTransaction(@RequestParam Long transactionId, @RequestParam Long reminderId) {
        Transaction transaction = transactionService.putReminderToTransaction(transactionId, reminderId);
        return transactionDTOMapper.transactionToTransactionDTO(transaction);
    }

    @PutMapping("/putTopicToTransaction")
    public TransactionDTO putTopicToTransaction(@RequestParam Long transactionId, @RequestParam Long topicId) {
        Transaction transaction = transactionService.putTopicToTransaction(transactionId, topicId);
        return transactionDTOMapper.transactionToTransactionDTO(transaction);
    }

    @PutMapping("/putTasksToTransaction")
    public TransactionDTO putTasksToTransaction(@RequestParam Long transactionId, @RequestParam Long tasksId) {
        Transaction transaction = transactionService.putTasksToTransaction(transactionId, tasksId);
        return transactionDTOMapper.transactionToTransactionDTO(transaction);
    }

    @PutMapping("/putAccountToTransaction")
    public TransactionDTO putAccountToTransaction(@RequestParam Long transactionId, @RequestParam Long accountId, @RequestParam String direction) {
        Transaction transaction = transactionService.putAccountToTransaction(transactionId, accountId, direction);
        return transactionDTOMapper.transactionToTransactionDTO(transaction);
    }


    //-- DeleteMapping


    @DeleteMapping("/deleteUserFromTransaction")
    public TransactionDTO deleteRoleFromTransaction(@RequestParam Long transactionId, @RequestParam Long userId) {
        Transaction transaction = transactionService.deleteUserFromTransaction(transactionId, userId);
        return transactionDTOMapper.transactionToTransactionDTO(transaction);
    }

    @DeleteMapping("/deleteTagFromTransaction")
    public TransactionDTO deleteTagFromTransaction(@RequestParam Long transactionId, @RequestParam Long tagId) {
        Transaction transaction = transactionService.deleteTagFromTransaction(transactionId, tagId);
        return transactionDTOMapper.transactionToTransactionDTO(transaction);
    }

    @DeleteMapping("/deleteReminderFromTransaction")
    public TransactionDTO deleteReminderFromTransaction(@RequestParam Long transactionId, @RequestParam Long reminderId) {
        Transaction transaction = transactionService.deleteReminderFromTransaction(transactionId, reminderId);
        return transactionDTOMapper.transactionToTransactionDTO(transaction);
    }


    @DeleteMapping("/deleteTopicFromTransaction")
    public TransactionDTO deleteTopicFromTransaction(@RequestParam Long transactionId, @RequestParam Long topicId) {
        Transaction transaction = transactionService.deleteTopicFromTransaction(transactionId, topicId);
        return transactionDTOMapper.transactionToTransactionDTO(transaction);
    }

    @DeleteMapping("/deleteTasksFromTransaction")
    public TransactionDTO deleteTasksFromTransaction(@RequestParam Long transactionId, @RequestParam Long tasksId) {
        Transaction transaction = transactionService.deleteTasksFromTransaction(transactionId, tasksId);
        return transactionDTOMapper.transactionToTransactionDTO(transaction);
    }

    @DeleteMapping("/deleteTransaction")
    public List<TransactionDTO> deleteTransaction(@RequestParam Long transactionId) {
        List<Transaction> transactionList = transactionService.deleteTransaction(transactionId);
        return transactionDTOMapper.transactionListToTransactionDTOList(transactionList);
    }


    //---GetMapping

    @GetMapping("/getAllTransaction")
    public List<TransactionDTO> getAllTransaction() {
        List<Transaction> transactionList = transactionService.getAllTransaction();
        return transactionDTOMapper.transactionListToTransactionDTOList(transactionList);
    }

    @GetMapping("/getTransactionById")
    public TransactionDTO getTransactionById(@RequestParam Long transactionId) {
        Transaction transaction = transactionService.getTransactionByTransactionId(transactionId);
        return transactionDTOMapper.transactionToTransactionDTO(transaction);
    }

    @GetMapping("/getTransactionBySubject")
    public TransactionDTO getTransactionBySubject(@RequestParam String subject) {
        Transaction transaction = transactionService.getTransactionBySubject(subject);
        return transactionDTOMapper.transactionToTransactionDTO(transaction);
    }

    @GetMapping("/getTransactionListBySubjectContains")
    public List<TransactionDTO> getTransactionListBySubjectContains(@RequestParam String subjectContain) {
        List<Transaction> transactionList = transactionService.getTransactionListBySubjectContains(subjectContain);
        return transactionDTOMapper.transactionListToTransactionDTOList(transactionList);
    }

    @GetMapping("/getTransactionByType")
    public TransactionDTO getTransactionByType(@RequestParam String type) {
        Transaction transaction = transactionService.getTransactionByType(type);
        return transactionDTOMapper.transactionToTransactionDTO(transaction);
    }

    @GetMapping("/getTransactionListByTypeContains")
    public List<TransactionDTO> getTransactionListByTypeContains(@RequestParam String typeContain) {
        List<Transaction> transactionList = transactionService.getTransactionListByTypeContains(typeContain);
        return transactionDTOMapper.transactionListToTransactionDTOList(transactionList);
    }

    @GetMapping("/getTransactionBySum")
    public TransactionDTO getTransactionBySum(@RequestParam Double sum) {
        Transaction transaction = transactionService.getTransactionBySum(sum);
        return transactionDTOMapper.transactionToTransactionDTO(transaction);
    }

    @GetMapping("/getTransactionListBySumBetween")
    public List<TransactionDTO> getTransactionListBySumBetween(@RequestParam Double sumMin, @RequestParam Double sumMax) {
        List<Transaction> transactionList = transactionService.getTransactionListBySumBetween(sumMin, sumMax);
        return transactionDTOMapper.transactionListToTransactionDTOList(transactionList);
    }

    @GetMapping("/getTransactionByCreatedDate")
    public TransactionDTO getTransactionByCreatedDate(@RequestParam String createdDate) {
        Transaction transaction = transactionService.getTransactionByCreatedDate(createdDate);
        return transactionDTOMapper.transactionToTransactionDTO(transaction);
    }

    @GetMapping("/getTransactionListByCreatedDateBetween")
    public List<TransactionDTO> getTransactionListByCreatedDateBetween(@RequestParam String createdDateMin, @RequestParam String createdDateMax) {
        List<Transaction> transactionList = transactionService.getTransactionListByCreatedDateBetween(createdDateMin, createdDateMax);
        return transactionDTOMapper.transactionListToTransactionDTOList(transactionList);
    }


    @GetMapping("/getTransactionListByPlanedDate")
    @ApiOperation(value = "Formatter    yyyy-MM-dd HH:mm:ss 2023.06.01 13:14:15")
    public List<TransactionDTO> getTransactionByPlanedDate(@RequestParam String planedDate) {
        List<Transaction> transactionList = transactionService.getTransactionByPlanedDate(planedDate);
        return transactionDTOMapper.transactionListToTransactionDTOList(transactionList);
    }

    @GetMapping("/getTransactionListByPlanedDateBetween")
    public List<TransactionDTO> getTransactionListByPlanedDateBetween(@RequestParam String planedDateMin, @RequestParam String planedDateMax) {
        List<Transaction> transactionList = transactionService.getTransactionListByPlanedDateBetween(planedDateMin, planedDateMax);
        return transactionDTOMapper.transactionListToTransactionDTOList(transactionList);
    }


    @GetMapping("/getTransactionListByCompletedDate")
    @ApiOperation(value = "Formatter    yyyy-MM-dd HH:mm:ss 2023.06.01 13:14:15")
    public List<TransactionDTO> getTransactionByCompletedDate(@RequestParam String completedDate) {
        List<Transaction> transactionList = transactionService.getTransactionByCompletedDate(completedDate);
        return transactionDTOMapper.transactionListToTransactionDTOList(transactionList);
    }

    @GetMapping("/getTransactionListByCompletedDateBetween")
    public List<TransactionDTO> getTransactionListByCompletedDateBetween(@RequestParam String completedDateMin, @RequestParam String completedDateMax) {
        List<Transaction> transactionList = transactionService.getTransactionListByCompletedDateBetween(completedDateMin, completedDateMax);
        return transactionDTOMapper.transactionListToTransactionDTOList(transactionList);
    }


    @GetMapping("/getTransactionByTransactionStatus")
    public List<TransactionDTO> getTransactionByTransactionStatus(@RequestParam String transactionStatus) {
        List<Transaction> transactionList = transactionService.getTransactionByTransactionStatus(transactionStatus);
        return transactionDTOMapper.transactionListToTransactionDTOList(transactionList);
    }

    @GetMapping("/getTransactionListByUserId")
    public List<TransactionDTO> getTransactionListByUserId(@RequestParam Long userId) {
        List<Transaction> transactionList = transactionService.getTransactionListByUserId(userId);
        return transactionDTOMapper.transactionListToTransactionDTOList(transactionList);
    }

    @GetMapping("/getTransactionListByTagId")
    public List<TransactionDTO> getTransactionListByTagId(@RequestParam Long tagId) {
        List<Transaction> transactionList = transactionService.getTransactionListByTagId(tagId);
        return transactionDTOMapper.transactionListToTransactionDTOList(transactionList);
    }

    @GetMapping("/getTransactionListByReminderId")
    public List<TransactionDTO> getTransactionListByReminderId(@RequestParam Long reminderId) {
        List<Transaction> transactionList = transactionService.getTransactionListByReminderId(reminderId);
        return transactionDTOMapper.transactionListToTransactionDTOList(transactionList);
    }

    @GetMapping("/getTransactionListByTopicId")
    public List<TransactionDTO> getTransactionListByTopicId(@RequestParam Long topicId) {
        List<Transaction> transactionList = transactionService.getTransactionListByTopicId(topicId);
        return transactionDTOMapper.transactionListToTransactionDTOList(transactionList);
    }

    @GetMapping("/getTransactionListByTasksId")
    public List<TransactionDTO> getTransactionListByTasksId(@RequestParam Long tasksId) {
        List<Transaction> transactionList = transactionService.getTransactionListByTasksId(tasksId);
        return transactionDTOMapper.transactionListToTransactionDTOList(transactionList);
    }

    @GetMapping("/getTransactionListByAccountWithDirection")
    public List<TransactionDTO> getTransactionListByAccountWithDirection(@RequestParam Long accountId, @RequestParam String direction) {
        List<Transaction> transactionList = transactionService.getTransactionListByAccountWithDirection(accountId, direction);
        return transactionDTOMapper.transactionListToTransactionDTOList(transactionList);
    }


    //--- Other


}
