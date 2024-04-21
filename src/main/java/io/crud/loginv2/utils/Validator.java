package io.crud.loginv2.utils;

import org.springframework.stereotype.Component;

@Component
public class Validator {

    private static final String PASSWORD_PATTERN =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,32}$";
    private static final String EMAIL_PATTER =
            "^[a-zA-Z0-9]+([._]?[a-zA-Z0-9]+)*@[a-zA-Z0-9]+([.-]?[a-zA-Z0-9]+)*\\.[a-zA-Z]{2,4}$";


    public boolean isValidEmail(String email) {
        String regex = EMAIL_PATTER;
        return email.matches(regex);
    }

    public boolean isValidPassword(String password) {
        return password.matches(PASSWORD_PATTERN);
    }
}
