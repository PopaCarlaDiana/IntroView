package com.example.polihack2.service;

import com.example.polihack2.mapper.InterviewMapper;
import com.example.polihack2.mapper.InterviewMapperImpl;
import com.example.polihack2.model.Interview;
import com.example.polihack2.model.User;
import com.example.polihack2.repos.ClientRepo;
import com.example.polihack2.repos.InterviewRepo;
import com.example.polihack2.repos.InterviewerRepo;
import com.example.polihack2.security.dto.InterviewDto;
import com.example.polihack2.security.dto.QuizDto;
import com.example.polihack2.user.UserRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InterviewService {
    private final InterviewMapperImpl interviewMapper;
    private final InterviewRepo interviewRepo;
    private final InterviewerRepo interviewerRepo;
    private final ClientRepo clientRepo;
    private final UserRepository userRepository;

    public InterviewDto addInterview(InterviewDto interviewDto){
        Interview interview = Interview.builder()
                .interviewer(interviewerRepo.findById(interviewDto.getInterviewer().getId()).get())
                .client(clientRepo.findById(interviewDto.getClient().getId()).get())
                .description(interviewDto.getDescription())
                .date(interviewDto.getDate())
                .build();
        return interviewMapper.entityToDTO(interviewRepo.save(interview));
    }

    public List<InterviewDto> findByClientId(long clientId){
        return interviewMapper.entitiesToDto(interviewRepo.findByClientId(clientId));
    }

    public List<InterviewDto> getAll() {
        return interviewMapper.entitiesToDto(interviewRepo.findAll());
    }

    public List<InterviewDto> getInterviewById(Integer id) {
        return interviewMapper.entitiesToDto(interviewRepo.findByClientId(Long.valueOf(id)));
    }
}
