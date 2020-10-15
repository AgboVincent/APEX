package com.mobile.apex;

public class ApexTopicsModel {
    String topics, topicsPercentage;
    int position;

    public ApexTopicsModel(String topics, String topicsPercentage, int position) {
        this.topics = topics;
        this.topicsPercentage = topicsPercentage;
        this.position = position;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public String getTopicsPercentage() {
        return topicsPercentage;
    }

    public void setTopicsPercentage(String topicsPercentage) {
        this.topicsPercentage = topicsPercentage;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
