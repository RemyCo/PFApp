/*
 * Class JuryDao
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
public interface JuryDao {
    @Query("SELECT * FROM JuryDB WHERE id_jury = :idJury")

    List<JuryDB> getJuryList(int idJury);

    @Insert
    void insertJury(JuryDB jury);

    @Update
    void updateJury(JuryDB jury);

    @Delete
    void deleteJury(JuryDB jury);
}
