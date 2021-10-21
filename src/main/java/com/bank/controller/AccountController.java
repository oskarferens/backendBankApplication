package com.bank.controller;

import com.bank.dto.AccountDto;
import com.bank.mapper.AccountMapper;
import com.bank.service.AccountDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountDbService accountDbService;
    private final AccountMapper accountMapper;

    @GetMapping("getAllAccounts")
    public List<AccountDto> getAllAccounts() {
        return accountMapper.mapToAccountDtoList(
                accountDbService.getAllAccounts()
        );
    }

    @GetMapping("getAccountById")
    public AccountDto findAccountByAccountId(@RequestParam AccountDto accountDto) {
        return accountMapper.mapToAccountDto(accountDbService.findAccountByAccountId(accountDto.getAccountId()));
    }

    @PostMapping("createAccount")
    public void createAccount(@RequestBody AccountDto accountDto) {
        accountDbService.createAccount(
                accountMapper.mapToAccount(accountDto)
        );
    }

    @PutMapping("updateAccount")
    public AccountDto updateAccount(@RequestBody AccountDto accountDto) {
        return accountMapper.mapToAccountDto(accountDbService.saveAccount(accountMapper.mapToAccount(accountDto))
        );
    }

    @DeleteMapping("deleteAccount")
    public void deleteAccount(@RequestParam Long accountId) {
        accountDbService.deleteAccountById(accountId);
    }

}
