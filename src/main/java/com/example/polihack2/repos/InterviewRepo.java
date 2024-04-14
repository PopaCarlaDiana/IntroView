package com.example.polihack2.repos;

import com.example.polihack2.model.Interview;
import com.example.polihack2.model.Interviewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewRepo extends JpaRepository<Interview, Long> {
    @Query(value = "SELECT * FROM interview WHERE client_id = ?", nativeQuery = true)
    List<Interview> findByClientId(long clientId);
}
