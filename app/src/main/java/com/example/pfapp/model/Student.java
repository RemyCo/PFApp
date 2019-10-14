/*
 * Class Student
 * Version 0.2
 * 08/10/2019
 * Author : Rémy Coquard
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp.model;

public class Student {

    private int id;
    private float mynote;
    private float vgnote;
    private String forename;
    private String surname;


    public Student(int id, String forename, String surname) {
        this.id = id;
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