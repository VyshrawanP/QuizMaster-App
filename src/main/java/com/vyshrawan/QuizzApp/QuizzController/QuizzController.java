package com.vyshrawan.QuizzApp.QuizzController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vyshrawan.QuizzApp.QuestionService.QuizService;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vyshrawan.QuizzApp.Dao.Dao;
import com.vyshrawan.QuizzApp.Dao.QDao;
import com.vyshrawan.QuizzApp.QuestionModel.Question;
import com.vyshrawan.QuizzApp.QuestionModel.QuestionWrapper;
import com.vyshrawan.QuizzApp.QuestionModel.Quiz;
import com.vyshrawan.QuizzApp.QuestionModel.Response;

@RestController
@RequestMapping("/quiz")
public class QuizzController {
    @Autowired
    private QDao qdao;

    @Autowired
    private Dao dao;
    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuizz(@RequestParam String category,@RequestParam int numQ,@RequestParam String Tquizz){
return quizService.createQuizz(category, numQ,Tquizz);

   

    }


    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id){
        Optional<Quiz> quiz= qdao.findById(id);
        List<Question> qfromdb=quiz.get().getQuestions();
        List<QuestionWrapper> qforuser=new ArrayList<>();
        for(Question q:qfromdb){
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            qforuser.add(qw);
        }


        return new ResponseEntity<>(qforuser,HttpStatus.OK);
    }




    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuizz(@PathVariable Integer id,@RequestBody List<Response> response){
        return quizService.calcuateResult(id,response);
    }
       
        

    }
    

    
    


