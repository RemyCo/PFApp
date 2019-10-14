/*
 * Class StudiantDao
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
public interface StudiantDao {
    @Query("SELECT * FROM StudentDB WHERE id_student = :idStudent")
    List<StudentDB> getStudentList(int idStudent);

    @Insert
    void insertStudent(StudentDB student);

    @Update
    void updateStudent(StudentDB student);

    @Delete
    void deleteStudent(StudentDB student);
}
