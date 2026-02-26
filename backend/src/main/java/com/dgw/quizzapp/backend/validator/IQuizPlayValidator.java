package com.dgw.quizzapp.backend.validator;

import com.dgw.quizzapp.backend.model.entity.QuizPlayEntity;
import com.dgw.quizzapp.backend.model.request.QuizPlayApiRequest;


public interface IQuizPlayValidator {

    QuizPlayEntity validate(QuizPlayApiRequest request);

}
