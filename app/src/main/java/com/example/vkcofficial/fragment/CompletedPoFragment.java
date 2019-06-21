package com.example.vkcofficial.fragment;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;


import com.example.vkcofficial.HomeActivity;
import com.example.vkcofficial.R;
import com.example.vkcofficial.adapter.CompletedPOAdapter;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompletedPoFragment extends Fragment {

RecyclerView rc_completed_list;
ArrayList<String> arrayList=new ArrayList<>();
    public CompletedPoFragment() {
        // Required empty public constructor
    }
    TextInputEditText edstartDate,edenddate;

int mYear,mMonth,mDay;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v=inflater.inflate(R.layout.fragment_completed_po, container, false);
        rc_completed_list=v.findViewById(R.id.rc_completed_list);
        edstartDate=v.findViewById(R.id.edstartdate);
        edenddate=v.findViewById(R.id.edenddate);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rc_completed_list.setLayoutManager(layoutManager);
        rc_completed_list.setAdapter(new CompletedPOAdapter(arrayList,getActivity()));

        edstartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }

        }); edenddate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }

        });

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        HomeActivity.textTitle.setText("COMPLETED PO");

    }
}
