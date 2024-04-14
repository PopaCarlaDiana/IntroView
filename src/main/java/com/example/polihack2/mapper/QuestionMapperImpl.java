package com.example.polihack2.mapper;

import com.example.polihack2.model.Answer;
import com.example.polihack2.model.Question;
import com.example.polihack2.repos.AnswerRepo;
import com.example.polihack2.security.dto.QuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class QuestionMapperImpl implements QuestionMapper{

    private final AnswerRepo answerRepo;

    @Override
    public QuestionDto entityToDto(Question question) {
        return QuestionDto.builder()
                .description(question.getDescription())
                .answerList(question.getAnswerList())
                .correctAnswerList(question.getCorrectAnswerList())
                .feedback(question.getFeedback())
                .build();
    }

    @Override
    public Question dtoToEntity(QuestionDto questionDto) {

        List<Answer> descriptionList = new ArrayList<>();
        for(Answer  answerDescription: questionDto.getAnswerList()){
            descriptionList.add(answerRepo.findByDescription(answerDescription.getDescription()));
        }

        List<Answer> descriptionListCorrect = new ArrayList<>();
        for(Answer  answerDescription: questionDto.getCorrectAnswerList()){
            descriptionListCorrect.add(answerRepo.findByDescription(answerDescription.getDescription()));
        }

        return Question.builder()
                .description(questionDto.getDescription())
                .answerList(descriptionList)
                .correctAnswerList(descriptionListCorrect)
                .feedback(questionDto.getFeedback())
                .build();
    }
}
