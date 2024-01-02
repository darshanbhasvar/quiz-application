package com.telusko.quizapp.service;


import com.telusko.quizapp.Dao.QuestionDao;
import com.telusko.quizapp.Dao.QuizDao;
import com.telusko.quizapp.models.Question;
import com.telusko.quizapp.models.QuestionWrapper;
import com.telusko.quizapp.models.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    QuizDao quizDao;

    QuestionDao questionDao;

    public QuizService(QuizDao quizDao, QuestionDao questionDao) {
        this.quizDao = quizDao;
        this.questionDao = questionDao;
    }
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        //getting random question by category using dao
        List<Question> question = questionDao.findRandomQuestionBycategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(question);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionFromDb = quiz.get().getQuestions();
        List<QuestionWrapper> questionforUser = new ArrayList<>();

        for(Question q : questionFromDb){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionforUser.add(qw);
        }
        return new ResponseEntity<>(questionforUser,HttpStatus.OK);
    }
}
