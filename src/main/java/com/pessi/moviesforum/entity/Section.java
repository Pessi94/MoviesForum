package com.pessi.moviesforum.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SECTION")
public class Section {

    private int id;
    private String name;
    private Section parent;
    private List<Thread> threadList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne()
    public Section getParent() {
        return parent;
    }

    public void setParent(Section parent) {
        this.parent = parent;
    }

    @OneToMany(mappedBy = "section")
    public List<Thread> getThreadList() {
        return threadList;
    }

    public void setThreadList(List<Thread> threadList) {
        this.threadList = threadList;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parent=" + parent +
                '}';
    }

}