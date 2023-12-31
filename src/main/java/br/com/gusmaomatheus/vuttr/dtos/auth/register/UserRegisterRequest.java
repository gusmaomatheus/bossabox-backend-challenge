package br.com.gusmaomatheus.vuttr.dtos.auth.register;

import br.com.gusmaomatheus.vuttr.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRegisterRequest(
        @NotBlank(message = "The 'username' field is required and therefore cannot be blank.")
        @Size(min = 4, max = 20, message = "The 'username' field must be between 4 and 20 characters.")
        String username,
        @NotBlank(message = "The 'password' field is required and therefore cannot be blank.")
        @Size(min = 6, message = "The 'password' field must have at least 6 characters.")
        String password,
        UserRole role
) {
}
