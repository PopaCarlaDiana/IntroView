package com.example.polihack2.repos;

import com.example.polihack2.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepo extends JpaRepository<Score,Long> {

    @Query(value = "SELECT * FROM score WHERE quiz_id = ?", nativeQuery = true)
    Score findByQuizId(Long id);

}
