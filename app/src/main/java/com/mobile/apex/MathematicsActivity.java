package com.mobile.apex;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MathematicsActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<ApexTopicsModel>mTopicsModelList;
    private  ApexMathematicsAdapter mApexMathematicsAdapter;

//    public static final int REQUEST_PERMISSION = 1;
//    File folder;

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

//        permission();

        mRecyclerView.setAdapter(mApexMathematicsAdapter);
       // mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        mTopicsModelList = new ArrayList<>();
        mApexMathematicsAdapter = new ApexMathematicsAdapter(this, mTopicsModelList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mApexMathematicsAdapter);
        populateCardView();

    }



    private void populateCardView() {

        ApexTopicsModel model = new ApexTopicsModel("Number Bases", "0", 1);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("Fractions, Decimals and Approximation", "0", 2);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("Indices and Logarithm", "0", 3);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("Series and Sequence", "0", 4);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("Set theory", "0", 5);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("Surds", "0", 6);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("Matrices", "0", 7);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("Variation", "0", 8);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("Algebra", "0", 9);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("Mensuration", "0", 10);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("Trigonometry", "0", 11);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("Calculus", "0", 12);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("Statistics", "0", 13);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("Probability", "0", 14);
        mTopicsModelList.add(model);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}