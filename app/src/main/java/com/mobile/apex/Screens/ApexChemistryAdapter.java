package com.mobile.apex.Screens;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobile.apex.Models.ApexTopicsModel;
import com.mobile.apex.R;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ApexChemistryAdapter extends RecyclerView.Adapter<ApexChemistryAdapter.MyViewHolder> {
    private Context mContext;
    private List<ApexTopicsModel> mApexTopicsModelList;

    public ApexChemistryAdapter(Context context, List<ApexTopicsModel> apexTopicsModelList) {
        mContext = context;
        mApexTopicsModelList = apexTopicsModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_course_modules, parent, false);

        return new ApexChemistryAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        ApexTopicsModel apexModel = mApexTopicsModelList.get(position);
        holder.topics.setText(apexModel.getTopics());
//        holder.topicsPercentage.setText(apexModel.getTopicsPercentage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = new ProgressDialog(mContext,
                        R.style.BaseTheme);
                progressDialog.setIcon( R.mipmap.ic_launcher_round );
                progressDialog.setIndeterminate(true);
                progressDialog.setTitle("Loading...");
                progressDialog.setMessage("Please wait");
                progressDialog.show();

                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {

                                progressDialog.dismiss();
                            }
                        }, 2000);
                Intent intent = new Intent(mContext, ChemistryTopicsDisplayActivity.class);
                intent.putExtra("position", position);
                mContext.startActivity(intent);
            }

        });

    }

    @Override
    public int getItemCount() {
        return mApexTopicsModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView topics, topicsPercentage;
        public CardView mCardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            topics = itemView.findViewById(R.id.topic_title);
//            topicsPercentage = itemView.findViewById(R.id.topic_percentage);
            mCardView = itemView.findViewById(R.id.card);
        }
    }
}
