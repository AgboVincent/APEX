package com.mobile.apex.Models;

public class ApexModel {
    private String subject, percentage, topics, numOfModules;
    int position;

    public ApexModel() {
    }


    public ApexModel(String subject, String percentage, String topics, String numOfModules, int position) {
        this.subject = subject;
        this.percentage = percentage;
        this.topics = topics;
        this.numOfModules = numOfModules;
        this.position = position;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public String getNumOfModules() {
        return numOfModules;
    }

    public void setNumOfModules(String numOfModules) {
        this.numOfModules = numOfModules;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
