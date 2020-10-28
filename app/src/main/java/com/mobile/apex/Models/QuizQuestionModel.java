package com.mobile.apex.Models;

public class QuizQuestionModel {
    private int id;
    private String question, section, image, answer, solution, examtype, examyear;
    private QuizQuestionOptionModel option;

    public QuizQuestionModel() {
    }

    public QuizQuestionModel(int id, String question, String section, String image, String answer, String solution, String examtype, String examyear, QuizQuestionOptionModel option) {
        this.id = id;
        this.question = question;
        this.section = section;
        this.image = image;
        this.answer = answer;
        this.solution = solution;
        this.examtype = examtype;
        this.examyear = examyear;
        this.option = option;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getExamtype() {
        return examtype;
    }

    public void setExamtype(String examtype) {
        this.examtype = examtype;
    }

    public String getExamyear() {
        return examyear;
    }

    public void setExamyear(String examyear) {
        this.examyear = examyear;
    }

    public QuizQuestionOptionModel getOption() {
        return option;
    }

    public void setOption(QuizQuestionOptionModel option) {
        this.option = option;
    }
}
