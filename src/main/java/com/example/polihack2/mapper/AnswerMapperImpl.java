package com.example.polihack2.mapper;

import com.example.polihack2.model.Answer;
import com.example.polihack2.security.dto.AnswerDto;
import org.springframework.stereotype.Component;

@Component
public class AnswerMapperImpl implements AnswerMapper{
    @Override
    public AnswerDto entityToDto(Answer answer) {
        return AnswerDto.builder().description(answer.getDescription()).build();
    }

    @Override
    public Answer dtoToEntity(AnswerDto answerDto) {
        return Answer.builder().description(answerDto.getDescription()).build();
    }
}
