package br.com.gusmaomatheus.vuttr.controllers;

import br.com.gusmaomatheus.vuttr.dtos.auth.login.UserLoginRequest;
import br.com.gusmaomatheus.vuttr.dtos.auth.register.UserRegisterRequest;
import br.com.gusmaomatheus.vuttr.dtos.auth.login.UserLoginResponse;
import br.com.gusmaomatheus.vuttr.dtos.auth.register.UserRegisterResponse;
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
    public ResponseEntity<UserRegisterResponse> register(@RequestBody @Valid UserRegisterRequest request) {
        service.register(request);

        UserRegisterResponse response = new UserRegisterResponse(HttpStatus.CREATED, String.format("Successful registering user '%s'!",  request.username()));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody @Valid UserLoginRequest request) throws Exception {
        String token = service.login(request);

        UserLoginResponse response = new UserLoginResponse(HttpStatus.OK, String.format("Successful logging in to user '%s'", request.username()), token);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
