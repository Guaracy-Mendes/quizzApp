package com.dgw.quizzapp.backend.exception;

public class QuizNotFoundException extends NotFoundException {

    public QuizNotFoundException(String id) {
        super("Quiz with id '%s' not found".formatted(id));
    }
}
