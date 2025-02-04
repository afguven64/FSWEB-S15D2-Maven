package org.example.entity;

import java.util.Objects;

public class Task {
    private String project;
    private String description;
    private String assignee;
    private Priority priority;
    private Status status;

    public Task(String javaCollections, String writeListInterface, String ann, Status status, Priority priority) {
        this.project = javaCollections;
        this.description = writeListInterface;
        this.assignee = ann;
        this.status = status;
        this.priority = priority;

    }

    public String getProject() {
        return project;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof Task))
            return false;

        Task task = (Task)obj;

        return this.project.equals(task.getProject()) && this.description.equals(task.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(project, description);
    }

    public String getAssignee() {
        return assignee;
    }

    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }
}
