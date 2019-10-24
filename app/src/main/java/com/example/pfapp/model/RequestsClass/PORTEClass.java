package com.example.pfapp.model.RequestsClass;

import com.example.pfapp.model.Project;
import java.util.ArrayList;

public class PORTEClass {

    private static PORTEClass INSTANCE;
    private static ArrayList<Project> listOfPorteProjects = new ArrayList<>();

    private int index = 0;


    private PORTEClass() {
        // Private (Cause we are making a Singleton)
    }

    public static synchronized PORTEClass getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PORTEClass();
        }
        return(INSTANCE);
    }

    public static ArrayList<Project> getListOfPorteProjects() {
        return listOfPorteProjects;
    }

    public void addMYPRJProject(Project project){
        listOfPorteProjects.add(project);
    }


    public void clearList(){
        listOfPorteProjects.clear();
    }
}