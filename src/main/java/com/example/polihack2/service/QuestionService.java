package com.example.polihack2.service;


import com.example.polihack2.mapper.AnswerMapperImpl;
import com.example.polihack2.mapper.QuestionMapperImpl;
import com.example.polihack2.model.Question;
import com.example.polihack2.repos.AnswerRepo;
import com.example.polihack2.repos.QuestionRepo;
import com.example.polihack2.security.dto.AnswerDto;
import com.example.polihack2.security.dto.QuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepo questionRepo;

    private final QuestionMapperImpl questionMapper;

    public QuestionDto addQuestion(QuestionDto questionDto){
        return questionMapper.entityToDto(questionRepo.save(questionMapper.dtoToEntity(questionDto)));
    }

    public List<QuestionDto> getQuestions() {
        List<QuestionDto> questionDtoList = new ArrayList<>();
        for(Question question: questionRepo.findAll()){
            questionDtoList.add(questionMapper.entityToDto(question));
        }
        return questionDtoList;
    }
}
