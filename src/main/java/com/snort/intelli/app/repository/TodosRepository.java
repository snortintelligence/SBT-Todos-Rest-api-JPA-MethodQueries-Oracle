package com.snort.intelli.app.repository;

import com.snort.intelli.app.entites.Todos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TodosRepository extends CrudRepository<Todos, Long> {

    List<Todos> findByTitle(String title); // find a task where task_title for given title
    List<Todos> findByAssignedBy(String assignedBy); // find a task where task_assigned By someone
    List<Todos> findByDifficultyLevelAndCompleted(Integer difficultyLevel, String completed); // find a task where difficultyLevel & completed given

}
