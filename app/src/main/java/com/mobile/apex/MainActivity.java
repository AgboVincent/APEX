package com.mobile.apex;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

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
import android.widget.ImageButton;

import java.util.ArrayList;

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
        ApexModel model = new ApexModel("Mathematics", "0" + "%", "Indices, Geometry,Trigonometry", "14" + " modules");
        mApexModelList.add(model);
    }

    @Override
    public void onSubLis(int position) {
        mApexModelList.get(position);
        Intent intent = new Intent(this, MathematicsActivity.class);
//        intent.putExtra("position", mApexModelList.get(position));
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

                break;
            case R.id.action_review:
                /*Intent intent = new Intent( this, MainContent.class );
                startActivity( intent );*/
                break;
        }
        return super.onOptionsItemSelected(item);

    }


    private void exit() {
        //Alert Dialog
        Rect displayRectangle = new Rect();
        Window window = MainActivity.this.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(displayRectangle);
        final AlertDialog.Builder builder = new AlertDialog.Builder(
                MainActivity.this, R.style.CustomDialog);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View view = LayoutInflater
                .from(MainActivity.this)
                .inflate(R.layout.exit_dialog, viewGroup, false);

        view.setMinimumWidth((int) (displayRectangle.width() * 1f));
        builder.setView(view);

        builder.setIcon( R.mipmap.ic_launcher_round );
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        final ImageButton exitDialog = view.findViewById(R.id.exit_cancel);
        ImageButton exitButton = view.findViewById(R.id.exit_btn);

        exitDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                finishAffinity();
            }
        });

    }
    @Override
    public void onBackPressed() {
        exit();
        if (doubleBackToExit){
            super.onBackPressed();
            return;
        }
        this.doubleBackToExit = true;
        Toast.makeText( this, "Click back again to exit", Toast.LENGTH_SHORT ).show();
        new Handler( ).postDelayed( new Runnable() {
            @Override
            public void run() {
                doubleBackToExit = false;
            }
        }, 2000 );
    }

}