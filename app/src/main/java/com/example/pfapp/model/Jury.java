/*
 * Class Jury
 * Version 0.2
 * 08/10/2019
 * Author : Rémy Coquard
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp.model;

import java.util.ArrayList;

public class Jury{

    private String date;
    private ArrayList<User> members;
    private ArrayList<Project> projects;

    public Jury(String date, ArrayList<User> members, ArrayList<Project> projects) {
        this.date = date;
        this.members = members;
        this.projects = projects;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<User> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<User> members) {
        this.members = members;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }
}
