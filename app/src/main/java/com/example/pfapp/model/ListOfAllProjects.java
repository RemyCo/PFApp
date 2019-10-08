/*
 * Class ListOfAllProjects
 * Version 0.2
 * 08/10/2019
 * Author : Rémy Coquard
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp.model;

public class ListOfAllProjects {

    private Project[] listOfProjects;
    private int index = 0;

    public ListOfAllProjects(Project[] listOfProjects) {
        this.listOfProjects = listOfProjects;
    }

    public void setListOfProjects(Project[] listOfProjects) {
        this.listOfProjects = listOfProjects;
    }

    public Project[] getListOfProjects() {
        return listOfProjects;
    }

    public void addProject(Project project){
        listOfProjects[index] = project;
    }

    public boolean exists(Project project){
        boolean exists = false;
        for (int indexExists = 0; indexExists != listOfProjects.length; indexExists++){
            if (listOfProjects[indexExists].equals(project)){
                exists = true;
            }
        }
        return exists;
    }
}
