package com.example.polihack2.mapper;

import com.example.polihack2.model.Answer;
import com.example.polihack2.security.dto.AnswerDto;

public interface AnswerMapper {

    AnswerDto entityToDto(Answer answer);
    Answer dtoToEntity(AnswerDto answerDto);

}
