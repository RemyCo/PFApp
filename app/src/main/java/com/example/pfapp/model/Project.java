/*
 * Class Project
 * Version 0.2
 * 08/10/2019
 * Author : Rémy Coquard
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp.model;

public class Project {

    private int id;
    private String title;
    private String description;
    private int poster;
    private String confid;
    private int supervisor;
    private int students;

    public Project(int id,String title, String description, String confid, int supervisor, int students) {
        this.id = id;
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
