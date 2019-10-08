/*
 * Class ProjetDao
 * Version 0.2
 * 08/10/2019
 * Author : Emilien TETU
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProjetDao {
    @Query("SELECT * FROM Project WHERE id_project = :idProject")
    List<Project> getProjectList(int idProject);

    @Insert
    void insertProject(Project project);

    @Update
    void updateProject(Project project);

    @Delete
    void deleteProject(Project project);
}
