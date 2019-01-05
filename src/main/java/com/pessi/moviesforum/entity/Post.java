package com.pessi.moviesforum.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "POST")
public class Post {

    private int id;
    private String text;
    private User author;
    private LocalDateTime creationDate;
    private List<ThreadPost> threadPostList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @ManyToOne
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @OneToMany(mappedBy = "post")
    public List<ThreadPost> getThreadPostList() {
        return threadPostList;
    }

    public void setThreadPostList(List<ThreadPost> threadPostList) {
        this.threadPostList = threadPostList;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", author=" + author +
                ", creationDate=" + creationDate +
                ", threadPostList=" + threadPostList +
                '}';
    }

}