package com.example.polihack2.controller;


import com.example.polihack2.security.dto.QuestionDto;
import com.example.polihack2.security.dto.QuizAnswerDto;
import com.example.polihack2.security.dto.QuizDto;
import com.example.polihack2.security.dto.ScoreDto;
import com.example.polihack2.service.QuestionService;
import com.example.polihack2.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.polihack2.UrlMapping.*;

@RequiredArgsConstructor
@RestController(QUIZ)
@CrossOrigin("*")
public class QuizController {

    private final QuizService quizService;

    @PostMapping(CREATE_QUIZ)
    public ResponseEntity<QuizDto> createQuiz(@RequestBody QuizDto quizDto){
        return ResponseEntity.ok(quizService.addQuiz(quizDto));
    }

    @GetMapping(GET_QUIZZES)
    public ResponseEntity<List<QuizDto>> getQuiz(){
        return ResponseEntity.ok(quizService.getQuizzes());
    }


    @GetMapping(GET_QUIZ_BY_ID)
    public ResponseEntity<QuizDto> getQuizById(@PathVariable String id){
        return ResponseEntity.ok(quizService.getQuizById(Integer.valueOf(id)));
    }

    @PostMapping(PROCESS_QUIZ)
    public ResponseEntity<ScoreDto> processQuiz(@RequestBody List<QuizAnswerDto> quizAnswerDtoList, @PathVariable String quizId, @PathVariable String clientId){
        return ResponseEntity.ok(quizService.processQuiz(quizAnswerDtoList,Long.valueOf(quizId),Long.valueOf(clientId)));
    }

}
