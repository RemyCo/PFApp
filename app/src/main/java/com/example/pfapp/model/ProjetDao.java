package com.example.pfapp.model;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface ProjetDao {
    @Query("SELECT * FROM Projet WHERE id_projet = :idProjet")
    public Projet findProjetWithId(int idProjet);
}
