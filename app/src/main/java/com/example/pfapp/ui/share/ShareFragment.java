package com.example.pfapp.ui.share;

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

import com.example.pfapp.R;
import com.example.pfapp.model.ProjetDescription;
import com.example.pfapp.model.RecyclerViewAdapter;

public class ShareFragment extends Fragment {

    private ShareViewModel shareViewModel;
    private RecyclerViewAdapter recyclerViewAdapter;

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
        recyclerViewAdapter = new RecyclerViewAdapter(this);
        projetRecycler.setAdapter(recyclerViewAdapter);
        return root;
    }

    public void profilDescription(){
        Intent intent = new Intent(getActivity(), ProjetDescription.class);
        startActivity(intent);
    }
}