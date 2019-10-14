/*
 * Class ListeDesProjetsFragment
 * Version 0.2
 * 08/10/2019
 * Author : Emilien TETU
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp.ui.listeDesProjets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pfapp.MainActivity;
import com.example.pfapp.R;
import com.example.pfapp.model.RecyclerViewAdapter;

import java.util.ArrayList;

public class ListeDesProjetsFragment extends Fragment {

    private ShareViewModel shareViewModel;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<String> projetInformation = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                ViewModelProviders.of(this).get(ShareViewModel.class);
        View root = inflater.inflate(R.layout.fragment_liste_des_projets, container, false);
        RecyclerView projetRecycler = (RecyclerView) root.findViewById(R.id.rv_projetList);
        projetRecycler.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(RecyclerView.VERTICAL);
        projetRecycler.setLayoutManager(llm);

        //TODO : ajouter la liste des projets "List Project"

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

        recyclerViewAdapter = new RecyclerViewAdapter(projetInformation, (MainActivity) getActivity());
        projetRecycler.setAdapter(recyclerViewAdapter);
        return root;
    }
}