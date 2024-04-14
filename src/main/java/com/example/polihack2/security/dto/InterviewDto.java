package com.example.polihack2.security.dto;

import com.example.polihack2.model.Client;
import com.example.polihack2.model.Interviewer;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class InterviewDto {
    private Client client;
    private Interviewer interviewer;
    private String description;
    private Date date;
}
