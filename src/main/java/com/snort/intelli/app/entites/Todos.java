package com.snort.intelli.app.entites;
import org.hibernate.annotations.SQLUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_Todos")
public class Todos {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long taskId;
	private String title;
	private String description;
	private String completed; //[NEW, COMPLETED, PENDING]
	private String assignedBy;
	private Integer difficultyLevel; //[1 - 5]
	private Date assignedDate;
	private Date updatedDate;

	public Todos() {
		super();
	}

	public Todos(Long taskId, String title, String description, String completed, String assignedBy, Integer difficultyLevel, Date assignedDate, Date updatedDate) {
		this.taskId = taskId;
		this.title = title;
		this.description = description;
		this.completed = completed;
		this.assignedBy = assignedBy;
		this.difficultyLevel = difficultyLevel;
		this.assignedDate = assignedDate;
		this.updatedDate = updatedDate;
	}

	public Todos(String title, String description, String completed, String assignedBy, Integer difficultyLevel, Date assignedDate, Date updatedDate) {
		this.title = title;
		this.description = description;
		this.completed = completed;
		this.assignedBy = assignedBy;
		this.difficultyLevel = difficultyLevel;
		this.assignedDate = assignedDate;
		this.updatedDate = updatedDate;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompleted() {
		return completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}

	public String getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}

	public Integer getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(Integer difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public Date getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Todos{" +
				"taskId=" + taskId +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				", completed='" + completed + '\'' +
				", assignedBy='" + assignedBy + '\'' +
				", difficultyLevel=" + difficultyLevel +
				", assignedDate=" + assignedDate +
				", updatedDate=" + updatedDate +
				'}';
	}
}
