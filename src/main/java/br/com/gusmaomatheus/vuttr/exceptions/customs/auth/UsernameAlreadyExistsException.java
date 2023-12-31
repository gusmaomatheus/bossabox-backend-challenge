package br.com.gusmaomatheus.vuttr.exceptions.customs.auth;

public class UsernameAlreadyExistsException extends RuntimeException {

    public UsernameAlreadyExistsException(String message) {
        super(message);
    }
}
