package com.example.pfapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pfapp.model.RecyclerViewAdapterVisiteur;

import java.util.ArrayList;

public class VisitorActivity extends AppCompatActivity {

    private RecyclerViewAdapterVisiteur recyclerViewAdapter;
    private ArrayList<String> projetInformation = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor);

        RecyclerView projetRecycler = (RecyclerView) findViewById(R.id.rv_projetListVisitor);
        projetRecycler.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        projetRecycler.setLayoutManager(llm);

        projetInformation.add("PROJET_1");
        projetInformation.add("PROJET_2");
        projetInformation.add("PROJET_3");
        projetInformation.add("PROJET_4");

        recyclerViewAdapter = new RecyclerViewAdapterVisiteur(projetInformation, this);
        projetRecycler.setAdapter(recyclerViewAdapter);
    }

    public void profilDescription(String nameProject){
        Intent intent = new Intent(this, ProjetDescriptionActivity.class);
        intent.putExtra("titleProject",nameProject);
        startActivity(intent);
    }
}
