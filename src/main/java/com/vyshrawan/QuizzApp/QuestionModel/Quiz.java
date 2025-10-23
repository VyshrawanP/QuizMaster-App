package com.vyshrawan.QuizzApp.QuestionModel;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String category;
    @Column(name = "tquizz")
    private String Tquizz;


@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(
    name = "quiz_questions",
    joinColumns = @JoinColumn(name = "quiz_id"),
    inverseJoinColumns = @JoinColumn(name = "question_id"))
private List<Question> questions = new ArrayList<>();

public Quiz(){

}
public Quiz(String category, List<Question> questions,String Tquizz) {
        this.category = category;
        this.Tquizz=Tquizz;
        this.questions = questions;
    }

public void setCategory(String subject) {
    this.category = subject;
}
public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }


    public List<Question> getQuestions() {
        return questions;
    }

public void setQuestions(List<Question> questions) {
    this.questions = questions;
}
public String getTitle() {
    return Tquizz;
}

public void setTitle(String title) {
    this.Tquizz = title;
}




}
