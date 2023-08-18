package sample.tmp.todolist.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sample.tmp.todolist.model.Task;
import sample.tmp.todolist.service.TaskService;
import sample.tmp.todolist.util.TechnicalMessage;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // GET: Получить список всех задач
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> todos = taskService.getAllTasks();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    // GET: Получить конкретную задачу по айди
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable("id") Integer id) {
        Optional<Task> task = taskService.getTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK).getBody();
    }

    // POST: Создать новую задачу
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task newTask = taskService.createNewTask(task);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    // PUT: Обновить задачу
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") int id, @RequestBody Task task) {
        Task updatedTask = taskService.updateTask(id, task);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }


    // DELETE: Удалить задачу по айди
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Integer id) {
        String message = TechnicalMessage.DELETEMESSAGE.getMessage();
        taskService.deleteTask(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}


