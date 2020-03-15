package com.example.hahahoho;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;



public class fragment_menu1 extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu1, container, false);
        ListView listview = view.findViewById(R.id.listView);
        MyAdapter listViewAdatper = new MyAdapter();
        listViewAdatper.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.logo), "11", "11");
        listViewAdatper.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.logo), "22", "22");
        listViewAdatper.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.logo), "33", "33");
        listViewAdatper.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.logo), "44", "44");

        listview.setAdapter(listViewAdatper);

        return view;
    }

}


