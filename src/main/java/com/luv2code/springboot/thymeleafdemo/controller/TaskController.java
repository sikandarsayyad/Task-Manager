package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Task;
import com.luv2code.springboot.thymeleafdemo.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    
    private TaskService taskService;
    
    public TaskController(TaskService theTaskController){
         this.taskService = theTaskController;
    }
    
    @GetMapping("/list")
    public String listTasks(Model theModel){
        
        List<Task> theTasks = taskService.findAll();
        
        theModel.addAttribute("tasks", theTasks);

        return "tasks/list-tasks";

    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        //create model attribute to bind form data
        Task theTask = new Task();

        theModel.addAttribute("tasks",theTask);

        return "tasks/task-form";

    }
    @PostMapping("/save")
    public String saveTask(@ModelAttribute("task")Task theTask){

        //save the employee
        taskService.save(theTask);

        //use a redirect to prevent duplicate  submissions
        return "redirect:/tasks/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("taskId") int theId, Model theModel){

        //get the employee from the service
        Task theTask = taskService.findById(theId);

        //set employee in the model to prepopulate the form
        theModel.addAttribute("tasks", theTask);

        //send over to our form
        return "tasks/task-form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("taskId") int theId){

        //delete employee by id
        taskService.deleteById(theId);

        //redirect to /employee/list
        return "redirect:/tasks/list";

    }

}