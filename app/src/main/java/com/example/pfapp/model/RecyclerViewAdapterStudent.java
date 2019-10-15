/*
 * Class RecyclerViewAdapterStudent
 * Version 0.2
 * 08/10/2019
 * Author : Emilien TETU
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pfapp.ProjetDescriptionActivity;
import com.example.pfapp.R;

import java.util.List;

public class RecyclerViewAdapterStudent extends RecyclerView.Adapter<RecyclerViewAdapterStudent.RecyclerViewHolder> {

    //TODO : changer pour le noms des projets
    private List<String> student;
    private ProjetDescriptionActivity projetDescriptionActivity;

    private float radius = 20;

    public RecyclerViewAdapterStudent(List<String> student, ProjetDescriptionActivity main) {
        this.student = student;
        this.projetDescriptionActivity = main;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View projetView = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_card_view,parent,false);
        ((CardView)projetView).setRadius(radius);
        return new RecyclerViewHolder(projetView);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, final int position) {
        holder.NameStudent.setText(student.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                projetDescriptionActivity.noteStudent(student.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return student.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private final TextView NameStudent;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            NameStudent = itemView.findViewById(R.id.textNom);
        }
    }
}