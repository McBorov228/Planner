package my.rest.app.Planner.repo;

import my.rest.app.Planner.models.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
