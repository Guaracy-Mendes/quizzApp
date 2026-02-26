package com.dgw.quizzapp.backend.validator.impl;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgw.quizzapp.backend.model.entity.QuizPlayEntity;
import com.dgw.quizzapp.backend.model.request.QuizPlayApiRequest;
import com.dgw.quizzapp.backend.repository.IUserRepository;
import com.dgw.quizzapp.backend.validator.IQuizPlayValidator;

@Service
public class QuizPlayValidator implements IQuizPlayValidator {

    @Autowired
    private CommonValidator validator;
    
    @Autowired
    private QuizValidator quizValidator;

    @Autowired
    private IUserRepository userRepository;

    @Override
    public QuizPlayEntity validate(QuizPlayApiRequest request) {
        var res = new QuizPlayEntity();
        res.setUser(userRepository.findByAccessToken(request.getToken()));
        res.setQuiz(quizValidator.validateId(request.getQuizId()));
        res.setCorrectQuestionsNumber(validator.validateMandatoryInteger(request.getCorrectQuestionsNumber(), "correctQuestionsNumber"));
        res.setPlayedAt(ZonedDateTime.now());
        return res;
    }

}
