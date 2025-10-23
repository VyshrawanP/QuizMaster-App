package com.vyshrawan.QuizzApp.QuestionService;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.vyshrawan.QuizzApp.Dao.Dao;
import com.vyshrawan.QuizzApp.Dao.QDao;
import com.vyshrawan.QuizzApp.QuestionModel.Question;
import com.vyshrawan.QuizzApp.QuestionModel.QuestionWrapper;
import com.vyshrawan.QuizzApp.QuestionModel.Quiz;
import com.vyshrawan.QuizzApp.QuestionModel.Response;

import jakarta.transaction.Transactional;

@Service
@Transactional
 public class QuizService {

    @Autowired
    QDao qdao;

    @Autowired
    Dao dao;

    public ResponseEntity<String> createQuizz(String category, int numQ,String Tquizz) {
 
     // Fetch questions from DB — must be managed entities
    List<Question> questions = dao.findRandomQuestionsByCategory(category, numQ);

    if (questions.isEmpty()) {
        return new ResponseEntity<>("No questions available for category: " + category, HttpStatus.BAD_REQUEST);
    }

    // Create Quiz object
    Quiz quiz = new Quiz(category,questions,Tquizz);
    quiz.setCategory(category);
    quiz.setQuestions(questions);
    quiz.setTitle(Tquizz); // explicitly set title

    // Save and immediately flush to DB

     qdao.save(quiz);

    return new ResponseEntity<>("Quiz created with ID: " + quiz.getId(), HttpStatus.CREATED);
}
    
  public QuizService() {
    }
public List<QuestionWrapper> getQuizQuestions(@PathVariable Integer id) {
    Quiz quiz = qdao.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found with id: " + id));

        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for (Question q : quiz.getQuestions()) {
            questionsForUser.add(new QuestionWrapper(
                    q.getId(),
                    q.getQuestionTitle(),
                    q.getOption1(),
                    q.getOption2(),
                    q.getOption3(),
                    q.getOption4()
            ));
        }
        
        return questionsForUser;

}
 

    public ResponseEntity<Integer> calcuateResult(Integer id, List<Response> responses) {
        Quiz quiz=qdao.findById(id).get();
        List<Question> questions=quiz.getQuestions();
          int right =0;
        int i=0;
        for(Response response:responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer())){
                right++;
            }
            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);


    }   

}


//