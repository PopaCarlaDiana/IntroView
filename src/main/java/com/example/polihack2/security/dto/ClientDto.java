package com.example.polihack2.security.dto;


import com.example.polihack2.model.Interview;
import com.example.polihack2.model.Score;
import com.example.polihack2.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class ClientDto {

    private User user;

    private List<Score> scoreList;

    private List<Interview> interviewList;

}
