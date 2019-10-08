package com.example.pfapp.model;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteDatabase;

class DatabasePFAppCallBack extends androidx.room.RoomDatabase.Callback {

    private String[] INSERT_PROJECT = {
            "INSERT INTO Countries VALUES('US','United States','English','American');",
    };

    private String[] INSERT_JURY = {
            "INSERT INTO Genres VALUES(1,'drama','Drama');",
    };

    private String[] INSERT_USER = {
            "INSERT INTO Artists VALUES(1,'COPPOLA','SOFIA',1971,'US');",
    };

    private String[] INSERT_ETUDIANT = {
            "INSERT INTO Reviewers VALUES('jeinarsson@yahoo.fr','Einarsson','Jorunn','Auvergne-Rhône-Alpes', 1987);",
    };

    private String[] INSERT_MOVIES = {
            "INSERT INTO Movies VALUES(21, 'Monty Python and the Holy Grail',1975,33,3,'Le roi Arthur et les Chevaliers de la Table Ronde se lancent à la conquête du Graal, chevauchant de fantômatiques montures dans un bruitage de noix de coco cognées. La petite troupe va devoir passer mille épreuves, dont un chevalier à trois têtes, des jouvencelles en chaleur, voire même un terrible lapin tueur.','GB');",
    };

    private String[] INSERT_SUB_GENRES = {
            "INSERT INTO Sub_Genres VALUES(6,5);",

    };

    private String[] INSERT_REVIEWS = {
            "INSERT INTO Reviews VALUES(20, 'hschmid@eseo.fr', 1023494539220,4);"
    };

    private String[] INSERT_ROLES = {
            "INSERT INTO Roles VALUES(21,286,'Arthur, King of the Britons');",
    };


    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
        super.onCreate(db);

        for (String query : INSERT_PROJECT) {
            db.execSQL(query);
        }
        for (String query : INSERT_JURY) {
            db.execSQL(query);
        }

        for (String query : INSERT_ETUDIANT) {
            db.execSQL(query);
        }

        for (String query : INSERT_USER) {
            db.execSQL(query);
        }
    }

    @Override
    public void onOpen(@NonNull SupportSQLiteDatabase db) {
        super.onOpen(db);
    }
}