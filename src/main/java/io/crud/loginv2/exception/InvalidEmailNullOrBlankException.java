package io.crud.loginv2.exception;

public class InvalidEmailNullOrBlankException extends RuntimeException{
    public InvalidEmailNullOrBlankException(String message) {
        super(message);
    }
}
