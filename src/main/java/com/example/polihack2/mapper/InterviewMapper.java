package com.example.polihack2.mapper;

import com.example.polihack2.model.Interview;
import com.example.polihack2.security.dto.InterviewDto;

import java.util.List;

public interface InterviewMapper {
     InterviewDto entityToDTO(Interview interview);
     Interview dtoToEntity(InterviewDto interviewDto);
     List<InterviewDto> entitiesToDto(List<Interview> interviewList);
}
