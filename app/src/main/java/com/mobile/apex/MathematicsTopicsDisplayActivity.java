package com.mobile.apex;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.core.widget.NestedScrollView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.github.barteksc.pdfviewer.scroll.ScrollHandle;

import java.util.Objects;

public class MathematicsTopicsDisplayActivity extends AppCompatActivity {
    PDFView mPDFView;
    int position = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.courses_lesson);

        ConnectivityManager cm = (ConnectivityManager) this.getSystemService( Context.CONNECTIVITY_SERVICE );
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) {

        } else {
            Intent i = new Intent( this, NoItemInternetImage.class );
            startActivity( i );
        }

        Toolbar toolbar_lesson_content = findViewById( R.id.toolbar_lesson_content );
        setSupportActionBar(toolbar_lesson_content);
        Objects.requireNonNull( getSupportActionBar() ).setDisplayHomeAsUpEnabled( true );
        Objects.requireNonNull( getSupportActionBar() ).setDisplayShowHomeEnabled( true );
        toolbar_lesson_content.setTitleTextColor( getResources().getColor( R.color.white) );
        mPDFView = findViewById(R.id.pdfView);
        position = getIntent().getIntExtra("position", -1);
        viewPdf();





        toolbar_lesson_content.setNavigationOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        } );

    }

    public void attachFromUri(Uri uri) {
        Uri uriParse = uri;
        mPDFView.fromUri( Uri.parse( String.valueOf( uriParse ) ) ).enableDoubletap( true ).enableSwipe(true).enableDoubletap( true )
                .enableAnnotationRendering( false )
                .enableAntialiasing( true ).spacing( 0 ).onRender( new OnRenderListener() {
            @Override
            public void onInitiallyRendered(int nbPages, float pageWidth, float pageHeight) {
                mPDFView.fitToWidth();
                mPDFView.documentFitsView();
                mPDFView.setSwipeVertical( true );
            }
        } ).onPageChange( new OnPageChangeListener() {
            @Override
            public void onPageChanged(int page, int pageCount) {
                mPDFView.setSwipeVertical( true );
                mPDFView.canScrollVertically( pageCount );
            }
        } ).onLoad( new OnLoadCompleteListener() {
            @Override
            public void loadComplete(int nbPages) {
                final ProgressDialog progressDialog = new ProgressDialog(MathematicsTopicsDisplayActivity.this,
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
                        }, 3000);
            }
        } ).load();
    }

    public void attachFromAssets(String string) {
        String asset = string;
        mPDFView.fromAsset( asset ).enableDoubletap( true ).enableSwipe(true).enableDoubletap( true )
                .enableAnnotationRendering( false )
                .enableAntialiasing( true ).spacing( 0 ).onRender( new OnRenderListener() {
            @Override
            public void onInitiallyRendered(int nbPages, float pageWidth, float pageHeight) {
                mPDFView.fitToWidth();
                mPDFView.documentFitsView();
                mPDFView.setSwipeVertical( true );
            }
        } ).onPageChange( new OnPageChangeListener() {
            @Override
            public void onPageChanged(int page, int pageCount) {
                mPDFView.setSwipeVertical( true );
                mPDFView.canScrollVertically( pageCount );
            }
        } ).onLoad( new OnLoadCompleteListener() {
            @Override
            public void loadComplete(int nbPages) {
                final ProgressDialog progressDialog = new ProgressDialog(MathematicsTopicsDisplayActivity.this,
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
                        }, 3000);
            }
        } ).load();
    }

    private void viewPdf() {
        switch (position){
            case 0:/*
                mPDFView.fromAsset("Number Base.pdf")
                        .load();*/
                attachFromUri( Uri.parse( "eeretret" ) );
                break;
            case 1:
                attachFromAssets("Fractions, Decimals and Approximation.pdf");
//                mPDFView.fromAsset("Fractions, Decimals and Approximation.pdf").enableSwipe(true).swipeHorizontal(true).load();
                break;
            case 2:
                mPDFView.fromAsset("Indices and Logarithm.pdf").enableSwipe(true).swipeHorizontal(true).load();
                break;
            case 3:
                mPDFView.fromAsset("Series and Sequence.pdf").enableSwipe(true).swipeHorizontal(true).load();
                break;
            case 4:
                mPDFView.fromAsset("Set theory.pdf").enableSwipe(true).swipeHorizontal(true).load();
                break;
            case 5:
                mPDFView.fromAsset("Surds.pdf").enableSwipe(true).swipeHorizontal(true).load();
                break;
            case 6:
                mPDFView.fromAsset("Matrices.pdf").enableSwipe(true).swipeHorizontal(true).load();
                break;
            case 7:
                mPDFView.fromAsset("Variation.pdf").enableSwipe(true).swipeHorizontal(true).load();
                break;
            case 8:
                mPDFView.fromAsset("Algebra.pdf").enableSwipe(true).swipeHorizontal(true).load();
                break;
            case 9:
                mPDFView.fromAsset("Mensuration.pdf").enableSwipe(true).swipeHorizontal(true).load();
                break;
            case 10:
                mPDFView.fromAsset("Trigonometry.pdf").enableSwipe(true).swipeHorizontal(true).load();
                break;
            case 11:
                mPDFView.fromAsset("Calculus.pdf")
                        .enableSwipe(true)
                        .swipeHorizontal(true)
                        .load();
                break;
            case 12:
                mPDFView.fromAsset("Statistics.pdf").enableSwipe(true).swipeHorizontal(true).load();
                break;
            case 13:
                mPDFView.fromAsset("Probability.pdf").enableSwipe(true).swipeHorizontal(true).load();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}