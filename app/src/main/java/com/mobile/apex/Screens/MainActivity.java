package com.mobile.apex.Screens;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;

import com.mobile.apex.ApexAdapter;
import com.mobile.apex.Models.ApexModel;
import com.mobile.apex.R;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements ApexAdapter.OnSubjectListener {

    private RecyclerView mRecyclerView;
    private ArrayList<ApexModel> mApexModelList;
    private  ApexAdapter mApexAdapter;
    Toast toast;
    boolean doubleBackToExit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Toolbar toolbar = findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );
        Objects.requireNonNull( getSupportActionBar() ).setTitle("Home");
        toolbar.setTitleTextColor( getResources().getColor(R.color.white ));
        mRecyclerView = findViewById(R.id.rv_course_content);
        mApexModelList = new ArrayList<>();
        mApexAdapter = new ApexAdapter(mApexModelList, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mApexAdapter);

        populateCardView();
//        toast.myToast( "Welcome", this );


    }

    private void populateCardView() {
        ApexModel model = new ApexModel("Mathematics", "0" + "%", "Indices, Geometry,Trigonometry", "14" + " modules", 1);
        mApexModelList.add(model);
        model = new ApexModel("Chemistry", "0" + "%", "Introduction to chemistry, Structure of the atom, Separation techniques", "22" + " modules" , 2);
        mApexModelList.add(model);
        model = new ApexModel("Biology", "0" + "%", "Classification, Organization of life", "20" + " modules" , 3);
        mApexModelList.add(model);
        model = new ApexModel("Physics", "0" + "%", "Concept of matter, Fundamental and derived quantities", "23" + " modules" , 4);
        mApexModelList.add(model);
    }

    @Override
    public void onSubLis(int position) {
        mApexModelList.get(position);
        Intent intent = null;
        switch(position){
            case 0:
                intent = new Intent(this, MathematicsActivity.class);
                break;
            case 1:
                intent = new Intent(this, ChemistryActivity.class);
                break;
            case 2:
                intent = new Intent (this, ApexBiologyActivity.class);
                break;
            case 3:
                intent = new Intent(this, ApexPhysicsActivity.class);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }


        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.menu_main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:
                about();
                break;
            case R.id.action_quiz:
                selectQuizSubject();
                break;
            case R.id.other_quizes:
                selectOtherQuizSubject();
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    private void about() {

        new android.app.AlertDialog.Builder(this)
                .setTitle(R.string.about)
                .setMessage(R.string.about_content)
                .setPositiveButton("Back", (dialog, which) -> {
                    //Dismiss and go home
                    dialog.dismiss();
                }).setCancelable(false).show();

    }


    private void exit() {
        new android.app.AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton( "Yes", (dialog, which) -> {
                    dialog.dismiss();
                } )
                .setPositiveButton("Back", (dialog, which) -> {
                    //Dismiss and exit
                    dialog.dismiss();
                    finishAffinity();
                }).setCancelable(false).show();
    }

    @Override
    public void onBackPressed() {
        exit();
        if (doubleBackToExit){
            super.onBackPressed();
            return;
        }
        this.doubleBackToExit = true;
//        Toast.makeText( this, "Click back again to exit", Toast.LENGTH_SHORT ).show();
        new Handler( ).postDelayed( new Runnable() {
            @Override
            public void run() {
                doubleBackToExit = false;
            }
        }, 2000 );
    }

    public void selectQuizSubject(){
        String[] subjects = new String[]{"Mathematics", "Physics", "Biology", "Chemistry"};

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Select Quiz Subject")
                .setSingleChoiceItems(subjects, -1, (dialog, which) -> {
                    switch (which){
                        case 0:
                            startActivity(new Intent(this, QuizActivity.class).putExtra("subject_type", "mathematics"));
                            break;
                        case 1:
                            startActivity(new Intent(this, QuizActivity.class).putExtra("subject_type", "physics"));
                            break;
                        case 2:
                            startActivity(new Intent(this, QuizActivity.class).putExtra("subject_type", "biology"));
                            break;
                        case 3:
                            startActivity(new Intent(this, QuizActivity.class).putExtra("subject_type", "chemistry"));
                            break;
                    }
                    dialog.dismiss();
                });
        AlertDialog dialog = builder.create();
        dialog.show();

    }
    public void selectOtherQuizSubject(){
        String[] subjects = new String[]{"English", "Government", "Economics", "Geopraphy", "History", "Accounting", "Insurance"};

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Select Quiz Subject")
                .setSingleChoiceItems(subjects, -1, (dialog, which) -> {
                    switch (which){
                        case 0:
                            startActivity(new Intent(this, QuizActivity.class).putExtra("subject_type", "english"));
                            break;
                        case 1:
                            startActivity(new Intent(this, QuizActivity.class).putExtra("subject_type", "government"));
                            break;
                        case 2:
                            startActivity(new Intent(this, QuizActivity.class).putExtra("subject_type", "economics"));
                            break;
                        case 3:
                            startActivity(new Intent(this, QuizActivity.class).putExtra("subject_type", "geography"));
                            break;
                        case 4:
                            startActivity(new Intent(this, QuizActivity.class).putExtra("subject_type", "history"));
                            break;
                        case 5:
                            startActivity(new Intent(this, QuizActivity.class).putExtra("subject_type", "accounting"));
                            break;
                        case 6:
                            startActivity(new Intent(this, QuizActivity.class).putExtra("subject_type", "insurance"));
                            break;

                    }
                    dialog.dismiss();
                });
        AlertDialog dialog = builder.create();
        dialog.show();

    }

}