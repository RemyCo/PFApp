/*
 * Class JuryWithUsers
 * Version 0.2
 * 08/10/2019
 * Author : Emilien TETU
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.ArrayList;


public class JuryWithUsers {
    @Embedded
    public JuryDB jury;

    @Relation(entity = UserDB.class, parentColumn = "ref_members", entityColumn = "id_user")
    public ArrayList<UserDB> members;
}
