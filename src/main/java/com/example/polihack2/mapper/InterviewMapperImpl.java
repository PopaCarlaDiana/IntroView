package com.example.polihack2.mapper;

import com.example.polihack2.model.Interview;
import com.example.polihack2.security.dto.InterviewDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InterviewMapperImpl implements InterviewMapper{

    @Override
    public InterviewDto entityToDTO(Interview interview) {
        return InterviewDto.builder()
                .interviewer(interview.getInterviewer())
                .client(interview.getClient())
                .description(interview.getDescription())
                .date(interview.getDate())
                .build();
    }

    @Override
    public Interview dtoToEntity(InterviewDto interviewDto) {
        return Interview.builder()
                .description(interviewDto.getDescription())
                .interviewer(interviewDto.getInterviewer())
                .client(interviewDto.getClient())
                .date(interviewDto.getDate())
                .build();
    }

    @Override
    public List<InterviewDto> entitiesToDto(List<Interview> interviewList) {
        List<InterviewDto> interviewDtos = new ArrayList<>();
        for(Interview interview : interviewList){
            interviewDtos.add(entityToDTO(interview));
        }
        return interviewDtos;
    }
}
