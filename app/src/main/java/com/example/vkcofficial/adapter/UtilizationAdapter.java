package com.example.vkcofficial.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vkcofficial.R;
import com.example.vkcofficial.model.Report;

import java.util.List;

public class UtilizationAdapter extends RecyclerView.Adapter<UtilizationAdapter.MyViewHolder> {

   List<Report> campaigns;
    Context context;
    Activity activity;

    public UtilizationAdapter(List<Report> campaigns, Context context) {
        this.campaigns = campaigns;
        this.context = context;
        activity = (Activity) context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.utilization,viewGroup,false);
        MyViewHolder myViewHolder=new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int i) {

        Report pNumber=campaigns.get(i);
        int p=i+1;
        holder.srno.setText(""+p);
        holder.inputQty.setText(""+pNumber.getCapacity());
        holder.outputQty.setText(""+pNumber.getExp());
        holder.month.setText(""+pNumber.getInputpair());
        holder.utilization.setText(""+pNumber.getUtilization());

    }

    @Override
    public int getItemCount() {
        return campaigns.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
TextView srno,inputQty,outputQty,month,utilization;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            srno=itemView.findViewById(R.id.srno);
            inputQty=itemView.findViewById(R.id.inputQty);
            outputQty=itemView.findViewById(R.id.outputQty);
            month=itemView.findViewById(R.id.month);
            utilization=itemView.findViewById(R.id.utilization);


        }
    }
}
