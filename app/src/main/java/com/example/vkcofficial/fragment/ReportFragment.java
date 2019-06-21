package com.example.vkcofficial.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vkcofficial.R;
import com.example.vkcofficial.adapter.CompletedPOAdapter;
import com.example.vkcofficial.adapter.ReportAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReportFragment extends Fragment {

    RecyclerView rc_completed_list;
    ArrayList<String> arrayList=new ArrayList<>();
    public ReportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_report, container, false);
        rc_completed_list=v.findViewById(R.id.rc_report);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rc_completed_list.setLayoutManager(layoutManager);
        rc_completed_list.setAdapter(new ReportAdapter(arrayList,getActivity()));

        return v;
    }

}
