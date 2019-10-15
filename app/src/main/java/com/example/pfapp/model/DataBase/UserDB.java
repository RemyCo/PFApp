/*
 * Class User
 * Version 0.2
 * 08/10/2019
 * Author : Rémy Coquard
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp.model.DataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "UserDB")
public class UserDB {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_user")
    private int idUser;
    @ColumnInfo(name = "forename")
    private String forename;
    @ColumnInfo(name = "surname")
    private String surname;

    public UserDB(int idUser, String forename, String surname) {
        this.idUser = idUser;
        this.forename = forename;
        this.surname = surname;
    }

    @Ignore
    public UserDB(String forename, String surname) {
        this.forename = forename;
        this.surname = surname;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
