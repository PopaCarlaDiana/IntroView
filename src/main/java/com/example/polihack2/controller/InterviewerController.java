package com.example.polihack2.controller;

import com.example.polihack2.security.dto.InterviewDto;
import com.example.polihack2.security.dto.InterviewerDto;
import com.example.polihack2.security.dto.QuizDto;
import com.example.polihack2.service.InterviewerService;
import com.example.polihack2.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.polihack2.UrlMapping.*;

@RequiredArgsConstructor
@RestController(INTERVIEWER)
public class InterviewerController {

    private final InterviewerService interviewerService;

    @GetMapping(GET_INTERVIEWER)
    public ResponseEntity<List<InterviewerDto>> getInterviewer(){
        return ResponseEntity.ok(interviewerService.getAll());
    }

}
