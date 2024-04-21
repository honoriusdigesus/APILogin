package io.crud.loginv2.exception;

public class InvalidPasswordUserException extends RuntimeException{
    public InvalidPasswordUserException(String message) {
        super(message);
    }
}
