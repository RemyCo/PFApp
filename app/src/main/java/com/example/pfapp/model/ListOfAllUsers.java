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

public class ListOfAllUsers {

    private static ListOfAllUsers INSTANCE;
    private static ArrayList<User> listOfUsers = new ArrayList<>();

    private ListOfAllUsers() {
        // Private (Cause we are making a Singleton)
    }

    public static synchronized ListOfAllUsers getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ListOfAllUsers();
        }
        return(INSTANCE);
    }

    public ArrayList<User> getListOfUsers() {

        return listOfUsers;
    }


    public User getUser(int index) {

        return listOfUsers.get(index);
    }

    public void addUser(User user){

        listOfUsers.add(user);
    }

    public boolean userExists(User user){
        boolean exists = false;
        for (int indexExists = 0; indexExists != listOfUsers.size(); indexExists++){
            if (listOfUsers.contains(user)){
                exists = true;
            }
        }
        return exists;
    }


    public boolean userNameExists(String forename, String surname){
        Log.d("blabla", listOfUsers.size() + "");
        Log.d("blabla", forename);
        Log.d("blabla", surname);
        for (int indexExists = 0; indexExists != listOfUsers.size(); indexExists++){
            try {
                if (listOfUsers.get(indexExists).getForename().equals(forename)){
                    if (listOfUsers.get(indexExists).getSurname().equals(surname)){
                        return true;
                    }
                }
            } catch (NullPointerException e){
                Log.d("blabla","NullPointerExeption Error : " + e.getMessage());
            }
        }
        return false;
    }


    public int userNameExistIndex(String forename, String surname){
        for (int indexExists = 0; indexExists != listOfUsers.size(); indexExists++){
            try {
                Log.d("blabla", listOfUsers.get(indexExists).getForename());
                Log.d("blabla", listOfUsers.get(indexExists).getSurname());
                if (listOfUsers.get(indexExists).getForename().equals(forename)){
                    if (listOfUsers.get(indexExists).getSurname().equals(surname)){
                        return indexExists;
                    }
                }
            } catch (NullPointerException e){
                Log.d("blabla","NullPointerExeption Error : " + e.getMessage());
            }
        }
        return 0;
    }
}
