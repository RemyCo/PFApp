package com.example.pfapp.model;

import androidx.room.Dao;

@Dao
public interface ProjetDao {
    //@Query("SELECT * FROM Project WHERE id_projet = :idProjet")
    public Project findProjetWithId(int idProjet);
}
