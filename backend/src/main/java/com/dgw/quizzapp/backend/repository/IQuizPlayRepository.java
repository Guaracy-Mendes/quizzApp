package com.dgw.quizzapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dgw.quizzapp.backend.model.entity.QuizPlayEntity;

@Repository
public interface IQuizPlayRepository extends JpaRepository<QuizPlayEntity, QuizPlayEntity.PrimaryKey> {

}
