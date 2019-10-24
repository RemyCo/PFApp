/*
 * Class LIPRJClass
 * Version 0.2
 * 08/10/2019
 * Author : Rémy Coquard
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp.model.RequestsClass;

import com.example.pfapp.model.Project;

import java.util.ArrayList;

public class LIPRJClass {

    private ArrayList<Project> listOfProjects;
    private int index = 0;

    public LIPRJClass(ArrayList<Project> listOfProjects) {
        this.listOfProjects = listOfProjects;
    }

    public void setListOfProjects(ArrayList<Project> listOfProjects) {
        this.listOfProjects = listOfProjects;
    }

    public void addLIPRJProject(Project project){
        listOfProjects.add(project);
    }

    public void clearList(){
        listOfProjects.clear();
    }
}
