package org.example.entity;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks,
                    Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }


    public Set<Task> getTasks(String name) {
        switch (name) {
            case "ann":
                return annsTasks;
                case "bob":
                    return bobsTasks;
                    case "carol":
                        return carolsTasks;
                        case "All":
                             /*Set<Task> allTasks = new HashSet<>();
                             allTasks.addAll(annsTasks);
                             allTasks.addAll(bobsTasks);
                             allTasks.addAll(carolsTasks);
                             allTasks.addAll(unassignedTasks);
                             return allTasks;*/
                            return getUnion(annsTasks, bobsTasks, carolsTasks, unassignedTasks);
        }
        return new HashSet<>();
    }

    public Set<Task> getAllEmployeesTasks() {
       /* Set<Task> AllEmployeesTasks = new HashSet<>();
        AllEmployeesTasks.addAll(annsTasks);
        AllEmployeesTasks.addAll(bobsTasks);
        AllEmployeesTasks.addAll(carolsTasks);

        return AllEmployeesTasks;*/
        return getUnion(annsTasks, bobsTasks, carolsTasks);
    }

    public Set<Task> getTasksForEmployee(String employee) {
        if(employee.toLowerCase().equals("all"))
            return new HashSet<>();
        return getTasks(employee.toLowerCase());
    }

    public Set<Task> getUnassignedTasks(){
        Set<Task> notAssignedTasks = new HashSet<>();
        notAssignedTasks.addAll(unassignedTasks);
        return notAssignedTasks;
    }


    public Set<Task> getUnion(Set<Task>... taskList) {
        Set<Task> unionTasks = new HashSet<>();

        for (Set<Task> tasks : taskList) {
            unionTasks.addAll(tasks);
        }
        return unionTasks;
    }


    public Set<Task> getIntersection(Set<Task> tasks1, Set<Task> tasks2) {

        tasks1.retainAll(tasks2);

        return tasks1;
    }


    public Set<Task> getDifferences(Set<Task> tasks1, Set<Task> tasks2) {
        tasks1.removeAll(tasks2);

        return tasks1;

    }
}
