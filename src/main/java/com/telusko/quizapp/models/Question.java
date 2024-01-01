package com.telusko.quizapp.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Repository;
@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String questionTitle;
    private String Option1;
    private String Option2;
    private String Option3;
    private String Option4;
    private String rightAns;
    private String difficultyLevel;
    private String category;
}
