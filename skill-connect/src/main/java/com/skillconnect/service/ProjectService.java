package com.skillconnect.service;

import com.skillconnect.model.Project;
import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<Project> getAllProjects();
    static Optional<Project> getProjectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
    Project saveProject(Project project);
    void deleteProject(int id);
}
