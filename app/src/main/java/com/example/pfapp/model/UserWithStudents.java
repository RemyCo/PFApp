package com.example.pfapp.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.ArrayList;


public class UserWithStudents {
    @Embedded
    public User user;

    @Relation(entity = Student.class, parentColumn = "ref_students", entityColumn = "id_student")
    public ArrayList<Student> studients;
}
