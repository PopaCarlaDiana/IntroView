package com.example.polihack2.model;


import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @ManyToMany
    private List<Answer> answerList;


    @ManyToMany
    private List<Answer> correctAnswerList;

    @Column
    private String feedback;
}
