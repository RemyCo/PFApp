/*
 * Class Student
 * Version 0.2
 * 08/10/2019
 * Author : Rémy Coquard
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Student")
public class StudentDB{

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_student")
    private int id;
    @ColumnInfo(name = "mynote")
    private float mynote;
    @ColumnInfo(name = "vgnote")
    private float vgnote;
    @ColumnInfo(name = "forename")
    private String forename;
    @ColumnInfo(name = "surname")
    private String surname;


    public StudentDB(int id,String forename, String surname) {
        this.id = id;
        this.forename = forename;
        this.surname = surname;
    }

    @Ignore
    public StudentDB(String forename, String surname) {
        this.forename = forename;
        this.surname = surname;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return id;
    }

    public float getMynote() {
        return mynote;
    }

    public float getVgnote() {
        return vgnote;
    }

    public void setMynote(float mynote) {
        this.mynote = mynote;
    }

    public void setVgnote(float vgnote) {
        this.vgnote = vgnote;
    }
}

