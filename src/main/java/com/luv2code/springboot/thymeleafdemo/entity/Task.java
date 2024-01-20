package com.luv2code.springboot.thymeleafdemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name = "duty")
    private String duty;

    @Column(name="status")
    private String status;

    public Task() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Task(int id, String duty, String status) {
        this.id = id;
        this.duty = duty;
        this.status = status;
    }

    public Task(String duty, String status) {
        this.duty = duty;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", duty='" + duty + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
