package br.com.gusmaomatheus.vuttr.dtos.auth.register;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRegisterResponse {
    private HttpStatus status;
    private String message;
}

