/*
 * Class DatabasePFApp
 * Version 0.2
 * 08/10/2019
 * Author : Emilien TETU
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 * 
 */package com.example.pfapp.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Project.class, User.class, Jury.class, Student.class}, exportSchema = false, version = 1)
public abstract class DatabasePFApp extends RoomDatabase {

    private static DatabasePFApp INSTANCE;

    public abstract ProjetDao projetDao();

    public abstract UserDao userDao();

    public abstract JuryDao juryDao();

    public abstract StudiantDao studiantDao();

    public static DatabasePFApp getDatabase(Context context){
        if(INSTANCE==null){
            INSTANCE = Room.databaseBuilder(context, DatabasePFApp.class, "PFApp.db")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }
}
