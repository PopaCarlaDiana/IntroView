package com.example.polihack2.mapper;

import com.example.polihack2.model.Score;
import com.example.polihack2.security.dto.QuizDto;
import com.example.polihack2.security.dto.ScoreDto;
import org.springframework.stereotype.Component;

@Component
public class ScoreMapperImpl implements ScoreMapper{
    @Override
    public ScoreDto entityToDto(Score score) {
        return ScoreDto.builder()
                .quiz(score.getQuiz())
                .score(score.getScore())
                .build();
    }

    @Override
    public Score dtoToEntity(ScoreDto scoreDto) {
        return Score.builder()
                .quiz(scoreDto.getQuiz())
                .score(scoreDto.getScore())
                .build();
    }
}
