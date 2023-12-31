package br.com.gusmaomatheus.vuttr.controllers;

import br.com.gusmaomatheus.vuttr.dtos.auth.register.UserRegisterRequest;
import br.com.gusmaomatheus.vuttr.dtos.auth.UserAuthResponse;
import br.com.gusmaomatheus.vuttr.services.auth.AuthServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vuttr/auth")
public class AuthController {
    @Autowired
    private AuthServiceImpl service;

    @PostMapping("/register")
    public ResponseEntity<UserAuthResponse> register(@RequestBody @Valid UserRegisterRequest request) {
        service.register(request);

        UserAuthResponse response = new UserAuthResponse(HttpStatus.CREATED, String.format("Successful registering user '%s'!",  request.username()));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
