package com.example.polihack2.controller;


import com.example.polihack2.security.dto.AnswerDto;
import com.example.polihack2.security.dto.InterviewDto;
import com.example.polihack2.security.dto.InterviewerDto;
import com.example.polihack2.security.dto.QuizDto;
import com.example.polihack2.service.AnswerService;
import com.example.polihack2.service.InterviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.polihack2.UrlMapping.*;

@RequiredArgsConstructor
@RestController(INTERVIEW)
public class InterviewController {
    private final InterviewService interviewService;

    @PostMapping(CREATE_INTERVIEW)
    public ResponseEntity<InterviewDto> createInterview(@RequestBody InterviewDto interviewDto){
        return ResponseEntity.ok(interviewService.addInterview(interviewDto));
    }

    @GetMapping(GET_INTERVIEW)
    public ResponseEntity<List<InterviewDto>> getInterview(){
        return ResponseEntity.ok(interviewService.getAll());
    }

    @GetMapping(GET_INTERVIEW_BY_CLIENT_ID)
    public ResponseEntity<List<InterviewDto>> getInterviewById(@PathVariable String id){
        return ResponseEntity.ok(interviewService.getInterviewById(Integer.valueOf(id)));
    }

}
