/*
 * Class Student
 * Version 0.2
 * 08/10/2019
 * Author : Rémy Coquard
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp.model;

public class Student extends User {

    private float mynote;
    private float vgnote;

    public Student(String forename, String surname) {
        super(forename, surname);
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
