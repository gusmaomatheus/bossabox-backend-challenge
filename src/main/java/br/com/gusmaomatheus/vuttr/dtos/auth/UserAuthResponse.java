package br.com.gusmaomatheus.vuttr.dtos.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserAuthResponse {
    private HttpStatus status;
    private String message;
}
