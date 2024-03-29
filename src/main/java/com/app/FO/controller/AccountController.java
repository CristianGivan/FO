package com.app.FO.controller;

import com.app.FO.mapper.dto.account.AccountDTO;
import com.app.FO.mapper.dto.general.TextDTO;
import com.app.FO.mapper.mappers.AccountDTOMapper;
import com.app.FO.model.account.Account;
import com.app.FO.service.account.AccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {
    private AccountService accountService;

    private AccountDTOMapper accountDTOMapper;

    @Autowired
    public AccountController(AccountService accountService, AccountDTOMapper accountDTOMapper) {
        this.accountService = accountService;
        this.accountDTOMapper = accountDTOMapper;
    }

    //-- PostMapping

    @PostMapping("/postNewAccount")
    public AccountDTO postNewAccount(@RequestBody TextDTO noteText) {
        Account account = accountService.postAccount(noteText.getText());
        return accountDTOMapper.accountToAccountDTO(account);
    }


    //-- PutMapping
    @PutMapping("/putSubjectToAccount")
    public AccountDTO putSubjectToAccount(@RequestParam Long accountId, @RequestParam String subject) {
        Account account = accountService.putSubjectToAccount(accountId, subject);
        return accountDTOMapper.accountToAccountDTO(account);
    }

    @PutMapping("/putTypeToAccount")
    public AccountDTO putTypeToAccount(@RequestParam Long accountId, @RequestParam String type) {
        Account account = accountService.putTypeToAccount(accountId, type);
        return accountDTOMapper.accountToAccountDTO(account);
    }

//    @PutMapping("/putCreatedDateToAccount")
//    @ApiOperation(value = "Formatter yyyy-MM-dd HH:mm:ss 2023.06.01 13:14:15")
//    public AccountDTO putCreatedDateToAccount(@RequestParam Long accountId, @RequestParam String createdData) {
//        Account account = accountService.putCreatedDateToAccount(accountId, createdData);
//        return accountDTOMapper.accountToAccountDTO(account);
//    }

    @PutMapping("/putUserToAccount")
    public AccountDTO putUserToAccount(@RequestParam Long accountId, @RequestParam Long userId) {
        Account account = accountService.putUserToAccount(accountId, userId);
        return accountDTOMapper.accountToAccountDTO(account);
    }

    @PutMapping("/putTagToAccount")
    public AccountDTO putTagToAccount(@RequestParam Long accountId, @RequestParam Long tagId) {
        Account account = accountService.putTagToAccount(accountId, tagId);
        return accountDTOMapper.accountToAccountDTO(account);
    }


    @PutMapping("/putReminderToAccount")
    public AccountDTO putReminderToAccount(@RequestParam Long accountId, @RequestParam Long reminderId) {
        Account account = accountService.putReminderToAccount(accountId, reminderId);
        return accountDTOMapper.accountToAccountDTO(account);
    }

    @PutMapping("/putTopicToAccount")
    public AccountDTO putTopicToAccount(@RequestParam Long accountId, @RequestParam Long topicId) {
        Account account = accountService.putTopicToAccount(accountId, topicId);
        return accountDTOMapper.accountToAccountDTO(account);
    }

    @PutMapping("/putTasksToAccount")
    public AccountDTO putTasksToAccount(@RequestParam Long accountId, @RequestParam Long tasksId) {
        Account account = accountService.putTasksToAccount(accountId, tasksId);
        return accountDTOMapper.accountToAccountDTO(account);
    }
//
//    @PutMapping("/putExpensesToAccount")
//    public AccountDTO putExpensesToAccount(@RequestParam Long accountId, @RequestParam Long expensesId) {
//        Account account = accountService.putExpensesToAccount(accountId, expensesId);
//        return accountDTOMapper.accountToAccountDTO(account);
//    }

//    @PutMapping("/putTransactionToAccount")
//    public AccountDTO putTransactionToAccount(@RequestParam Long accountId, @RequestParam Long transactionId) {
//        Account account = accountService.putTransactionToAccount(accountId, transactionId);
//        return accountDTOMapper.accountToAccountDTO(account);
//    }


    //-- DeleteMapping


    @DeleteMapping("/deleteUserFromAccount")
    public AccountDTO deleteRoleFromAccount(@RequestParam Long accountId, @RequestParam Long userId) {
        Account account = accountService.deleteUserFromAccount(accountId, userId);
        return accountDTOMapper.accountToAccountDTO(account);
    }

    @DeleteMapping("/deleteTagFromAccount")
    public AccountDTO deleteTagFromAccount(@RequestParam Long accountId, @RequestParam Long tagId) {
        Account account = accountService.deleteTagFromAccount(accountId, tagId);
        return accountDTOMapper.accountToAccountDTO(account);
    }

    @DeleteMapping("/deleteReminderFromAccount")
    public AccountDTO deleteReminderFromAccount(@RequestParam Long accountId, @RequestParam Long reminderId) {
        Account account = accountService.deleteReminderFromAccount(accountId, reminderId);
        return accountDTOMapper.accountToAccountDTO(account);
    }


    @DeleteMapping("/deleteTopicFromAccount")
    public AccountDTO deleteTopicFromAccount(@RequestParam Long accountId, @RequestParam Long topicId) {
        Account account = accountService.deleteTopicFromAccount(accountId, topicId);
        return accountDTOMapper.accountToAccountDTO(account);
    }

    @DeleteMapping("/deleteTasksFromAccount")
    public AccountDTO deleteTasksFromAccount(@RequestParam Long accountId, @RequestParam Long tasksId) {
        Account account = accountService.deleteTasksFromAccount(accountId, tasksId);
        return accountDTOMapper.accountToAccountDTO(account);
    }

//
//    @DeleteMapping("/deleteExpensesFromAccount")
//    public AccountDTO deleteExpensesFromAccount(@RequestParam Long accountId, @RequestParam Long tasksId) {
//        Account account = accountService.deleteExpensesFromAccount(accountId, tasksId);
//        return accountDTOMapper.accountToAccountDTO(account);
//    }
//
//
//    @DeleteMapping("/deleteTransactionFromAccount")
//    public AccountDTO deleteTransactionFromAccount(@RequestParam Long accountId, @RequestParam Long tasksId) {
//        Account account = accountService.deleteTransactionFromAccount(accountId, tasksId);
//        return accountDTOMapper.accountToAccountDTO(account);
//    }


    @DeleteMapping("/deleteAccount")
    public List<AccountDTO> deleteAccount(@RequestParam Long accountId) {
        List<Account> accountList = accountService.deleteAccount(accountId);
        return accountDTOMapper.accountListToAccountDTOList(accountList);
    }


    //---GetMapping

    @GetMapping("/getAllAccount")
    public List<AccountDTO> getAllAccount() {
        List<Account> accountList = accountService.getAllAccount();
        return accountDTOMapper.accountListToAccountDTOList(accountList);
    }


    @GetMapping("/getAccountById")
    public AccountDTO getAccountById(@RequestParam Long accountId) {
        Account account = accountService.getAccountByAccountId(accountId);
        return accountDTOMapper.accountToAccountDTO(account);
    }

    @GetMapping("/getAccountBySubject")
    public AccountDTO getAccountBySubject(@RequestParam String subject) {
        Account account = accountService.getAccountBySubject(subject);
        return accountDTOMapper.accountToAccountDTO(account);
    }

    @GetMapping("/getAccountListBySubjectContains")
    public List<AccountDTO> getAccountListBySubjectContains(@RequestParam String subjectContain) {
        List<Account> accountList = accountService.getAccountListBySubjectContains(subjectContain);
        return accountDTOMapper.accountListToAccountDTOList(accountList);
    }

    @GetMapping("/getAccountByType")
    public AccountDTO getAccountByType(@RequestParam String type) {
        Account account = accountService.getAccountByType(type);
        return accountDTOMapper.accountToAccountDTO(account);
    }

    @GetMapping("/getAccountByTypeContains")
    public List<AccountDTO> getAccountByTypeContains(@RequestParam String typeContain) {
        List<Account> accountList = accountService.getAccountByTypeContains(typeContain);
        return accountDTOMapper.accountListToAccountDTOList(accountList);
    }

    @GetMapping("/getAccountByBalance")
    public AccountDTO getAccountByBalance(@RequestParam Double balance) {
        Account account = accountService.getAccountByBalance(balance);
        return accountDTOMapper.accountToAccountDTO(account);
    }

    @GetMapping("/getAccountByBalanceBetween")
    public List<AccountDTO> getAccountByBalanceBetween(@RequestParam Double rangeMin, @RequestParam Double rangeMax) {
        List<Account> accountList = accountService.getAccountByBalanceBetween(rangeMin, rangeMax);
        return accountDTOMapper.accountListToAccountDTOList(accountList);
    }


    @GetMapping("/getAccountByCreatedDate")
    @ApiOperation(value = "Formatter    yyyy-MM-dd HH:mm:ss 2023.06.01 13:14:15")
    public AccountDTO getAccountByCreatedDate(@RequestParam String createdDate) {
        Account account = accountService.getAccountByCreatedDate(createdDate);
        return accountDTOMapper.accountToAccountDTO(account);
    }

    @GetMapping("/getAccountListByCreatedDateBetween")
    public List<AccountDTO> getAccountListByCreatedDateBetween(@RequestParam String createdDateMin, @RequestParam String createdDateMax) {
        List<Account> accountList = accountService.getAccountListByCreatedDateBetween(createdDateMin, createdDateMax);
        return accountDTOMapper.accountListToAccountDTOList(accountList);
    }


    @GetMapping("/getAccountListByUserId")
    public List<AccountDTO> getAccountListByUserId(@RequestParam Long userId) {
        List<Account> accountList = accountService.getAccountListByUserId(userId);
        return accountDTOMapper.accountListToAccountDTOList(accountList);
    }

    @GetMapping("/getAccountListByTagId")
    public List<AccountDTO> getAccountListByTagId(@RequestParam Long tagId) {
        List<Account> accountList = accountService.getAccountListByTagId(tagId);
        return accountDTOMapper.accountListToAccountDTOList(accountList);
    }

    @GetMapping("/getAccountListByReminderId")
    public List<AccountDTO> getAccountListByReminderId(@RequestParam Long reminderId) {
        List<Account> accountList = accountService.getAccountListByReminderId(reminderId);
        return accountDTOMapper.accountListToAccountDTOList(accountList);
    }

    @GetMapping("/getAccountListByTopicId")
    public List<AccountDTO> getAccountListByTopicId(@RequestParam Long topicId) {
        List<Account> accountList = accountService.getAccountListByTopicId(topicId);
        return accountDTOMapper.accountListToAccountDTOList(accountList);
    }

    @GetMapping("/getAccountListByTasksId")
    public List<AccountDTO> getAccountListByTasksId(@RequestParam Long tasksId) {
        List<Account> accountList = accountService.getAccountListByTasksId(tasksId);
        return accountDTOMapper.accountListToAccountDTOList(accountList);
    }

    @GetMapping("/getAccountListByExpenses")
    public List<AccountDTO> getAccountListByExpenses(@RequestParam Long expensesId) {
        List<Account> accountList = accountService.getAccountListByExpenses(expensesId);
        return accountDTOMapper.accountListToAccountDTOList(accountList);
    }

    @GetMapping("/getAccountListByTransaction")
    public List<AccountDTO> getAccountListByTransaction(@RequestParam Long transactionId) {
        List<Account> accountList = accountService.getAccountListByTransaction(transactionId);
        return accountDTOMapper.accountListToAccountDTOList(accountList);
    }


    //--- Other


}
