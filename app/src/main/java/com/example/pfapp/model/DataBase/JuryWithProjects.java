/*
 * Class JuryWithProjects
 * Version 0.2
 * 08/10/2019
 * Author : Emilien TETU
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp.model.DataBase;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.ArrayList;


public class JuryWithProjects {
    @Embedded
    public JuryDB jury;

    @Relation(entity = ProjectDB.class, parentColumn = "ref_projects", entityColumn = "id_project")
    public ArrayList<ProjectDB> projects;
}
