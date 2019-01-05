package com.pessi.moviesforum.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "THREAD")
public class Thread {

    private int id;
    private Section section;
    private String topic;
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

    @ManyToOne
    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

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

    @OneToMany(mappedBy = "thread", cascade = CascadeType.ALL)
    public List<ThreadPost> getThreadPostList() {
        return threadPostList;
    }

    public void setThreadPostList(List<ThreadPost> threadPostList) {
        this.threadPostList = threadPostList;
    }

    @Override
    public String toString() {
        return "Thread{" +
                "id=" + id +
                ", section=" + section +
                ", topic='" + topic + '\'' +
                ", text='" + text + '\'' +
                ", author=" + author +
                ", creationDate=" + creationDate +
                ", threadPostList=" + threadPostList +
                '}';
    }

}