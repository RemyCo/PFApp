package com.example.pfapp.model;

import androidx.room.Dao;

@Dao
public interface UserDao {
    //@Query("SELECT * FROM User WHERE id_projet = :idProjet")
    public User findProjetWithId(int idProjet);
}
