package com.app.FO.controller;

import com.app.FO.mapper.dto.general.TextDTO;
import com.app.FO.mapper.dto.transaction.TransactionDTO;
import com.app.FO.mapper.mappers.TransactionDTOMapper;
import com.app.FO.model.transaction.Transaction;
import com.app.FO.service.transaction.TransactionService;
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
    public TransactionDTO postNewTransaction(@RequestBody TextDTO noteText) {
        Transaction transaction = transactionService.postTransaction(noteText.getText());
        return transactionDTOMapper.transactionToTransactionDTO(transaction);
    }


    //-- PutMapping
    @PutMapping("/putSubjectToTransaction")
    public TransactionDTO putSubjectToTransaction(@RequestParam Long transactionId, @RequestParam String subject) {
        Transaction transaction = transactionService.putSubjectToTransaction(transactionId, subject);
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

    @GetMapping("/getTransactionById")
    public TransactionDTO getTransactionById(@RequestParam Long transactionId) {
        Transaction transaction = transactionService.getTransactionByTransactionId(transactionId);
        return transactionDTOMapper.transactionToTransactionDTO(transaction);
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


    //--- Other


}
