package com.good.tyotto.nknock.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Knock {


    /**
     * ノックID
     */
    private int knockId;

    /**
     * クイズ
     */
    private String quiz;

    /**
     * 答え
     */
    private String answer;

    /**
     * ノックリストID
     */
    private int knockListId;

    public int getKnockId() {
        return knockId;
    }

    public void setKnockId(int knockId) {
        this.knockId = knockId;
    }

    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getKnockListId() {
        return knockListId;
    }

    public void setKnockListId(int knockListId) {
        this.knockListId = knockListId;
    }
}
