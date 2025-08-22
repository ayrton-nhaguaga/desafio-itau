package com.itau.itau.dto;

import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;


public record TransactionDTO(@Positive(message = "insira um valor positivo") BigDecimal value, String senderId, String receiverId) {
}
