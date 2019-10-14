/*
 * Class Project
 * Version 0.2
 * 08/10/2019
 * Author : Rémy Coquard
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp.model;

import java.util.ArrayList;

public class Project {

    private int idProj;
    private String title;
    private String description;
    private int poster;                                  //TODO: Poster is not a String
    private String confid;
    private User supervisor;
    private ArrayList<Student> students;

    public Project(int idProj, String title, String description, String confid, User supervisor, ArrayList<Student> students) {
        this.idProj = idProj;
        this.title = title;
        this.description = description;
        this.confid = confid;
        this.supervisor = supervisor;
        this.students = students;
    }

    public int getIdProj() {
        return idProj;
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

    public User getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(User supervisor) {
        this.supervisor = supervisor;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }


}
