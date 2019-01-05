package com.pessi.moviesforum.dto;

public class AddPostDto {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "AddPostDto{" +
                "text='" + text + '\'' +
                '}';
    }

}
