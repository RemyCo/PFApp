/*
 * Class RecyclerViewAdapter
 * Version 0.2
 * 08/10/2019
 * Author : Emilien TETU
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp.model;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pfapp.R;
import com.example.pfapp.VisitorActivity;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapterVisiteur extends RecyclerView.Adapter<RecyclerViewAdapterVisiteur.RecyclerViewHolder> {

    private VisitorActivity visitorActivity;
    private List<String> projetInformation;
    private List<Integer> positions;

    private float radius = 50;

    public RecyclerViewAdapterVisiteur(ArrayList<String> array, VisitorActivity main) {
        this.visitorActivity = main;
        this.projetInformation = array;
        positions = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View projetView = LayoutInflater.from(parent.getContext()).inflate(R.layout.projet_card_view,parent,false);
        ((CardView)projetView).setRadius(radius);
        return new RecyclerViewHolder(projetView);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, final int position) {
        holder.projetTitre.setText(projetInformation.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("blabla", "onClick: "+projetInformation.get(position));
                visitorActivity.profilDescription(projetInformation.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return projetInformation.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private final TextView projetTitre;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            projetTitre = itemView.findViewById(R.id.projet_titre);
        }
    }
}