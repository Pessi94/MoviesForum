package com.pessi.moviesforum.entity;

import javax.persistence.*;

@Entity
@Table(name = "THREAD_POST")
public class ThreadPost {

    private Long id;
    private Thread thread;
    private Post post;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "ThreadPost{" +
                "id=" + id +
                ", thread=" + thread +
                ", post=" + post +
                '}';
    }

}