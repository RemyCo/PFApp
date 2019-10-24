/*
 * Class RecyclerViewAdapterAgenda
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

import com.example.pfapp.R;

import java.util.ArrayList;

public class RecyclerViewAdapterAgenda extends RecyclerView.Adapter<RecyclerViewAdapterAgenda.RecyclerViewHolder> {

    private ArrayList<String> projects;
    private ArrayList<String> dateOfProject;

    private float radius = 5;

    public RecyclerViewAdapterAgenda(ArrayList<String> projects, ArrayList<String> date) {
        this.projects = projects;
        this.dateOfProject = date;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View projetView = LayoutInflater.from(parent.getContext()).inflate(R.layout.agenda_card_view,parent,false);
        ((CardView)projetView).setRadius(radius);
        return new RecyclerViewHolder(projetView);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, final int position) {
        holder.nameProject.setText(projects.get(position));
        holder.dateProject.setText(dateOfProject.get(position));
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private final TextView dateProject;
        private final TextView nameProject;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            nameProject = itemView.findViewById(R.id.title_project);
            dateProject = itemView.findViewById(R.id.txt_date);
        }
    }
}