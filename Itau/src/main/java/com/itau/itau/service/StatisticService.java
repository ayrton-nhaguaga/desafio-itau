package com.itau.itau.service;

import com.itau.itau.domain.statistic.Statistic;
import com.itau.itau.domain.transaction.Transaction;
import com.itau.itau.dto.TransactionDTO;
import com.itau.itau.repository.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class StatisticService {

    @Autowired
    private StatisticRepository statisticRepository;

    @Autowired
    private TransactionService transactionService;

    public Map<String , Object> createStatistic() throws Exception{

        if (this.transactionService.getAllTransactions().isEmpty()){
            throw new Exception("Sem transacoes a serem analisadas");
        }

       // List<Transaction> transactions = this.transactionService
    }
}
