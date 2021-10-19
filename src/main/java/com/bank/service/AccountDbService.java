package com.bank.service;

import com.bank.domain.Account;
import com.bank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountDbService {

    private final AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }

    /*public Account getAccountById(Long accountId) throws AccountNotFoundException {
        return accountRepository.findById(accountId).orElseThrow(() ->
                new AccountNotFoundException("Account with id: " + accountId + "doesn't exsist"));
    }*/

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account saveAccount(final Account account) {
        return accountRepository.save(account);
    }

    public void deleteAccountById(Long accountId) {
        accountRepository.deleteById(accountId);
    }

   public Optional<Account> getBalanceByAccountId(Long account) {
        return accountRepository.findById(account);
    }

    // Dodac metode, ktora pobierze kursy i przeliczy //

}
