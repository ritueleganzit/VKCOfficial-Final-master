package com.example.vkcofficial.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.vkcofficial.GalleryActivity;
import com.example.vkcofficial.PendingPODetail;
import com.example.vkcofficial.R;
import com.example.vkcofficial.adapter.PendingPOAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewDefectsFragment extends Fragment {

    ArrayList<String> arrayList=new ArrayList<>();

    RecyclerView rc_view_defects;
    LinearLayout viewdefectslin;
    public ViewDefectsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_view_defects, container, false);
        rc_view_defects=v.findViewById(R.id.rc_view_defects);
        viewdefectslin=v.findViewById(R.id.viewdefectslin);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rc_view_defects.setLayoutManager(layoutManager);
        rc_view_defects.setAdapter(new ViewDefectsAdapter(arrayList,getActivity()));
        viewdefectslin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), GalleryActivity.class));
            }
        });
        return v;
    }

    public static class ViewDefectsAdapter extends RecyclerView.Adapter<ViewDefectsAdapter.MyViewHolder> {

        ArrayList<String> campaigns;
        Context context;
        Activity activity;

        public ViewDefectsAdapter(ArrayList<String> campaigns, Context context) {
            this.campaigns = campaigns;
            this.context = context;
            activity = (Activity) context;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_view_defects, viewGroup, false);
            MyViewHolder myViewHolder = new MyViewHolder(v);

            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull final MyViewHolder holder, final int i) {


        }

        @Override
        public int getItemCount() {
            return 3;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

            }
        }
    }



}
