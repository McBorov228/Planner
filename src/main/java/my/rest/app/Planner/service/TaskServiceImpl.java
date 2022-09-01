package my.rest.app.Planner.service;

import my.rest.app.Planner.models.Task;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Service
public class TaskServiceImpl implements TaskService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void create(Task task) {
        entityManager.persist(task);
    }

    @Override
    public List<Task> readAll() {
        return entityManager.createQuery("from Task", Task.class).getResultList();
    }

    @Override
    public Task read(Long id) {
        return entityManager.find(Task.class, id);
    }

    @Override
    public Boolean update(Task task, Long id) {
        try {
            Task taskOld = entityManager.find(Task.class, id);
            taskOld.setId(task.getId());
            taskOld.setDate(task.getDate());
            taskOld.setDescription(task.getDescription());
            taskOld.setTitle(task.getTitle());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean delete(Long id) {
        Task task = entityManager.find(Task.class, id);
        try {
            entityManager.remove(task);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
