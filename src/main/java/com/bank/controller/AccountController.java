package com.bank.controller;

import com.bank.domain.Account;
import com.bank.dto.AccountDto;
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

    @Autowired
    private final AccountDbService accountDbService;
    @Autowired
    private final AccountMapper accountMapper;

    @GetMapping("/getAllAccounts")
    public List<Account> getAllAccounts() {
        return accountDbService.getAllAccounts();
    }

    @GetMapping("/getAccountById/{accountId}")
    public Account getAccountById(@PathVariable Long accountId) {
        return accountDbService.getAccountById(accountId);
    }

    @GetMapping("/getBalance")
    public BigDecimal getBalance(@RequestParam Long accountId) {
        return accountDbService.getBalance(accountId);
    }

    @PostMapping(value = "/createAccount", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createAccount(@RequestBody Account account) {
        accountDbService.createAccount(account);
    }

    @PutMapping("/updateAccount")
    public AccountDto updateAccount(@RequestBody AccountDto accountDto) {
        return accountMapper.mapToAccountDto(accountDbService.saveAccount(accountMapper.mapToAccount(accountDto))
        );
    }

    @DeleteMapping("/deleteAccount")
    public void deleteAccount(@RequestParam Long accountId) {
        accountDbService.deleteAccountById(accountId);
    }

}
