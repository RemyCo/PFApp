/*
 * Class AgendaFragment
 * Version 0.2
 * 08/10/2019
 * Author : Emilien TETU
 * Copyright CCBY 4.0 https://creativecommons.org/licenses/by/4.0/
 */

package com.example.pfapp.ui.agenda;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pfapp.R;
import com.example.pfapp.model.RecyclerViewAdapterAgenda;

import java.util.ArrayList;

public class AgendaFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private RecyclerViewAdapterAgenda recyclerViewAdapter;
    private ArrayList<String> projetInformation = new ArrayList<>();
    private ArrayList<String> date = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_agenda, container, false);

        RecyclerView projetRecycler = (RecyclerView) root.findViewById(R.id.rv_agenda);
        projetRecycler.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(RecyclerView.VERTICAL);
        projetRecycler.setLayoutManager(llm);

        //TODO : ajouter dans l'agenda la date et le nom de du projet"

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

        date.add("4");
        date.add("5");
        date.add("6");
        date.add("7");
        date.add("9");
        date.add("13");
        date.add("13");
        date.add("14");
        date.add("15");
        date.add("17");
        date.add("20");
        date.add("22");

        recyclerViewAdapter = new RecyclerViewAdapterAgenda(projetInformation, date);
        projetRecycler.setAdapter(recyclerViewAdapter);
        return root;
    }
}