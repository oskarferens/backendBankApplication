package com.bank.repository;

import org.hibernate.stat.Statistics;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticRepository {

    List<Statistics> findAllByOperationStat(Long aLong);

}
