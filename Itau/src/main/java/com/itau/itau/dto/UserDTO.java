package com.itau.itau.dto;

import com.itau.itau.domain.user.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record UserDTO(@NotBlank(message = "Nome nao pode ser branco") String firstName,@NotBlank(message = "Nome nao pode ser branco") String lastName, @NotBlank(message = "Documento nao pode ser branco") String document, BigDecimal balance, @Email(message = "formato invalido de email") String email, String password, UserType userType) {
}
