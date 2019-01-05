package com.pessi.moviesforum.dto;

public class CreateThreadDto {

    private String topic;
    private String text;
    private int sectionId;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    @Override
    public String toString() {
        return "CreateThreadDto{" +
                "topic='" + topic + '\'' +
                ", text='" + text + '\'' +
                ", sectionId=" + sectionId +
                '}';
    }

}
