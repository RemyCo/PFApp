/*
 * Class ProjetDescriptionActivity
 * Version 0.2
 * 08/10/2019
 * Author : Emilien TETU
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pfapp.model.ListOfAllProjects;
import com.example.pfapp.model.Project;
import com.example.pfapp.model.RecyclerViewAdapterStudent;

import java.util.ArrayList;
import java.util.List;

public class ProjetDescriptionActivity extends AppCompatActivity {

    private Button buttonReturn;
    private Button buttonNote;
    private RecyclerViewAdapterStudent recyclerViewAdapter;
    private ListOfAllProjects listProject = ListOfAllProjects.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projet_description);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // TODO : toolbar

        RecyclerView projetRecycler = (RecyclerView) findViewById(R.id.rv_listEtudiant);
        projetRecycler.setHasFixedSize(true);
        LinearLayoutManager llm = new GridLayoutManager(this,2);
        llm.setOrientation(RecyclerView.VERTICAL);
        projetRecycler.setLayoutManager(llm);

        List<String> student = new ArrayList<>();
        student.add("Student1");
        student.add("Student2");
        student.add("Student3");
        student.add("Student4");
        student.add("Student5");
        student.add("Student6");
        student.add("Student1");

        recyclerViewAdapter = new RecyclerViewAdapterStudent(student);
        projetRecycler.setAdapter(recyclerViewAdapter);

        buttonReturn = findViewById(R.id.buttonReturn);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                //Intent intent = new Intent(ProjetDescriptionActivity.this, MainActivity.class);
                //startActivity(intent);
            }
        });

        buttonNote = findViewById(R.id.buttonNote);
        buttonNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProjetDescriptionActivity.this, NoteActivity.class);
                startActivity(intent);
            }
        });
    }

    private void sever(String name){
        Project myProject = listProject.getProject(listProject.projectNameIndexExists(name));
    }
}
