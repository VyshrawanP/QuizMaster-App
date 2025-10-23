package com.vyshrawan.QuizzApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vyshrawan.QuizzApp.QuestionModel.Quiz;

public interface QDao extends JpaRepository<Quiz,Integer> {
    
}
