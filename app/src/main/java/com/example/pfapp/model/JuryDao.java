package com.example.pfapp.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface JuryDao {
    @Query("SELECT * FROM Jury WHERE id_jury = :idJury")

    List<Jury> getJuryList(int idJury);

    @Insert
    void insertJury(Jury jury);

    @Update
    void updateJury(Jury jury);

    @Delete
    void deleteJury(Jury jury);
}
