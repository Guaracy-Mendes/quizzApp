package com.dgw.quizzapp.backend.exception;

public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException(String email, String provider) {
        super("User with email '%s' and provider '%s' not found".formatted(email, provider));
    }
}
