package com.example.polihack2.repos;

import com.example.polihack2.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepo extends JpaRepository<Answer,Long> {
    Answer findByDescription(String description);
}
