package com.example.polihack2.mapper;

import com.example.polihack2.model.Quiz;
import com.example.polihack2.model.Score;
import com.example.polihack2.security.dto.QuizDto;
import com.example.polihack2.security.dto.ScoreDto;

public interface ScoreMapper {

    ScoreDto entityToDto(Score score);
    Score dtoToEntity(ScoreDto scoreDto);

}
