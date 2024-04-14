package com.example.polihack2.repos;

import com.example.polihack2.model.Question;
import com.example.polihack2.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepo extends JpaRepository<Quiz,Long> {
}
