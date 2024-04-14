package com.example.polihack2.mapper;

import com.example.polihack2.model.Answer;
import com.example.polihack2.model.Client;
import com.example.polihack2.security.dto.AnswerDto;
import com.example.polihack2.security.dto.ClientDto;

public interface ClientMapper {

    ClientDto entityToDto(Client client);
    Client dtoToEntity(ClientDto clientDto);

}
