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

public class BiologyTopicsDisplayActivity extends AppCompatActivity {
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
                final ProgressDialog progressDialog = new ProgressDialog(BiologyTopicsDisplayActivity.this,
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
                new LoadPdf().execute("https://ncert.nic.in/ncerts/l/kebo102.pdf");
                break;
            case 1:
                new LoadPdf().execute("https://nios.ac.in/media/documents/SrSec314NewE/Lesson-03.pdf");
                break;
            case 2:
                new LoadPdf().execute("https://batch.libretexts.org/print/url=https://bio.libretexts.org/Bookshelves/Introductory_and_General_Biology/Book%3A_General_Biology_(Boundless)/1%3A_The_Study_of_Life/1.2%3A_Themes_and_Concepts_of_Biology/1.2B%3A_Levels_of_Organization_of_Living_Things.pdf\n");
                break;
            case 3:
                new LoadPdf().execute("https://ncert.nic.in/ncerts/l/kebo108.pdf");
                break;
            case 4:
                new LoadPdf().execute("https://snra.academy/wp-content/uploads/2020/03/diffusion-osmosis-and-active-transport.pdf");
                break;
            case 5:
                new LoadPdf().execute("https://learn.mindset.africa/sites/default/files/resourcelib/emshare-show-note-asset/1591_fdoc.pdf");
                break;
            case 6:
                new LoadPdf().execute("https://www.pearson.com/content/dam/one-dot-com/one-dot-com/us/en/higher-ed/en/products-services/course-products/fremgen-6e-info/pdf/Sample_ch04_final.pdf");
                break;
            case 7:
                new LoadPdf().execute("https://etutoring.gayazahs.sc.ug/uploads/ebooks/1350536451.pdf");
                break;
            case 8:
                new LoadPdf().execute("https://learn.mindset.africa/sites/default/files/resourcelib/emshare-show-note-asset/1597_fdoc.pdf");
                break;
            case 9:
                new LoadPdf().execute("https://nios.ac.in/media/documents/srsec314newE/PDFBIO.EL12.pdf");
                break;
            case 10:
                new LoadPdf().execute("https://cals.arizona.edu/classes/ans215/lectures/RespiratorySystemXII.pdf");
                break;
            case 11:
                new LoadPdf().execute("https://parkdee.files.wordpress.com/2011/02/chapter-3-excretion-doc2.pdf");
                break;
            case 12:
                new LoadPdf().execute("https://resources.saylor.org/wwwresources/archived/site/wp-content/uploads/2010/11/Homeostasis-Overview.pdf");
                break;
            case 13:
                new LoadPdf().execute("https://nios.ac.in/media/documents/srsec314newE/PDFBIO.EL16.pdf");
                break;
            case 14:
                new LoadPdf().execute("https://www.soinc.org/sites/default/files/uploaded_files/4-17_SENSES_HANDOUT.pdf");
                break;
            case 15:
                new LoadPdf().execute("https://cms.coronadousd.net/static/media/uploads/Coronado%20Middle%20School/7thGradeScience.HIV.AIDS/Chapter%2013.pdf");
                break;
            case 16:
                new LoadPdf().execute("https://ncert.nic.in/textbook/pdf/gesc101.pdf");
                break;
            case 17:
                new LoadPdf().execute("https://ncert.nic.in/textbook/pdf/gesc102.pdf");
                break;
            case 18:
                new LoadPdf().execute("https://www.dphu.org/uploads/attachements/books/books_2314_0.pdf");
                break;
            case 19:
                new LoadPdf().execute("https://ncert.nic.in/ncerts/l/jesc109.pdf");
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
                    final ProgressDialog progressDialog = new ProgressDialog(BiologyTopicsDisplayActivity.this,
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