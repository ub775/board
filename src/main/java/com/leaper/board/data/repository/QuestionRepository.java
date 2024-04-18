package com.leaper.board.data.repository;

import com.leaper.board.data.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String content);
}
