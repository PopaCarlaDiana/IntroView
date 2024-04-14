package com.example.polihack2.security.dto;

import com.example.polihack2.model.Question;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class QuizDto {

    private Long id;
    private List<Question> questionList;
    private String description;
    private Integer score;

}
