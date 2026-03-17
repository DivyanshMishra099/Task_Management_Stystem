package com.TaskManager.WebApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.TaskManager.WebApp.Model.Task;
import com.TaskManager.WebApp.Repository.TaskRepo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskClass {
    @Autowired
    TaskRepo taskrepo;
    @GetMapping("/")
    public String ViewHomePage(Model model) {
        model.addAttribute("listTasks",taskrepo.findAll());
        return "index";
    }
    @GetMapping("/new")
    public String addNewTask(Model model){
        model.addAttribute("task", new Task());
        return "newTask";
    }
    @PostMapping("/save")
    public String saveTask(@ModelAttribute("task")Task task){
        taskrepo.save(task);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable int id,Model model){
        model.addAttribute("task", taskrepo.findById(id).get());
        return "editTask";
    }
    @PostMapping("/update")
    public String updateTask(@ModelAttribute("task") Task task){
        taskrepo.save(task);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable int  id){
        taskrepo.deleteById(id);
        return "redirect:/";
    }
}
