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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pfapp.model.ListOfAllProjects;
import com.example.pfapp.model.Project;
import com.example.pfapp.model.RecyclerViewAdapterStudent;
import com.example.pfapp.model.Student;

import java.util.ArrayList;
import java.util.List;

public class ProjetDescriptionActivity extends AppCompatActivity {

    private Button buttonReturn;
    private Button buttonNote;
    private RecyclerViewAdapterStudent recyclerViewAdapter;
    private ListOfAllProjects listProject = ListOfAllProjects.getInstance();
    private ArrayList<Student> listStudent = new ArrayList<>();
    TextView title;
    TextView desc;
    TextView confid;
    TextView supervisor;
    String name;
    ImageView poster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projet_description);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        name = intent.getStringExtra("titleProject");

        Project myProject = listProject.getProject(listProject.projectNameIndexExists(name));
        Log.i("blabla", "Project" +myProject.getTitle());

        RecyclerView projetRecycler = (RecyclerView) findViewById(R.id.rv_listEtudiant);
        projetRecycler.setHasFixedSize(true);
        LinearLayoutManager llm = new GridLayoutManager(this,2);
        llm.setOrientation(RecyclerView.VERTICAL);
        projetRecycler.setLayoutManager(llm);

        title = (TextView) findViewById(R.id.textTitreProjet);
        title.setText(myProject.getTitle());

        desc = (TextView) findViewById(R.id.textDescriptionProjet);
        desc.setText(myProject.getDescription());

        confid = (TextView) findViewById(R.id.textConfidentialProjet);
        confid.setText(myProject.getConfid());

        supervisor = (TextView) findViewById(R.id.textSuperiviseurProjet);
        supervisor.setText(myProject.getSupervisor().getForename()+" "+myProject.getSupervisor().getSurname());

        poster = (ImageView) findViewById(R.id.poster);
        //todo : poster
        poster.setImageResource(R.drawable.eseo_couleurs);

        listStudent = myProject.getStudents();

        List<String> student = new ArrayList<>();

        for(int i = 0; i<listStudent.size();i++){
            Log.i("blabla", "Student "+listStudent.get(i).getId());
            student.add(listStudent.get(i).getSurname()+" "+listStudent.get(i).getForename());
        }

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
}
