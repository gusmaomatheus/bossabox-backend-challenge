package br.com.gusmaomatheus.vuttr.dtos.auth.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserLoginResponse {
    private HttpStatus status;
    private String message;
    private String token;
}
