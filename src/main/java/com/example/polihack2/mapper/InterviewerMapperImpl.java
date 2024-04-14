package com.example.polihack2.mapper;

import com.example.polihack2.model.Interview;
import com.example.polihack2.model.Interviewer;
import com.example.polihack2.security.dto.InterviewDto;
import com.example.polihack2.security.dto.InterviewerDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InterviewerMapperImpl implements InterviewerMapper{

    @Override
    public Interviewer dtoToEntity(InterviewerDto interviewerDto) {
        return Interviewer.builder()
                .user(interviewerDto.getUser())
                .domain(interviewerDto.getDomain())
                .interviewList(interviewerDto.getInterviewList())
                .build();
    }

    @Override
    public InterviewerDto entityToDto(Interviewer interviewer) {
        return InterviewerDto.builder()
                .user(interviewer.getUser())
                .domain(interviewer.getDomain())
                .interviewList(interviewer.getInterviewList())
                .build();
    }

    @Override
    public List<InterviewerDto> entitiesToDtos(List<Interviewer> interviewers) {
        List<InterviewerDto> interviewerDtos = new ArrayList<>();
        for(Interviewer interviewer : interviewers){
            interviewerDtos.add(entityToDto(interviewer));
        }
        return interviewerDtos;
    }
}
