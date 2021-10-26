package com.bank.service;

import com.bank.domain.Account;
import com.bank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountDbService {

    private final AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account findAccountByAccountId(Long accountId) {
        return accountRepository.findAccountByAccountId(accountId);
    }

    public Account getBalance(BigDecimal balance) {
        return accountRepository.findByBalance(balance);
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
