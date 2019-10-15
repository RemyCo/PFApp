/*
 * Class MesProjetsFragment
 * Version 0.2
 * 08/10/2019
 * Author : Emilien TETU
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp.ui.mesProjets;

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
import com.example.pfapp.model.RequestsClass.MYPRJ;

import java.util.ArrayList;

public class MesProjetsFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<String> projetInformation = new ArrayList<>();
    private MYPRJ myProjects = MYPRJ.getInstance();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_mes_projets, container, false);
        RecyclerView projetRecycler = (RecyclerView) root.findViewById(R.id.rv_mesProjet);
        projetRecycler.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(RecyclerView.VERTICAL);
        projetRecycler.setLayoutManager(llm);

        for (int i=0; i<myProjects.getListOfProjects().size(); i++){
            projetInformation.add(myProjects.getProject(i).getTitle());
        }

        recyclerViewAdapter = new RecyclerViewAdapter(projetInformation, (MainActivity) getActivity());
        projetRecycler.setAdapter(recyclerViewAdapter);
        return root;
    }
}