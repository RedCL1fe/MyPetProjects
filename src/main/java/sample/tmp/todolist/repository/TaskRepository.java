package sample.tmp.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sample.tmp.todolist.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
}
