package com.example.polihack2.mapper;

import com.example.polihack2.model.Answer;
import com.example.polihack2.model.Client;
import com.example.polihack2.model.Question;
import com.example.polihack2.security.dto.ClientDto;
import com.example.polihack2.security.dto.QuestionDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientMapperImpl implements ClientMapper {
    @Override
    public ClientDto entityToDto(Client client) {
        return ClientDto.builder()
                .user(client.getUser())
                .scoreList(client.getScoreList())
                .interviewList(client.getInterviewList())
                .build();
    }

    @Override
    public Client dtoToEntity(ClientDto clientDto) {
        return Client.builder()
                .user(clientDto.getUser())
                .scoreList(clientDto.getScoreList())
                .interviewList(clientDto.getInterviewList())
                .build();
    }
}
