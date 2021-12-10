package com.bank.facade;

import com.bank.domain.Account;
import com.bank.service.AccountDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AccountFacade {

    private final AccountDbService accountDbService;

    public List<Account> getAllAccounts() {
        return accountDbService.getAllAccounts();
    }

    public Account getAccountById(Long accountId) {
        return accountDbService.getAccountById(accountId);
    }

    public BigDecimal showBalance(Long accountId) {
        return accountDbService.getBalance(accountId);
    }

    public Account createAccount(Account account) {
        return accountDbService.saveAccount(account);
    }

    public void editAccount(Account account) {
        accountDbService.saveAccount(account);
    }

    public void deleteAccountById(Long accountId) {
        accountDbService.deleteAccountById(accountId);
    }



}
