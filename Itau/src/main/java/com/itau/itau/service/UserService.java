package com.itau.itau.service;

import com.itau.itau.domain.user.User;
import com.itau.itau.dto.UserDTO;
import com.itau.itau.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserDTO data){
        User newUser = new User(data);
        this.userRepository.save(newUser);
        return newUser;
    }

    public void validateTransaction(User sender, BigDecimal amount) throws Exception{
        if (sender.getBalance().compareTo(amount) < 0){
            throw  new Exception("Saldo insuficiente");
        }
    }

    public User findUserById(String id) throws Exception{
        return this.userRepository.findByUserId(id).orElseThrow(() -> new Exception("Usuario nao encontrado"));
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public void  saveUser(User user){
        this.userRepository.save(user);
    }
}
