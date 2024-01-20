package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.dao.TaskRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiseImple implements TaskService{


    private TaskRepository taskRepository;

    @Autowired
    public TaskServiseImple(TaskRepository theTaskRepository){
        taskRepository = theTaskRepository;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findByOrderByStatusAsc();
    }

    @Override
    public Task findById(int theId) {
        Optional<Task> result = taskRepository.findById(theId);

        Task theTask = null;

        if(result.isPresent()){
            theTask = result.get();
        }else {
            throw new RuntimeException("Did not Task id : "+ theId);
        }
        return theTask;
    }

    @Override
    public void save(Task thaTask) {
        taskRepository.save(thaTask);

    }

    @Override
    public void deleteById(int theId) {
        taskRepository.deleteById(theId);
    }
}
