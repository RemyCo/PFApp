package com.example.pfapp.model;

import androidx.room.Dao;

@Dao
public interface StudiantDao {
    //@Query("SELECT * FROM Student WHERE id_projet = :idProjet")
    public Student findProjetWithId(int idProjet);
}
