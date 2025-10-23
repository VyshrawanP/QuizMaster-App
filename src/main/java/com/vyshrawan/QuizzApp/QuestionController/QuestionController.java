package com.vyshrawan.QuizzApp.QuestionController;

import com.vyshrawan.QuizzApp.QuestionModel.Question;
import com.vyshrawan.QuizzApp.QuestionService.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.http.HttpResponse;
import java.util.List;


@RestController
@RequestMapping("/")
public class QuestionController {

    @Autowired
    QuestionService questionService;


    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>>getallQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{cat}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable("cat") String category){
        return questionService.getQuestionsByCategory(category);
    }
    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
        

    }
}
