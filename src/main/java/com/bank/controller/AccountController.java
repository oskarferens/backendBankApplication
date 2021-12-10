package com.bank.controller;

import com.bank.domain.Account;
import com.bank.dto.AccountDto;
import com.bank.facade.AccountFacade;
import com.bank.mapper.AccountMapper;
import com.bank.service.AccountDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/v1/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountFacade accountFacade;

    @GetMapping("/getAllAccounts")
    public List<Account> getAllAccounts() {
        return accountFacade.getAllAccounts();
    }

    @GetMapping("/getAccountById/{accountId}")
    public Account getAccountById(@PathVariable Long accountId) {
        return accountFacade.getAccountById(accountId);
    }

    @GetMapping("/getBalance")
    public BigDecimal getBalance(@RequestParam Long accountId) {
        return accountFacade.showBalance(accountId);
    }

    @PostMapping(value = "/createAccount", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createAccount(@RequestBody Account account) {
        accountFacade.createAccount(account);
    }

    @PutMapping("/updateAccount")
    public void updateAccount(@RequestBody Account account) {
        accountFacade.editAccount(account);
    }

    @DeleteMapping("/deleteAccount")
    public void deleteAccount(@RequestParam Long accountId) {
        accountFacade.deleteAccountById(accountId);
    }

}










