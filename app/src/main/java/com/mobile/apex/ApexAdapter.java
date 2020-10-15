package com.mobile.apex;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ApexAdapter extends RecyclerView.Adapter<ApexAdapter.MyViewHolder>  {
//    private Context mContext;
    private ArrayList<ApexModel> mApexModelList;
    private OnSubjectListener mOnSubjectListener;


    public ApexAdapter(ArrayList<ApexModel> apexModelList, OnSubjectListener onSubjectListener) {
        mApexModelList = apexModelList;
        mOnSubjectListener = onSubjectListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_row_home, parent, false);

        return new MyViewHolder(itemView, mOnSubjectListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        ApexModel apexModel = mApexModelList.get(position);
        holder.subject.setText(apexModel.getSubject());
        holder.topics.setText(apexModel.getTopics());
        holder.percentage.setText(apexModel.getPercentage());
        holder.numOfModules.setText(apexModel.getNumOfModules());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                 Intent intent;
//                switch (position){
//                    case 0:
//                        intent = new Intent(mContext, MathematicsActivity.class);
//
//                        break;
//                    default:
//                        throw new IllegalStateException("Unexpected value: " + position);
//                }
//                mContext.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return mApexModelList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView subject, percentage, topics, numOfModules;
        OnSubjectListener mOnSubjectListener;

        public MyViewHolder(@NonNull View itemView, OnSubjectListener onSubjectListener) {
            super(itemView);
//            mContext = itemView.getContext();
            this.mOnSubjectListener = onSubjectListener;
            //Initialize the views
            subject = itemView.findViewById(R.id.course_title);
            topics = itemView.findViewById(R.id.course_description);
            percentage = itemView.findViewById(R.id.course_percentage);
            numOfModules = itemView.findViewById(R.id.module_count);

            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
           mOnSubjectListener.onSubLis(getAdapterPosition());
        }
    }
    public interface OnSubjectListener{
        void onSubLis(int position);
    }
}
