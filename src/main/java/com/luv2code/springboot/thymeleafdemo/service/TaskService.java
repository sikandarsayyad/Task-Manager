package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.entity.Task;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface TaskService {

    List<Task> findAll();

    Task findById(int theId);

    void save(Task thaTask);

    void deleteById(int theId);
}
