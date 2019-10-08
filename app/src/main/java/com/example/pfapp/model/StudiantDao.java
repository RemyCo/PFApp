package com.example.pfapp.model;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface StudiantDao {
    @Query("SELECT * FROM Studiant WHERE id_projet = :idProjet")
    public Studiant findProjetWithId(int idProjet);
}
