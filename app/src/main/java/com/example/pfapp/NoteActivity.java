package com.example.pfapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NoteActivity extends AppCompatActivity {

    Button buttonNoteValide;
    Button buttonReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);


        buttonNoteValide = findViewById(R.id.buttonValide);
        buttonNoteValide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO : requette pour la sauvegarde de la note
                Intent intent = new Intent(NoteActivity.this, ProjetDescriptionActivity.class);
                startActivity(intent);
            }
        });

        buttonReturn = findViewById(R.id.buttonReturnNote);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NoteActivity.this, ProjetDescriptionActivity.class);
                startActivity(intent);
            }
        });
    }
}
