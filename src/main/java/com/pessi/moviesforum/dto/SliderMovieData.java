package com.pessi.moviesforum.dto;

public class SliderMovieData {

    private String img;
    private String name;
    private String link;

    public SliderMovieData(String img, String name, String link) {
        this.img = img;
        this.name = name;
        this.link = link;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "SliderMovieData{" +
                "img='" + img + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
