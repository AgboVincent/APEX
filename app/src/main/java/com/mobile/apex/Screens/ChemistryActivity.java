package com.mobile.apex.Screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mobile.apex.Models.ApexTopicsModel;
import com.mobile.apex.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChemistryActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<ApexTopicsModel> mTopicsModelList;
    private  ApexChemistryAdapter mApexChemistryAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_courses); mRecyclerView = findViewById(R.id.rv_topic_content);
        Toolbar toolbar_content = findViewById( R.id.toolbar_content );
        setSupportActionBar(toolbar_content);
        Objects.requireNonNull( getSupportActionBar() ).setTitle("Chemistry");
        toolbar_content.setTitleTextColor( getResources().getColor( R.color.colorPrimaryDark ) );

        toolbar_content.setNavigationOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        } );



        mRecyclerView.setAdapter(mApexChemistryAdapter);

        mTopicsModelList = new ArrayList<>();
        mApexChemistryAdapter = new ApexChemistryAdapter(this, mTopicsModelList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mApexChemistryAdapter);
        populateCardView();

    }



    private void populateCardView() {

        ApexTopicsModel model = new ApexTopicsModel("INTRODUCTION TO CHEMISTRY", "0", 1);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("STRUCTURE OF THE ATOM", "0", 2);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("SEPARATION TECHNIQUES", "0", 3);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("CHEMICAL BONDS", "0", 4);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("STOICHIOMETRY AND CHEMICAL REACTIONS", "0", 5);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("STATES OF MATTER", "0", 6);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("ACIDS, BASES AND SALTS", "0", 7);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("CARBON AND ITS COMPOUNDS", "0", 8);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("PERIODIC CHEMISTRY", "0", 9);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("CHEMICAL KINETICS AND EQUILIBRIUM SYSTEM", "0", 10);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("THERMOCHEMISTRY", "0", 11);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("REDOX REACTIONS AND ELECTROCHEMISTRY", "0", 12);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("QUANTITATIVE ANALYSIS", "0", 13);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("QUALITATIVE ANALYSIS", "0", 14);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("AIR", "0", 15);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("WATER AND SOLUBILITY", "0", 16);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("OXYGEN AND ITS COMPOUNDS", "0", 17);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("HYDROGEN AND ITS COMPOUNDS", "0", 18);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("THE HALOGENS", "0", 19);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("NITROGEN AND ITS COMPOUNDS", "0", 20);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("SULPHUR AND ITS COMPOUNDS", "0", 21);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("ORGANIC CHEMISTRY", "0", 22);
        mTopicsModelList.add(model);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.module_menu_main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_quiz:
                startActivity(new Intent(this, QuizActivity.class).putExtra("subject_type", "chemistry"));

                break;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}