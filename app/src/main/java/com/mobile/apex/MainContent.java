package com.mobile.apex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainContent extends AppCompatActivity implements ApexAdapter.OnSubjectListener {
    private RecyclerView mRecyclerView;
    private ArrayList<ApexModel> mApexModelList;
    private  ApexAdapter mApexAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        mRecyclerView = findViewById(R.id.rv_course_content);
        mApexModelList = new ArrayList<>();
        mApexAdapter = new ApexAdapter(mApexModelList, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mApexAdapter);
        populateCardView();
    }

    private void populateCardView() {
        ApexModel model = new ApexModel("Mathematics", "0", "Indices, Geometry,Trigonometry", "14");
        mApexModelList.add(model);
    }

    @Override
    public void onSubLis(int position) {
        mApexModelList.get(position);
        Intent intent = new Intent(this, MathematicsActivity.class);
//        intent.putExtra("position", mApexModelList.get(position));
        startActivity(intent);
    }
}