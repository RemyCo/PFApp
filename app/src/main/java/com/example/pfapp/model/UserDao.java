package com.example.pfapp.model;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface UserDao {
    @Query("SELECT * FROM User WHERE id_projet = :idProjet")
    public User findProjetWithId(int idProjet);
}
