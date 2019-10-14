/*
 * Class ListOfAllProjects
 * Version 0.2
 * 08/10/2019
 * Author : Rémy Coquard
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp.model;

import java.util.ArrayList;

public class ListOfAllProjects {

    private static ArrayList<Project> listOfProjects;

    public ListOfAllProjects(ArrayList<Project> listOfProjects) {
        this.listOfProjects = listOfProjects;
    }

    public void setListOfProjects(ArrayList<Project> listOfProjects) {
        this.listOfProjects = listOfProjects;
    }

    public ArrayList<Project> getListOfProjects() {
        return listOfProjects;
    }

    public void addProject(Project project){
        listOfProjects.add(project);
    }

    public boolean projectExists(Project project){
        boolean exists = false;
        for (int indexExists = 0; indexExists != listOfProjects.size(); indexExists++){
            if (listOfProjects.contains(project)){
                exists = true;
            }
        }
        return exists;
    }

    public boolean projectIdExists(int idProject){
        boolean exists = false;
        for (int indexExists = 0; indexExists != listOfProjects.size(); indexExists++){
            if (listOfProjects.get(indexExists).getIdProj() == idProject){
                exists = true;
            }
        }
        return exists;
    }
}
