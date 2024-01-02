package br.com.gusmaomatheus.vuttr.controllers;

import br.com.gusmaomatheus.vuttr.dtos.auth.login.UserLoginRequest;
import br.com.gusmaomatheus.vuttr.dtos.auth.login.UserLoginResponse;
import br.com.gusmaomatheus.vuttr.dtos.auth.register.UserRegisterRequest;
import br.com.gusmaomatheus.vuttr.dtos.auth.register.UserRegisterResponse;
import br.com.gusmaomatheus.vuttr.services.auth.AuthServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Authentication")
public class AuthController {
    @Autowired
    private AuthServiceImpl service;

    @Operation(
            summary = "An endpoint that makes an HTTP POST request in order to register a new user in the system.",
            description = "Endpoint for registering a new user in the system.",
            parameters = {
                    @Parameter(
                            name = "username",
                            description = "String with minimum size 4 and maximum size 20.",
                            required = true,
                            example = "username"
                    ),
                    @Parameter(
                            name = "password",
                            description = "String with minimum size 6.",
                            required = true,
                            example = "password"
                    ),
                    @Parameter(
                            name = "role",
                            description = "String with two possible values: ADMIN and COMMON.",
                            required = true,
                            example = "COMMON"
                    )
            },
            responses = {
                    @ApiResponse(
                            description = "Success in registering a new user in the system.",
                            responseCode = "201"
                    ),
                    @ApiResponse(
                            description = "Error when registering a new user.",
                            responseCode = "400"
                    )
            }
    )
    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> register(@RequestBody @Valid UserRegisterRequest request) {
        service.register(request);

        UserRegisterResponse response = new UserRegisterResponse(
                HttpStatus.CREATED,
                String.format("Successful registering user '%s'!", request.username())
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
            summary = "An endpoint that makes an HTTP POST request to authenticate a user on the system.",
            description = "Endpoint for a user to authenticate to the system.",
            parameters = {
                    @Parameter(
                            name = "username",
                            description = "String with minimum size 4 and maximum size 20.",
                            required = true,
                            example = "username"
                    ),
                    @Parameter(
                            name = "password",
                            description = "String with minimum size 6.",
                            required = true,
                            example = "password"
                    )
            },
            responses = {
                    @ApiResponse(
                            description = "Success in authenticating to the system.",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Error when authenticating.",
                            responseCode = "400"
                    ),
                    @ApiResponse(
                            description = "Username not found in the system.",
                            responseCode = "404"
                    ),
                    @ApiResponse(
                            description = "Incorrect password for that username.",
                            responseCode = "401"
                    )
            }
    )
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody @Valid UserLoginRequest request) throws Exception {
        String token = service.login(request);

        UserLoginResponse response = new UserLoginResponse(
                HttpStatus.OK,
                String.format("Successful logging in to user '%s'", request.username()),
                token
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
