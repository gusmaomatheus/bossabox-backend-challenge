package br.com.gusmaomatheus.vuttr.exceptions.customs.auth;

public class UserUsernameNotFoundException extends RuntimeException {

    public UserUsernameNotFoundException(String message) {
        super(message);
    }
}
