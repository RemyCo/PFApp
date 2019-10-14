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
    @Query("SELECT * FROM ProjectDB WHERE id = :idProject")
    List<Project> getProjectList(int idProject);

    @Insert
    void insertProject(ProjectDB project);

    @Update
    void updateProject(ProjectDB project);

    @Delete
    void deleteProject(ProjectDB project);
}
