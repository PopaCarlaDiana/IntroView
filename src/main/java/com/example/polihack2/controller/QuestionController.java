package com.example.polihack2.controller;

import com.example.polihack2.security.dto.AnswerDto;
import com.example.polihack2.security.dto.QuestionDto;
import com.example.polihack2.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.polihack2.UrlMapping.*;


@RequiredArgsConstructor
@RestController(QUESTION)
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping(CREATE_QUESTION)
    public ResponseEntity<QuestionDto> createQuestion(@RequestBody QuestionDto questionDto){
        return ResponseEntity.ok(questionService.addQuestion(questionDto));
    }

    @GetMapping(GET_QUESTIONS)
    public ResponseEntity<List<QuestionDto>> getQuestion(){
        return ResponseEntity.ok(questionService.getQuestions());
    }


}
