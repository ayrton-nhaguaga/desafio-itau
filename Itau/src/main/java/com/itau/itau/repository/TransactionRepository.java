package com.itau.itau.repository;

import com.itau.itau.domain.transaction.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
    @Override
    List<Transaction> findAll();

    //List<Transaction> findBySender()
}
