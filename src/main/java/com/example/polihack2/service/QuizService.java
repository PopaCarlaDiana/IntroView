package com.example.polihack2.service;

import com.example.polihack2.mapper.*;
import com.example.polihack2.model.*;
import com.example.polihack2.repos.*;
import com.example.polihack2.security.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class QuizService {

    private final QuizRepo quizRepo;

    private final QuizMapperImpl QuizMapper;
    private final QuestionMapperImpl questionMapper;
    private final QuestionRepo questionRepo;
    private final AnswerRepo answerRepo;
    private final ClientRepo clientRepo;
    private final ScoreRepo scoreRepo;
    private final AnswerMapperImpl answerMapper;
    private final ClientMapperImpl clientMapper;
    private final ScoreMapperImpl scoreMapper;

    public QuizDto addQuiz(QuizDto QuizDto){
        return QuizMapper.entityToDto(quizRepo.save(QuizMapper.dtoToEntity(QuizDto)));
    }

    public List<QuizDto> getQuizzes() {
        List<QuizDto> QuizDtoList = new ArrayList<>();
        for(Quiz Quiz: quizRepo.findAll()){
            QuizDtoList.add(QuizMapper.entityToDto(Quiz));
        }
        return QuizDtoList;
    }

    public QuizDto getQuizById(Integer id) {
        return QuizMapper.entityToDto(quizRepo.findById(Long.valueOf(id)));
    }

    public ScoreDto processQuiz(List<QuizAnswerDto> answerDtos, Long quizId, Long clientId){
        Integer totalScore = 0;

        for(QuizAnswerDto quizAnswerDto:answerDtos){
            QuestionDto questionDto = questionMapper.entityToDto(questionRepo.findById(quizAnswerDto.getQuestionId()).get());
            Integer partialScore = 0;
            for(Long id: quizAnswerDto.getAnswerIds()){
                Answer ans = answerRepo.findById(id).get();
                if(questionDto.getCorrectAnswerList().contains(ans)){
                    partialScore++;
                }
            }
            if(partialScore == questionDto.getCorrectAnswerList().size()){
                totalScore++;
            }
        }
        Client client = clientRepo.findById(clientId).get();
        Quiz quiz = quizRepo.findById(quizId).get();

        Score score = Score.builder()
                .quiz(quiz)
                .score(totalScore)
                .build();

        List<Score> scoreList = client.getScoreList();
        scoreList.add(score);
        client.setScoreList(scoreList);
        scoreRepo.save(score);
        clientRepo.save(client);

        return scoreMapper.entityToDto(score);
    }

}
