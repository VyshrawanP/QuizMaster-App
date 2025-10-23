package com.vyshrawan.QuizzApp.QuestionService;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vyshrawan.QuizzApp.Dao.Dao;
import com.vyshrawan.QuizzApp.Dao.QDao;
import com.vyshrawan.QuizzApp.QuestionModel.Question;
import com.vyshrawan.QuizzApp.QuestionModel.QuestionWrapper;
import com.vyshrawan.QuizzApp.QuestionModel.Quiz;
import com.vyshrawan.QuizzApp.QuestionModel.Response;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class QuestionService {

    @Autowired
    private QDao qdao;

    @Autowired
    private Dao dao;

    public ResponseEntity<String> addQuestion(Question question) {
    dao.save(question);
    return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
    return new ResponseEntity<>(dao.findByCategory(category),HttpStatus.OK);
    }


    public ResponseEntity<List<Question>> getAllQuestions() {

        return new ResponseEntity<>(dao.findAll(),HttpStatus.OK);
    }



  
    
}
