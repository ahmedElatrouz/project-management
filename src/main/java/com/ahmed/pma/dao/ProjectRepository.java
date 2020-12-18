package com.ahmed.pma.dao;

import com.ahmed.pma.entities.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project,Long> {
}
