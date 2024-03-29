package com.telusko.quizapp.models;


import jakarta.persistence.Entity;
import lombok.Data;

@Data

public class QuestionWrapper {

    private Integer Id;
    private String questionTitle;
    private String Option1;
    private String Option2;
    private String Option3;
    private String Option4;

    public QuestionWrapper(Integer id, String questionTitle, String option1, String option2, String option3, String option4) {
        Id = id;
        this.questionTitle = questionTitle;
        Option1 = option1;
        Option2 = option2;
        Option3 = option3;
        Option4 = option4;
    }
}
