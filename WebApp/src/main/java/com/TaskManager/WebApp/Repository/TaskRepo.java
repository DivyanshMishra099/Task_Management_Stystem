package com.TaskManager.WebApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TaskManager.WebApp.Model.Task;

public interface TaskRepo extends JpaRepository<Task, Integer> {

}
