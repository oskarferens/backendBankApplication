package com.bank.service;

import com.bank.repository.StatisticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OperationStatService {

    private final StatisticRepository statisticRepository;

    public Long getOperations() {
        return statisticRepository.findAllByOperationStat(1L)
                .stream()
                .count();
    }
}
