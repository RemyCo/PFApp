/*
 * Class UserDao
 * Version 0.2
 * 08/10/2019
 * Author : Emilien TETU
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp.model.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM UserDB WHERE id_user = :idUser")
    List<UserDB> getUserList(int idUser);

    @Insert
    void insertUser(UserDB user);

    @Update
    void updateUser(UserDB user);

    @Delete
    void deleteUser(UserDB user);
}
