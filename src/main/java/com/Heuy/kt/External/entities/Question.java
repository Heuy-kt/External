package com.Heuy.kt.External.entities;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "difficulty",
        "category",
        "question",
        "correct_answer",
        "incorrect_answers"
})
@Data
public class Question {

    @JsonProperty("type")
    private String type;
    @JsonProperty("difficulty")
    public String difficulty;
    @JsonProperty("category")
    public String category;
    @JsonProperty("question")
    public String question;
    @JsonProperty("correct_answer")
    public String correctAnswer;
    @JsonProperty("incorrect_answers")
    public List<String> incorrectAnswers;

}
