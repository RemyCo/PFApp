package com.example.pfapp.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pfapp.R;
import com.example.pfapp.ui.listeDesProjets.ListeDesProjetsFragment;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private final ListeDesProjetsFragment listeDesProjetsFragment;
    //TODO : changer pour le noms des projets
    private List<String> projetInformation;
    private List<Integer> positions;

    private float radius = 50;

    public RecyclerViewAdapter(ListeDesProjetsFragment listeDesProjetsFragment) {
        this.listeDesProjetsFragment = listeDesProjetsFragment;
        projetInformation = new ArrayList<>();
        projetInformation.add("TEST1");
        projetInformation.add("TEST2");
        projetInformation.add("TEST3");
        projetInformation.add("TEST4");
        projetInformation.add("TEST5");
        projetInformation.add("TEST6");
        projetInformation.add("TEST7");
        projetInformation.add("TEST8");
        projetInformation.add("TEST9");
        projetInformation.add("TEST10");
        projetInformation.add("TEST11");
        projetInformation.add("TEST12");
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
                listeDesProjetsFragment.profilDescription();
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