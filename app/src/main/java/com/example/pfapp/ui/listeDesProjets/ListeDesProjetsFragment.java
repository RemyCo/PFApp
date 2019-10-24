/*
 * Class ListeDesProjetsFragment
 * Version 0.2
 * 08/10/2019
 * Author : Emilien TETU
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp.ui.listeDesProjets;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pfapp.ICallback;
import com.example.pfapp.ProjetDescriptionActivity;
import com.example.pfapp.R;
import com.example.pfapp.model.ListOfAllProjects;
import com.example.pfapp.model.Project;
import com.example.pfapp.model.RecyclerViewAdapter;

import java.util.ArrayList;

public class ListeDesProjetsFragment extends Fragment implements ICallback {

    private ShareViewModel shareViewModel;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<String> projetInformation = new ArrayList<>();
    private ArrayList<Project> ListOfProject = ListOfAllProjects.getInstance().getListOfProjects();

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

        for (int i = 0; i < ListOfProject.size(); i++) {
            projetInformation.add(ListOfProject.get(i).getTitle());
        }

        recyclerViewAdapter = new RecyclerViewAdapter(projetInformation, this);
        projetRecycler.setAdapter(recyclerViewAdapter);
        return root;
    }

    @Override
    public void callback(String nameProject) {
        Intent intent = new Intent(getActivity(), ProjetDescriptionActivity.class);
        intent.putExtra("titleProject",nameProject);
        startActivity(intent);
    }
}