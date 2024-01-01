package com.telusko.quizapp.Dao;

import com.telusko.quizapp.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionDao extends JpaRepository<Question , Integer> {
    List<Question> findByCategory(String category);
}
