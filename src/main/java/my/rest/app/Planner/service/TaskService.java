package my.rest.app.Planner.service;

import my.rest.app.Planner.models.Task;

import java.util.List;

public interface TaskService {

    /**
     * Создание новой задачи
     * @param task - задача, которую надо добавить
     */
    void create(Task task);

    /**
     * Получить все задачи
     * @return
     */
    List<Task> readAll();

    /**
     * Получить задачу по id
     * @param id - идентификатор
     */
    Task read(Long id);

    /**
     * Обновить задачу по id
     * @param id - идентификатор
     * @param task - задача
     */
    Boolean update(Task task, Long id);

    /**
     * Удалить задачу по id
     * @param id - идентификатор
     */
    Boolean delete(Long id);

}
