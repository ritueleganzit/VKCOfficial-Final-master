package com.example.vkcofficial.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vkcofficial.CompletedPOActivity;
import com.example.vkcofficial.R;
import com.example.vkcofficial.adapter.CompletedPOAdapter;
import com.example.vkcofficial.adapter.NotificationAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {
    ArrayList<String> arrayList=new ArrayList<>();

RecyclerView  rc_notification;
    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_notification, container, false);
        rc_notification=v.findViewById(R.id.rc_notification);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rc_notification.setLayoutManager(layoutManager);
        rc_notification.setAdapter(new NotificationAdapter(arrayList,getActivity()));
        return v;
    }

}
