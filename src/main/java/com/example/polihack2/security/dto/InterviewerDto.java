package com.example.polihack2.security.dto;

import com.example.polihack2.model.Interview;
import com.example.polihack2.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class InterviewerDto {
    private User user;
    private String domain;
    private List<Interview> interviewList;
}
