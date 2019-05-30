package comgreenfox.todos.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String title;
  private String description;
  private boolean urgent = false;
  private boolean done = false;

  @Temporal(TemporalType.DATE)
  private Date createdAtDate = new Date();
  @Temporal(TemporalType.TIME)
  private Date createdAtTime = new Date();

  @ManyToOne
  private Assignee assignee;

  public Todo() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public boolean isUrgent() {
    return urgent;
  }

  public void setUrgent(boolean urgent) {
    this.urgent = urgent;
  }

  public boolean isDone() {
    return done;
  }

  public void setDone(boolean done) {
    this.done = done;
  }

  public Date getCreatedAtDate() {
    return createdAtDate;
  }

  public void setCreatedAtDate(Date createdAtDate) {
    this.createdAtDate = createdAtDate;
  }

  public Date getCreatedAtTime() {
    return createdAtTime;
  }

  public void setCreatedAtTime(Date createdAtTime) {
    this.createdAtTime = createdAtTime;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Assignee getAssignee() {
    return assignee;
  }

  public void setAssignee(Assignee assignee) {
    this.assignee = assignee;
  }
}
