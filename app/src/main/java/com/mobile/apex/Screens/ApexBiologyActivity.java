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

public class ApexBiologyActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<ApexTopicsModel> mTopicsModelList;
    private  ApexBiologyAdapter mApexBiologyAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_courses);
        mRecyclerView = findViewById(R.id.rv_topic_content);
        Toolbar toolbar_content = findViewById( R.id.toolbar_content );
        setSupportActionBar(toolbar_content);
        Objects.requireNonNull( getSupportActionBar() ).setTitle("Biology");
        toolbar_content.setTitleTextColor( getResources().getColor( R.color.colorPrimaryDark ) );

        toolbar_content.setNavigationOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        } );



        mRecyclerView.setAdapter(mApexBiologyAdapter);

        mTopicsModelList = new ArrayList<>();
        mApexBiologyAdapter = new ApexBiologyAdapter(this, mTopicsModelList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mApexBiologyAdapter);
        populateCardView();

    }



    private void populateCardView() {

        ApexTopicsModel model = new ApexTopicsModel("CLASSIFICATION(INTRODUCTION)", "0", 1);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("KINGDOM PLANTAE AND ANIMALIA", "0", 2);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("ORGANIZATION OF LIFE", "0", 3);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("THE CELL", "0", 4);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("OSMOSIS, DIFFUSION AND ACTIVE TRANSPORT", "0", 5);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("SUPPORTING TISSUES IN PLANTS", "0", 6);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("SUPPORTING TISSUES IN ANIMALS", "0", 7);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("TRANSPORT SYSTEM IN PLANTS", "0", 8);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("TRANSPORT SYSTEM IN ANIMALS", "0", 9);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("RESPIRATION IN PLANTS", "0", 10);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("RESPIRATION IN ANIMALS", "0", 11);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("EXCRETION", "0", 12);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("HOMEOSTASIS", "0", 13);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("NERVOUS COORDINATION", "0", 14);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("SENSE ORGANS", "0", 15);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("REPRODUCTIVE SYSTEM", "0", 16);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("NUTRITION IN PLANTS", "0", 17);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("NUTRITION IN ANIMALS", "0", 18);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("MICROORGANISMS", "0", 19);
        mTopicsModelList.add(model);
        model = new ApexTopicsModel("HEREDITY AND EVOLUTION", "0", 20);
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
                startActivity(new Intent(this, QuizActivity.class).putExtra("subject_type", "biology"));
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}