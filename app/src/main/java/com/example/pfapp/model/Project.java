/*
 * Class Project
 * Version 0.2
 * 08/10/2019
 * Author : Rémy Coquard
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp.model;

public class Project {

    private String title;
    private String description;
    private String poster;                                  //TODO: Poster is not a String
    private String confid;
    private User supervisor;
    private User[] students;

    public Project(String title, String description, String confid, User supervisor, User[] students) {
        this.title = title;
        this.description = description;
        this.confid = confid;
        this.supervisor = supervisor;
        this.students = students;
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

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
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

    public User[] getStudents() {
        return students;
    }

    public void setStudents(User[] students) {
        this.students = students;
    }


}
