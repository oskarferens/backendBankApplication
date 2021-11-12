package com.bank.service;

import com.bank.domain.Account;
import com.bank.exception.AccountNotFoundException;
import com.bank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountDbService {

    private final AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long accountId) {
        return accountRepository.findById(accountId) .orElseThrow(() ->
                new AccountNotFoundException("Account with id: " + accountId + "doesn't exsist"));
    }

    public BigDecimal getBalance(Long accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
         return account.get().getBalance();
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account saveAccount(final Account account) {
        return accountRepository.save(account);
    }

    public void deleteAccountById(Long accountId) {
        accountRepository.deleteById(accountId);
    }
}
