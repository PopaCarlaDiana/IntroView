package com.example.polihack2.mapper;


import com.example.polihack2.model.Question;
import com.example.polihack2.model.Quiz;
import com.example.polihack2.repos.QuestionRepo;
import com.example.polihack2.repos.ScoreRepo;
import com.example.polihack2.security.dto.QuizDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class QuizMapperImpl implements QuizMapper{

    private final QuestionRepo questionRepo;
    private final ScoreRepo scoreRepo;

    @Override
    public QuizDto entityToDto(Quiz quiz) {

        if(scoreRepo.findByQuizId(quiz.getId())!=null){
            return QuizDto.builder()
                    .id(quiz.getId())
                    .description(quiz.getDescription())
                    .questionList(quiz.getQuestionList())
                    .score(scoreRepo.findByQuizId(quiz.getId()).getScore())
                    .build();
        }
        return QuizDto.builder()
                .id(quiz.getId())
                .description(quiz.getDescription())
                .questionList(quiz.getQuestionList())
                .score(0)
                .build();
    }

    @Override
    public Quiz dtoToEntity(QuizDto quizDto) {
        List<Question> questionList = new ArrayList<>();
        for(Question  question: quizDto.getQuestionList()){
            questionList.add(questionRepo.findByDescription(question.getDescription()));
        }

        return Quiz.builder()
                .description(quizDto.getDescription())
                .questionList(questionList)
                .build();
    }

    @Override
    public QuizDto entityToDto(Optional<Quiz> quiz) {
        if(quiz.isPresent()){
            return QuizDto.builder()
                    .id(quiz.get().getId())
                    .description(quiz.get().getDescription())
                    .questionList(quiz.get().getQuestionList())
                    .build();
        }
        else{
            return null;
        }

    }
}
