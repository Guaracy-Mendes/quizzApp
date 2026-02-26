package com.dgw.quizzapp.backend.validator;

import com.dgw.quizzapp.backend.model.entity.QuizEntity;
import com.dgw.quizzapp.backend.model.entity.QuizQuestionEntity;
import com.dgw.quizzapp.backend.model.request.QuizQuestionApiRequest;

public interface IQuizQuestionValidator {

    QuizQuestionEntity validate(QuizQuestionApiRequest request, QuizEntity quiz);

}
