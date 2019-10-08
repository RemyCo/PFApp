package com.example.pfapp.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.ArrayList;


public class JuryWithUsers {
    @Embedded
    public Jury jury;

    @Relation(entity = User.class, parentColumn = "ref_members", entityColumn = "id_user")
    public ArrayList<User> members;
}
