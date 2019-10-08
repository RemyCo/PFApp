/*
 * Class Jury
 * Version 0.2
 * 08/10/2019
 * Author : Rémy Coquard
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Jury" , foreignKeys = {
        @ForeignKey(entity=User.class, parentColumns = "id_user", childColumns = "ref_members"),
        @ForeignKey(entity=Project.class, parentColumns = "id_project", childColumns = "ref_projects")
})
public class Jury{

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_jury")
    private int id;
    @ColumnInfo(name = "date")
    private String date;
    @ColumnInfo(name = "ref_members")
    private int members;
    @ColumnInfo(name = "ref_projects")
    private int projects;

    public Jury(int id,String date, int members, int projects) {
        this.id = id;
        this.date = date;
        this.members = members;
        this.projects = projects;
    }
    @Ignore
    public Jury(String date, int members, int projects) {
        this.date = date;
        this.members = members;
        this.projects = projects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public int getProjects() {
        return projects;
    }

    public void setProjects(int projects) {
        this.projects = projects;
    }
}
