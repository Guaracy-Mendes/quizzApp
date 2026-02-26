package com.dgw.quizzapp.backend.validator;

import com.dgw.quizzapp.backend.model.entity.QuizEntity;
import com.dgw.quizzapp.backend.model.request.QuizApiRequest;

public interface IQuizValidator {

    QuizEntity validateId(String id);

    QuizEntity validate(QuizApiRequest request);

}
