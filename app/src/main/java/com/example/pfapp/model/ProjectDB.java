/*
 * Class Project
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

@Entity(tableName = "ProjectDB" , foreignKeys = {
        @ForeignKey(entity=UserDB.class, parentColumns = "id_user", childColumns = "ref_supervisor"),
        @ForeignKey(entity=StudentDB.class, parentColumns = "id_student",childColumns = "ref_students")
})
public class ProjectDB {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_project")
    private int id;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "poster")
    private int poster;
    @ColumnInfo(name = "confid")//TODO: Poster is not a String
    private String confid;
    @ColumnInfo(name = "ref_supervisor")
    private int supervisor;
    @ColumnInfo(name = "ref_students")
    private int students;

    public ProjectDB(int id, String title, String description, String confid, int supervisor, int students) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.confid = confid;
        this.supervisor = supervisor;
        this.students = students;
    }

    @Ignore
    public ProjectDB(String title, String description, String confid, int supervisor, int students) {
        this.title = title;
        this.description = description;
        this.confid = confid;
        this.supervisor = supervisor;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getConfid() {
        return confid;
    }

    public void setConfid(String confid) {
        this.confid = confid;
    }

    public int getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(int supervisor) {
        this.supervisor = supervisor;
    }
  
    public int getStudents() {
        return students;
    }

    public void setStudents(int students) {
        this.students = students;
    }

}
