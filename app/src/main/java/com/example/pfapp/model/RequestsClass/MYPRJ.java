package com.example.pfapp.model.RequestsClass;

import com.example.pfapp.model.Project;
import java.util.ArrayList;

public class MYPRJ {

    private static MYPRJ INSTANCE;
    private static ArrayList<Project> listOfProjects = new ArrayList<>();

    private int index = 0;


    private MYPRJ() {
        // Private (Cause we are making a Singleton)
    }

    public static synchronized MYPRJ getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MYPRJ();
        }
        return(INSTANCE);
    }


    public ArrayList<Project> getListOfProjects() {
        return listOfProjects;
    }

    public Project getProject(int index) {
        return listOfProjects.get(index);
    }

    public void addMYPRJProject(Project project){
        listOfProjects.add(project);
    }


    public void clearList(){
        listOfProjects.clear();
    }
}
