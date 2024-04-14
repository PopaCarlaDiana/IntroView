package com.example.polihack2.security.dto;


import com.example.polihack2.model.Quiz;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class ScoreDto {

    private Quiz quiz;
    private Integer score;

}
