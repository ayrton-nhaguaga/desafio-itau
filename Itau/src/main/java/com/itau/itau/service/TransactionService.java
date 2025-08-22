package com.itau.itau.service;

import com.itau.itau.domain.transaction.Transaction;
import com.itau.itau.domain.user.User;
import com.itau.itau.dto.TransactionDTO;
import com.itau.itau.infra.ControllerExceptionHandler;
import com.itau.itau.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserService userService;

    public boolean authorizeTransaction(User sender, BigDecimal value)  {
        if (sender.getBalance().compareTo(value) > 0){
            return true;
        }else return false;
    }

    public Transaction createTransaction(TransactionDTO transaction) throws Exception{
        User sender = this.userService.findUserById(transaction.senderId());
        User receiver = this.userService.findUserById(transaction.receiverId());

        userService.validateTransaction(sender, transaction.value());

        boolean isAuthorized = this.authorizeTransaction(sender, transaction.value());

        if (!isAuthorized){
            throw  new Exception("Transacao nao autorizada");
        }

        Transaction newTransaction = new Transaction();
        newTransaction.setValue(transaction.value());
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setDateTime(LocalDateTime.now());

        // atualizar os saldos dos usuarios e salvar a transacao na BD
        sender.setBalance(sender.getBalance().subtract(transaction.value()));
        receiver.setBalance(receiver.getBalance().add(transaction.value()));

        this.transactionRepository.save(newTransaction);
        this.userService.saveUser(sender);
        this.userService.saveUser(receiver);

        return newTransaction;
    }

    public List<Transaction> getAllTransactions(){
        return this.transactionRepository.findAll();
    }
}
