package com.mobile.apex.Screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.mobile.apex.ApexPhysicsAdapter;
import com.mobile.apex.Models.ApexTopicsModel;
import com.mobile.apex.R;

import java.util.ArrayList;
import java.util.List;

public class ApexPhysicsActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<ApexTopicsModel> mTopicsModelList;
    private ApexPhysicsAdapter mApexPhysicsAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_courses);
        mRecyclerView = findViewById(R.id.rv_topic_content);
        Toolbar toolbar_content = findViewById( R.id.toolbar_content );
        setSupportActionBar(toolbar_content);
        toolbar_content.setTitleTextColor( getResources().getColor( R.color.colorPrimaryDark ) );

        toolbar_content.setNavigationOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        } );



        mRecyclerView.setAdapter(mApexPhysicsAdapter);

        mTopicsModelList = new ArrayList<>();
        mApexPhysicsAdapter = new ApexPhysicsAdapter(this, mTopicsModelList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mApexPhysicsAdapter);
        populateCardView();

    }



    private void populateCardView() {

        ApexTopicsModel model = new ApexTopicsModel("CONCEPT OF MATTER", "0", 1);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("QUANTITIES AND UNITS", "0", 2);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("POSITION, DISTANCE AND DISPLACEMENT", "0", 3);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("FLUID AT REST", "0", 4);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("VOLUME, DENSITY AND RELATIVE DENSITY", "0", 5);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("ARCHIMEDES'S PRINCIPLE", "0", 6);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("LAW OF FLOATATION", "0", 7);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("MOTION", "0", 8);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("TYPES OF MOTION", "0", 9);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("SPEED AND VELOCITY", "0", 10);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("ACCELERATION", "0", 11);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("CIRCULAR MOTION", "0", 12);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("SCALARS AND VECTORS", "0", 13);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("EQUILIBRIUM OF FORCES", "0", 14);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("SIMPLE HARMONIC MOTION", "0", 15);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("NEWTON'S LAW OF MOTION", "0", 16);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("ENERGY AND FORMS OF ENERGY", "0", 17);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("MECHANICAL ENERGY", "0", 18);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("KINETIC ENERGY", "0", 19);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("CONSERVATION OF MECHANICAL ENERGY", "0", 20);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("CONCEPT OF POWER", "0", 21);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("HEAT ENERGY", "0", 22);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("HEAT TRANSFER", "0", 23);
        mTopicsModelList.add(model);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



}