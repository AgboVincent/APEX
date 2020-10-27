package com.mobile.apex;

import java.util.List;

public class QuizModel {
    private String subject;
    private int status;
    private List<QuizQuestionModel> data;

    public QuizModel(String subject, int status, List<QuizQuestionModel> data) {
        this.subject = subject;
        this.status = status;
        this.data = data;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<QuizQuestionModel> getData() {
        return data;
    }

    public void setData(List<QuizQuestionModel> data) {
        this.data = data;
    }
}
