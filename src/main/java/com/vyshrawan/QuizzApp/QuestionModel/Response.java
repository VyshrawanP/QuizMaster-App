package com.vyshrawan.QuizzApp.QuestionModel;

import lombok.Data;



@Data
public class Response {
    private Integer id;
    private String response;

     // unified field

    // If you need alias methods for some reason:
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
