package com.example.polihack2.security.dto;


import com.example.polihack2.model.Answer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class QuestionDto {

    private String description;
    private List<Answer> answerList;
    private List<Answer> correctAnswerList;
    private String feedback;

}
