package com.dgw.quizzapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dgw.quizzapp.backend.model.entity.QuizEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IQuizRepository extends JpaRepository<QuizEntity, UUID> {

    Optional<QuizEntity> findByTitle(String title);

    void deleteByTitle(String title);

}
