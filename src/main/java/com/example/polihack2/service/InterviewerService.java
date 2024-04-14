package com.example.polihack2.service;

import com.example.polihack2.mapper.InterviewMapperImpl;
import com.example.polihack2.mapper.InterviewerMapperImpl;
import com.example.polihack2.repos.InterviewerRepo;
import com.example.polihack2.security.dto.InterviewerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InterviewerService {
    private final InterviewerMapperImpl interviewerMapper;
    private final InterviewerRepo interviewerRepo;

    public List<InterviewerDto> getAll(){
        return interviewerMapper.entitiesToDtos(interviewerRepo.findAll());
    }
}
