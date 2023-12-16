package com.r3negade.practic2web.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Model1 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String fullTask;
    private String priority;
    private String type;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullTask() {
        return fullTask;
    }

    public void setFullTask(String fullTitle) {
        this.fullTask = fullTitle;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Model1(String title, String fullTask, String priority, String type) {
        this.title = title;
        this.fullTask = fullTask;
        this.priority = priority;
        this.type = type;
    }


    public Model1() {

    }
}
