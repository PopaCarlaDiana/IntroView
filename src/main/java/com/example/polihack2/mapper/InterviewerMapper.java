package com.example.polihack2.mapper;

import com.example.polihack2.model.Interview;
import com.example.polihack2.model.Interviewer;
import com.example.polihack2.security.dto.InterviewDto;
import com.example.polihack2.security.dto.InterviewerDto;

import java.util.List;

public interface InterviewerMapper {
    Interviewer dtoToEntity(InterviewerDto interviewerDto);
    InterviewerDto entityToDto(Interviewer interviewer);
    List<InterviewerDto> entitiesToDtos(List<Interviewer> interviewers);
}
