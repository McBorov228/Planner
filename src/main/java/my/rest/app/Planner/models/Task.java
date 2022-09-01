package my.rest.app.Planner.models;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Реализация модели "Задача"
 */
@Entity(name = "Task")
@Table(name = "task")
public class Task {

    public Task(Long id, String title, String description, LocalDateTime date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public Task() {}

    @Id
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "title")
    private String title;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description")
    private String description;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "date")
    private LocalDateTime date;
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
