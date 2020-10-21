package com.mobile.apex;

import androidx.appcompat.app.AlertDialog;
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

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;

import javax.net.ssl.HttpsURLConnection;

public class ChemistryTopicsDisplayActivity extends AppCompatActivity {
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
                final ProgressDialog progressDialog = new ProgressDialog(ChemistryTopicsDisplayActivity.this,
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
                new LoadPdf().execute("https://batch.libretexts.org/print/url=https://chem.libretexts.org/Courses/Palomar_College/PC%3A_CHEM100_-_Fundamentals_of_Chemistry/01%3A_The_Chemical_World.pdf");
                break;
            case 1:
                new LoadPdf().execute("https://ncerthelp.com/cbse%20notes/class%2011/chemistry/CH%202%20Structure%20of%20Atom.pdf");
                break;
            case 2:
                new LoadPdf().execute("https://chemguide.net/wp-content/uploads/2017/11/Separationtechniques_y9.pdf");
                break;
            case 3:
                new LoadPdf().execute("https://nios.ac.in/media/documents/313courseE/L5.pdf");
                break;
            case 4:
                new LoadPdf().execute("https://learning.hccs.edu/faculty/gong.chen/chem1411/course-materials/03_Lecture.pdf");
                break;
            case 5:
                new LoadPdf().execute("https://www.chem.uwec.edu/Chem101_S01/Pages/Lecturenotes/C101_notes06.pdf");
                break;
            case 6:
                new LoadPdf().execute("https://nios.ac.in/media/documents/secscicour/English/Chapter-8.pdf");
                break;
            case 7:
                new LoadPdf().execute("https://nios.ac.in/media/documents/secscicour/English/Chapter-28.pdf");
                break;
            case 8:
                new LoadPdf().execute("https://www.ou.ac.lk/home/images/OER/pdf/Chemistry/English/Periodic%20Table.pdf");
                break;
            case 9:
                new LoadPdf().execute("https://www.millerplace.k12.ny.us/site/handlers/filedownload.ashx?moduleinstanceid=367&dataid=1456&FileName=08-kinetics_and_equilibrium.pdf");
                break;
            case 10:
                new LoadPdf().execute("https://www.mioy.org/uploads/1/3/9/1/13912136/heats_of_reaction.pdf");
                break;
            case 11:
                new LoadPdf().execute("https://ncert.nic.in/textbook/pdf/kech201.pdf");
                break;
            case 12:
                new LoadPdf().execute("https://chemrevise.files.wordpress.com/2018/12/4-3-quantitative-chemistry.pdf");
                break;
            case 13:
                new LoadPdf().execute("https://www.researchgate.net/profile/Olga_Evtifeyeva/publication/301527607_Analytical_chemistry_Qualitative_analysis_Part_I_The_manual_for_students_of_higher_schools_O_A_Ievtifieieva_V_V_Bolotov_T_A_Kostina_O_M_Svechnikova_T_I_Yuschenko_N_I_Kaminska_A_E_Kosareva_L_V_Slobodya/links/5717762f08aefb153f9ee997/Analytical-chemistry-Qualitative-analysis-Part-I-The-manual-for-students-of-higher-schools-O-A-Ievtifieieva-V-V-Bolotov-T-A-Kostina-O-M-Svechnikova-T-I-Yuschenko-N-I-Kaminska-A-E-Kosareva-L-V-S.pdf");
                break;
            case 14:
                new LoadPdf().execute("https://www.sepa.org.uk/media/120465/mtc_chem_of_air_pollution.pdf");
                break;
            case 15:
                new LoadPdf().execute("https://parkdee.files.wordpress.com/2011/02/chapter-5-water-and-solutions-doc.pdf");
                break;
            case 16:
                new LoadPdf().execute("https://batch.libretexts.org/print/url=https://chem.libretexts.org/Bookshelves/General_Chemistry/Book%3A_Chemistry_(OpenSTAX)/18%3A_Representative_Metals_Metalloids_and_Nonmetals/18.09%3A_Occurrence_Preparation_and_Compounds_of_Oxygen.pdf");
                break;
            case 17:
                new LoadPdf().execute("https://batch.libretexts.org/print/url=https://chem.libretexts.org/Bookshelves/General_Chemistry/Book%3A_Chemistry_(OpenSTAX)/18%3A_Representative_Metals_Metalloids_and_Nonmetals/18.05%3A_Occurrence_Preparation_and_Compounds_of_Hydrogen.pdf");
                break;
            case 18:
                new LoadPdf().execute("https://batch.libretexts.org/print/url=https://chem.libretexts.org/Bookshelves/General_Chemistry/Book%3A_Chemistry_(OpenSTAX)/18%3A_Representative_Metals_Metalloids_and_Nonmetals/18.11%3A_Occurrence_Preparation_and_Properties_of_Halogens.pdf");
                break;
            case 19:
                new LoadPdf().execute("https://batch.libretexts.org/print/url=https://chem.libretexts.org/Bookshelves/General_Chemistry/Book%3A_Chemistry_(OpenSTAX)/18%3A_Representative_Metals_Metalloids_and_Nonmetals/18.07%3A_Occurrence_Preparation_and_Properties_of_Nitrogen.pdf");
                break;
            case 20:
                new LoadPdf().execute("https://dseshyd.gos.pk/Downloads/ch14.pdf");
                break;
            case 21:
                new LoadPdf().execute("https://igcse.at.ua/IGCSE/Chemistry/docbrownnotes/ORGANIC-CHEMISTRY.pdf");
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
                    final ProgressDialog progressDialog = new ProgressDialog(ChemistryTopicsDisplayActivity.this,
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