package com.vyshrawan.QuizzApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import com.vyshrawan.QuizzApp.QuestionModel.Question;
import java.util.List;


@Repository
public interface Dao extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String anything);

    @Query(value = "SELECT * FROM Question WHERE category = :category ORDER BY RAND() LIMIT :numq",nativeQuery = true)
List<Question> findRandomQuestionsByCategory(@Param("category") String category, @Param("numq") int numq);


}
