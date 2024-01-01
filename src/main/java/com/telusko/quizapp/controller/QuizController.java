package com.telusko.quizapp.controller;

import com.telusko.quizapp.service.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("quiz")
public class QuizController {

    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String>createQuiz(@RequestParam String category , @RequestParam int numQ , @RequestParam String title){
        try{
            return new ResponseEntity<>("i m here" , HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Please Implement" , HttpStatus.NOT_IMPLEMENTED);
    }

}
