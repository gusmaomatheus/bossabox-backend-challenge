package br.com.gusmaomatheus.vuttr.dtos.auth.login;

import jakarta.validation.constraints.NotBlank;

public record UserLoginRequest(
        @NotBlank(message = "The 'username' field is required and therefore cannot be blank.")
        String username,
        @NotBlank(message = "The 'password' field is required and therefore cannot be blank.")
        String password
) {
}
