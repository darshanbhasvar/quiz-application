package com.telusko.quizapp.controller;


import com.telusko.quizapp.Dao.QuestionDao;
import com.telusko.quizapp.models.Question;
import com.telusko.quizapp.models.QuestionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.telusko.quizapp.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("question")
public class questionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allquestion")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllquestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>>getByCategory(@PathVariable String category){

        return questionService.getByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        System.out.println("adding new question"+question.getQuestionTitle());
        System.out.println("hello created new banch");
        return questionService.addQuestion(question);
    }


}
