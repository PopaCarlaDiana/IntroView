package com.example.polihack2.security.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class QuizAnswerDto {

    private Long questionId;
    private List<Long> answerIds;

}
