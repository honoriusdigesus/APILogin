package io.crud.loginv2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(InvalidEmailFormatException.class)
    public ResponseEntity<ErrorResponse> handleInvalidEmailFormatException(InvalidEmailFormatException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = new ErrorResponse(100, "EMAIL_FORMAT_INVALID", ex.getMessage());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(InvalidPasswordUserException.class)
    public ResponseEntity<ErrorResponse> handleInvalidPasswordUserException(InvalidPasswordUserException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = new ErrorResponse(101, "PASSWORD_WEAK", ex.getMessage());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(InvalidUserNameException.class)
    public ResponseEntity<ErrorResponse> handleInvalidUserNameException(InvalidUserNameException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = new ErrorResponse(102, "NAME_CANNOT_BE_BLANK", ex.getMessage());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = new ErrorResponse(103, "USER_NOT_FOUND", ex.getMessage());
        return ResponseEntity.status(status).body(error);
    }
}
