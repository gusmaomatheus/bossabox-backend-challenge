package br.com.gusmaomatheus.vuttr.exceptions.customs;

public class TitleAlreadyExistsException extends RuntimeException {

    public TitleAlreadyExistsException(String message) {
        super(message);
    }
}
