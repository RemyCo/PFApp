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

    private static ListOfAllProjects INSTANCE;
    private static ArrayList<Project> listOfProjects = new ArrayList<>();

    private ListOfAllProjects() {
        // Private (Cause we are making a Singleton)
    }

    public static synchronized ListOfAllProjects getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ListOfAllProjects();
        }
        return(INSTANCE);
    }

    public ArrayList<Project> getListOfProjects() {
        return listOfProjects;
    }

    public void addProject(Project project){
        listOfProjects.add(project);
    }


    public int projectNameIndexExists(String name){
        for (int indexExists = 0; indexExists != listOfProjects.size(); indexExists++){
            if (listOfProjects.get(indexExists).getTitle().equals(name)){
                return indexExists;
            }
        }
        return 0;
    }

    public int projectIdIndexExists(int idProject){
        for (int indexExists = 0; indexExists != listOfProjects.size(); indexExists++){
            if (listOfProjects.get(indexExists).getId() == idProject){
                return indexExists;
            }
        }
        return 0;
    }

    public Project getProject(int index) {
        return listOfProjects.get(index);
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
            if (listOfProjects.get(indexExists).getId() == idProject){
                exists = true;
            }
        }
        return exists;
    }
}
