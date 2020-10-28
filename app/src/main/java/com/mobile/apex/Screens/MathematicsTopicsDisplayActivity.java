package com.mobile.apex.Screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;
import com.mobile.apex.NoItemInternetImage;
import com.mobile.apex.R;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;

import javax.net.ssl.HttpsURLConnection;

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
            case 0:
                new LoadPdf().execute("https://www.cimt.org.uk/projects/mepres/book9/bk9_1.pdf");
                break;
            case 1:
                new LoadPdf().execute("https://mathcircle.berkeley.edu/sites/default/files/BMC5/docpspdf/fractions.pdf");
                break;
            case 2:
                new LoadPdf().execute("https://www.tcd.ie/Economics/staff/ppwalsh/T4.pdf");
                break;
            case 3:
                new LoadPdf().execute("https://ncert.nic.in/textbook/pdf/kemh109.pdf");
                break;
            case 4:
                new LoadPdf().execute("https://people.cs.pitt.edu/~milos/courses/cs441/lectures/Class7.pdf");
                break;
            case 5:
                new LoadPdf().execute("https://www.schurzhs.org/ourpages/auto/2015/9/6/44741179/Chapter%205%20Indices%20and%20Surds%20pg_%2096%20-%20135.pdf");
                break;
            case 6:
                new LoadPdf().execute("https://ncert.nic.in/ncerts/l/leep203.pdf");
                break;
            case 7:
                new LoadPdf().execute("https://www.lcps.org/cms/lib4/VA01000195/Centricity/Domain/619/Direct_and_Inverse_Variation%20worksheet.pdf");
                break;
            case 8:
                new LoadPdf().execute("https://www.bradford.ac.uk/wimba-files/msu-course/media/algebra%20&%20linear%20teaching.pdf");
                break;
            case 9:
                new LoadPdf().execute("https://www.haesemathematics.com/media/W1siZiIsIjIwMTUvMDMvMTkvNHdsM2JtbXlidF9pZ2NzZV9lcGdfdDYucGRmIl1d/igcse_epg_t6.pdf?sha=ac201ad3730f1fc7");
                break;
            case 10:
                new LoadPdf().execute("https://users.auth.gr/~siskakis/GelfandSaul-Trigonometry.pdf");
                break;
            case 11:
                new LoadPdf().execute("https://www.sydney.edu.au/content/dam/students/documents/mathematics-learning-centre/introduction-to-differential-calculus.pdf");
                break;
            case 12:
                new LoadPdf().execute("https://www.anderson5.net/cms/lib02/SC01001931/Centricity/Domain/2147/Additional%20Measures%20of%20Central%20Tendency%20and%20Dispersion%20including%20variance%20notes.pdf");
                break;
            case 13:
                new LoadPdf().execute("https://www.cimt.org.uk/projects/mepres/allgcse/bka5.pdf");
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
    class LoadPdf extends AsyncTask<String, Void, InputStream> {

        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;
            try {
                URL url = new URL(strings[0]);
                HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                if (urlConnection.getResponseCode()== 200){
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }

            } catch (IOException e) {
                return null;
            }
            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            mPDFView.fromStream(inputStream).enableDoubletap( true ).enableSwipe(true).enableDoubletap( true )
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
    }
}