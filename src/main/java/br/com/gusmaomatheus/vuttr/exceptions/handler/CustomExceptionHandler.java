package br.com.gusmaomatheus.vuttr.exceptions.handler;

import br.com.gusmaomatheus.vuttr.exceptions.customs.ToolNotFoundException;
import br.com.gusmaomatheus.vuttr.exceptions.response.CustomExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ToolNotFoundException.class)
    private ResponseEntity<CustomExceptionResponse> toolNotFound(ToolNotFoundException exception) {
        CustomExceptionResponse response = new CustomExceptionResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
