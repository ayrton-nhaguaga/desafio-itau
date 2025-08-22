package com.itau.itau.repository;

import com.itau.itau.domain.statistic.Statistic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticRepository extends MongoRepository<Statistic, String> {
}
