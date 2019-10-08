package com.example.pfapp.model;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface JuryDao {
    @Query("SELECT * FROM Jury WHERE id_projet = :idProjet")
    public Jury findProjetWithId(int idProjet);
}
