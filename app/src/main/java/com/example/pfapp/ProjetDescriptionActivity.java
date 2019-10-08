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

import com.example.pfapp.model.RecyclerViewAdapterStudent;

import java.util.ArrayList;
import java.util.List;

public class ProjetDescriptionActivity extends AppCompatActivity {

    private Button buttonReturn;
    private RecyclerViewAdapterStudent recyclerViewAdapter;

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
                Intent intent = new Intent(ProjetDescriptionActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
