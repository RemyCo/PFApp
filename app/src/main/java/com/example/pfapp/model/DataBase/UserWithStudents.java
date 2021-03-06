/*
 * Class UserWithStudents
 * Version 0.2
 * 08/10/2019
 * Author : Emilien TETU
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp.model.DataBase;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.ArrayList;


public class UserWithStudents {
    @Embedded
    public UserDB user;

    @Relation(entity = StudentDB.class, parentColumn = "ref_students", entityColumn = "id_student")
    public ArrayList<StudentDB> studients;
}
