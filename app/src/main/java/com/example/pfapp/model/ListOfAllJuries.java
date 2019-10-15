/*
 * Class ListOfAllUsers
 * Version 0.2
 * 08/10/2019
 * Author : Rémy Coquard
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp.model;

import android.util.Log;

import java.util.ArrayList;

public class ListOfAllJuries {

    private static ListOfAllJuries INSTANCE;
    private static ArrayList<Jury> listOfJuries = new ArrayList<>();

    private ListOfAllJuries() {
        // Private (Cause we are making a Singleton)
    }

    public static synchronized ListOfAllJuries getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ListOfAllJuries();
        }
        return(INSTANCE);
    }

    public ArrayList<Jury> getListOfJuries() {

        return listOfJuries;
    }


    public Jury getJury(int index) {

        return listOfJuries.get(index);
    }

    public void addJury(Jury jury){

        listOfJuries.add(jury);
    }

    public boolean userExists(Jury jury){
        return listOfJuries.contains(jury);
    }

    public int userIndexExists(Jury jury){
        for (int indexExists = 0; indexExists != listOfJuries.size(); indexExists++){
            if (listOfJuries.get(indexExists) == jury){
                return indexExists;
            }
        }
        return 0;
    }
}
