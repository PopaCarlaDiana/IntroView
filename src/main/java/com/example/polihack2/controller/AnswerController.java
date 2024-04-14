package com.example.polihack2.controller;

import com.example.polihack2.model.Answer;
import com.example.polihack2.security.dto.AnswerDto;
import com.example.polihack2.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.polihack2.UrlMapping.ANSWER;
import static com.example.polihack2.UrlMapping.CREATE_ANSWER;

@RequiredArgsConstructor
@RestController(ANSWER)
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping(CREATE_ANSWER)
    public ResponseEntity<AnswerDto> createAnswer(@RequestBody AnswerDto answerDto){
        return ResponseEntity.ok(answerService.addAnswer(answerDto));
    }


}
