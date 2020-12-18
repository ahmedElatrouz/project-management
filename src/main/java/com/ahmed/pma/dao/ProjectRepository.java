package com.ahmed.pma.dao;

import com.ahmed.pma.entities.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project,Long> {

    @Override
    List<Project> findAll();
}
