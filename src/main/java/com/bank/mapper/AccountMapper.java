package com.bank.mapper;

import com.bank.domain.Account;
import com.bank.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountMapper {

    public Account mapToAccount(final AccountDto accountDto) {
        return new Account(
                accountDto.getCustomerId(),
                accountDto.getAccountId(),
                accountDto.getBalance(),
                accountDto.getBitcoinBalance()
        );
    }

    public AccountDto mapToAccountDto(final Account account) {
        return new AccountDto(
                account.getCustomerId(),
                account.getAccountId(),
                account.getBalance(),
                account.getBitcoinBalance()
        );
    }

    public List<AccountDto> mapToAccountDtoList(final List<Account> accountsList) {
        return accountsList.stream()
                .map(this::mapToAccountDto)
                .collect(Collectors.toList());
    }
}
