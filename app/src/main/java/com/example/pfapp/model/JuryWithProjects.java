package com.example.pfapp.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.ArrayList;


public class JuryWithProjects {
    @Embedded
    public Jury jury;

    @Relation(entity = Project.class, parentColumn = "ref_projects", entityColumn = "id_project")
    public ArrayList<Project> projects;
}
