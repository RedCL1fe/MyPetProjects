package sample.tmp.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.tmp.todolist.model.Task;
import sample.tmp.todolist.repository.TaskRepository;


import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Метод для получения всех задач
    public List<Task> getAllTasks() {

        return taskRepository.findAll();
    }

    // Метод для получения задачи по id
    public Optional<Task> getTaskById (int id) {
        return taskRepository.findById(id);
    }

    // Метод для создания новой задачи
    public Task createNewTask(Task task) {
        return taskRepository.save(task);
    }

    // Метод для обновления информации о задаче
    public Task updateTask(int id, Task task) {

        Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isPresent()) {

            Task updateTask = optionalTask.get();

            updateTask.setTitle(task.getTitle());
            updateTask.setDescription(task.getDescription());
            updateTask.setDueDate(task.getDueDate());

            return taskRepository.save(updateTask);

        } else
            throw new RuntimeException("Task with id " + id + " not found :(");
    }

    // Метод для удаления задачи по id
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }
}
