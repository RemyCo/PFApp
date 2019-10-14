/*
 * Class ListOfAllUsers
 * Version 0.2
 * 08/10/2019
 * Author : Rémy Coquard
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp.model;

import java.util.ArrayList;

public class ListOfAllUsers {

    private static ArrayList<User> listOfUsers;

    public ListOfAllUsers(ArrayList<User> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    public void setListOfUsers(ArrayList<User> listOfUsers) {
        this.listOfUsers = listOfUsers;
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
        boolean exists = false;
        for (int indexExists = 0; indexExists != listOfUsers.size(); indexExists++){
            if (listOfUsers.get(indexExists).getForename() == forename){
                if (listOfUsers.get(indexExists).getSurname() == surname){
                    exists = true;
                }
            }
        }
        return exists;
    }


    public int userNameExistIndex(String forename, String surname){
        int index = 0;
        for (int indexExists = 0; indexExists != listOfUsers.size(); indexExists++){
            if (listOfUsers.get(indexExists).getForename() == forename){
                if (listOfUsers.get(indexExists).getSurname() == surname){
                    index = indexExists;
                }
            }
        }
        return index;
    }
}
