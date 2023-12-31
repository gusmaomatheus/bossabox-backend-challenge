package br.com.gusmaomatheus.vuttr.exceptions.customs.auth;

public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException(String message) {
        super(message);
    }
}
