package my.rest.app.Planner.controllers;

import my.rest.app.Planner.models.Task;
import my.rest.app.Planner.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Вставка задачи
     */
    @PostMapping(value = "/tasks")
    public ResponseEntity<?> create(@RequestParam("id") Integer id, @RequestParam("title") String title, @RequestParam("description") String description, @RequestParam("date") String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        Task task = new Task(Long.valueOf(id), title, description, dateTime);
        taskService.create(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Получить все задачи
     */
    @GetMapping(value = "tasks")
    public ResponseEntity<List<Task>> readAll() {
        final List<Task> tasks = taskService.readAll();
        return tasks != null && !tasks.isEmpty() ? new ResponseEntity<>(tasks, HttpStatus.OK) : new ResponseEntity<>(tasks, HttpStatus.NOT_FOUND);
    }

    /**
     * Получить задачу по id
     */
    @GetMapping(value = "/tasks/{id}")
    public ResponseEntity<Task> read(@PathVariable(name="id") Long id) {
        final Task task = taskService.read(id);
        return task != null ? new ResponseEntity<>(task, HttpStatus.OK) : new ResponseEntity<>(task, HttpStatus.NOT_FOUND);
    }

    /**
     * Обновить задачу по id
     */
    @PutMapping(value = "/tasks/{id}")
    public ResponseEntity<?> update(@PathVariable(name="id") Long id, @RequestBody Task taskOld) {
        final boolean updateTask = taskService.update(taskOld ,id);
        return updateTask ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


    @DeleteMapping(value = "/tasks/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") Long id) {
        Boolean answer = taskService.delete(id);
        return answer ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
