package com.example.polihack2.repos;

import com.example.polihack2.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Long> {
    Question findByDescription(String description);
}
