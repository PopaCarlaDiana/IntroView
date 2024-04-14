package com.example.polihack2.mapper;

import com.example.polihack2.model.Answer;
import com.example.polihack2.model.Question;
import com.example.polihack2.security.dto.AnswerDto;
import com.example.polihack2.security.dto.QuestionDto;

public interface QuestionMapper {

    QuestionDto entityToDto(Question question);
    Question dtoToEntity(QuestionDto questionDto);

}
