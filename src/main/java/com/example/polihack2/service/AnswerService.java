package com.example.polihack2.service;

import com.example.polihack2.mapper.AnswerMapper;
import com.example.polihack2.mapper.AnswerMapperImpl;
import com.example.polihack2.model.Answer;
import com.example.polihack2.repos.AnswerRepo;
import com.example.polihack2.security.dto.AnswerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepo answerRepo;

    private final AnswerMapperImpl answerMapper;

    public AnswerDto addAnswer(AnswerDto answer){
        return answerMapper.entityToDto(answerRepo.save(answerMapper.dtoToEntity(answer)));
    }

}
