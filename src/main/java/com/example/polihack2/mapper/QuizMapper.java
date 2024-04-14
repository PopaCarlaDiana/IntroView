package com.example.polihack2.mapper;

import com.example.polihack2.model.Question;
import com.example.polihack2.model.Quiz;
import com.example.polihack2.security.dto.QuestionDto;
import com.example.polihack2.security.dto.QuizDto;

import java.util.Optional;

public interface QuizMapper {

    QuizDto entityToDto(Quiz quiz);
    Quiz dtoToEntity(QuizDto quizDto);
    QuizDto entityToDto(Optional<Quiz> byId);
}
