package com.mobile.apex;

public class ApexModel {
    private String subject, percentage, topics, numOfModules;

    public ApexModel() {
    }

    public ApexModel(String subject, String percentage, String topics, String numOfModules) {
        this.subject = subject;
        this.percentage = percentage;
        this.topics = topics;
        this.numOfModules = numOfModules;
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
}
