package com.example.vkcofficial.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.vkcofficial.HomeActivity;
import com.example.vkcofficial.LoginActivity;
import com.example.vkcofficial.R;
import com.example.vkcofficial.adapter.PendingPOAdapter;
import com.example.vkcofficial.api.RetrofitAPI;
import com.example.vkcofficial.api.RetrofitInterface;
import com.example.vkcofficial.model.PendingPOResponse;
import com.example.vkcofficial.util.UserLoggedInSession;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class PendingPOFragment extends Fragment {
    LinearLayout lin_nodata;
    ArrayList<String> arrayList=new ArrayList<>();
    ProgressDialog progressDialog;
    UserLoggedInSession userLoggedInSession;
    RecyclerView rc_plan;
    public PendingPOFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_pending_po, container, false);
        rc_plan=v.findViewById(R.id.rc_pendingpo);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rc_plan.setLayoutManager(layoutManager);
        lin_nodata=v.findViewById(R.id.lin_nodata);
        userLoggedInSession=new UserLoggedInSession(getActivity());
        progressDialog=new ProgressDialog(getActivity());
        progressDialog.setMessage("Please Wait");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
       getPendingPO();
        return v;
    }

    private void getPendingPO() {
        progressDialog.show();
        RetrofitInterface myInterface = RetrofitAPI.getRetrofit().create(RetrofitInterface.class);
        Call<PendingPOResponse> call=myInterface.pendingPO("");
        call.enqueue(new Callback<PendingPOResponse>() {
            @Override
            public void onResponse(Call<PendingPOResponse> call, Response<PendingPOResponse> response) {
                if (response.isSuccessful())
                {
                    progressDialog.dismiss();
                    if (response.body().getData()!=null)
                    {
                        lin_nodata.setVisibility(View.GONE);
                        rc_plan.setVisibility(View.VISIBLE);
                        rc_plan.setAdapter(new PendingPOAdapter(response.body().getData(),getActivity()));

                    }
                    else
                    {
                        lin_nodata.setVisibility(View.VISIBLE);
                        rc_plan.setVisibility(View.GONE);
                    }
                }
                else
                {
                    lin_nodata.setVisibility(View.VISIBLE);
                    rc_plan.setVisibility(View.GONE);
                }

            }

            @Override
            public void onFailure(Call<PendingPOResponse> call, Throwable t) {
                progressDialog.dismiss();
                lin_nodata.setVisibility(View.VISIBLE);
                rc_plan.setVisibility(View.GONE);
                Toast.makeText(getActivity(), "Server or Internet Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        HomeActivity.textTitle.setText("PENDING PO");

    }
}
