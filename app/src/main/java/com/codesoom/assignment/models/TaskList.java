package com.codesoom.assignment.models;

import com.codesoom.assignment.config.TaskNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private final List<Task> taskList = new ArrayList<>();
    private int newId = 0;


    public void add(Task task) {
        task.updateId(generatedId());
        taskList.add(task);
    }

    private int generatedId() {
        return newId += 1;
    }

    public List<Task> getItems() {
        return this.taskList;
    }

    public Task get(int idx) throws TaskNotFoundException {
        return taskList.stream()
                .filter(task -> task.getId() == idx)
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException("not found"));
    }

    public void update(int taskId, String title) throws TaskNotFoundException {
        Task task = get(taskId);
        task.updateTitle(title);
    }

    public boolean delete(int taskId) throws TaskNotFoundException {
        return this.taskList.remove(get(taskId));
    }

    public int size() {
        return this.taskList.size();
    }
}
