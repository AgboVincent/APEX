package com.mobile.apex;

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

public class PhysicsTopicsDisplay extends AppCompatActivity {
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
                final ProgressDialog progressDialog = new ProgressDialog(PhysicsTopicsDisplay.this,
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
                new LoadPdf().execute("https://www.nust.na/sites/default/files/documents/Chapter%205_Properties%20and%20Structure%20of%20Matter.pdf");
                break;
            case 1:
                new LoadPdf().execute("https://jwolffphilosophy.files.wordpress.com/2018/02/wolff_fundamental-quantities.pdf");
                break;
            case 2:
                new LoadPdf().execute("https://batch.libretexts.org/print/url=https://phys.libretexts.org/Bookshelves/University_Physics/Book%3A_University_Physics_(OpenStax)/Map%3A_University_Physics_I_-_Mechanics_Sound_Oscillations_and_Waves_(OpenStax)/03%3A_Motion_Along_a_Straight_Line/3.02%3A_Position%2C_Displacement%2C_and_Average_Velocity.pdf");
                break;
            case 3:
                new LoadPdf().execute("https://batch.libretexts.org/print/url=https://phys.libretexts.org/Bookshelves/College_Physics/Book%3A_College_Physics_(OpenStax)/11%3A_Fluid_Statics/11.01%3A_What_Is_a_Fluid.pdf");
                break;
            case 4:
                new LoadPdf().execute("https://batch.libretexts.org/print/url=https://phys.libretexts.org/Bookshelves/University_Physics/Book%3A_University_Physics_(OpenStax)/Map%3A_University_Physics_I_-_Mechanics_Sound_Oscillations_and_Waves_(OpenStax)/14%3A_Fluid_Mechanics/14.02%3A_Fluids%2C_Density%2C_and_Pressure_(Part_1).pdf");
                break;
            case 5:
                new LoadPdf().execute("https://batch.libretexts.org/print/url=https://phys.libretexts.org/Bookshelves/Classical_Mechanics/Book%3A_Classical_Mechanics_(Tatum)/16%3A_Hydrostatics/16.07%3A_Archimedes'_Principle.pdf");
                break;
            case 6:
                new LoadPdf().execute("https://batch.libretexts.org/print/url=https://phys.libretexts.org/Bookshelves/Classical_Mechanics/Book%3A_Classical_Mechanics_(Tatum)/16%3A_Hydrostatics/16.09%3A_Floating_Bodies.pdf");
                break;
            case 7:
                new LoadPdf().execute("https://batch.libretexts.org/print/url=https://phys.libretexts.org/Bookshelves/Classical_Mechanics/Supplemental_Modules_(Classical_Mechanics)/Motion.pdf");
                break;
            case 8:
                new LoadPdf().execute("https://batch.libretexts.org/print/url=https://phys.libretexts.org/Bookshelves/College_Physics/Book%3A_College_Physics_(OpenStax)/16%3A_Oscillatory_Motion_and_Waves/16.06%3A__Uniform_Circular_Motion_and_Simple_Harmonic_Motion.pdf");
                break;
            case 9:
                new LoadPdf().execute("https://batch.libretexts.org/print/url=https://phys.libretexts.org/Bookshelves/University_Physics/Book%3A_Physics_(Boundless)/2%3A_Kinematics/2.2%3A_Speed_and_Velocity.pdf");
                break;
            case 10:
                new LoadPdf().execute("https://batch.libretexts.org/print/url=https://phys.libretexts.org/Bookshelves/College_Physics/Book%3A_College_Physics_(OpenStax)/02%3A_Kinematics/2.04%3A_Acceleration.pdf\n");
                break;
            case 11:
                new LoadPdf().execute("https://ww2.odu.edu/~jdudek/Phys111N_materials/4_circular_motion_gravity.pdf");
                break;
            case 12:
                new LoadPdf().execute("https://batch.libretexts.org/print/url=https://phys.libretexts.org/Bookshelves/University_Physics/Book%3A_University_Physics_(OpenStax)/Map%3A_University_Physics_I_-_Mechanics_Sound_Oscillations_and_Waves_(OpenStax)/02%3A_Vectors/2.02%3A_Scalars_and_Vectors_(Part_1).pdf");
                break;
            case 13:
                new LoadPdf().execute("https://batch.libretexts.org/print/url=https://phys.libretexts.org/Bookshelves/University_Physics/Book%3A_Physics_(Boundless)/8%3A_Static_Equilibrium%2C_Elasticity%2C_and_Torque/8.2%3A_Conditions_for_Equilibrium.pdf");
                break;
            case 14:
                new LoadPdf().execute("https://batch.libretexts.org/print/url=https://phys.libretexts.org/Bookshelves/University_Physics/Book%3A_University_Physics_I_-_Classical_Mechanics_(Gea-Banacloche)/11%3A_Simple_Harmonic_Motion/11.02%3A_Simple_Harmonic_Motion.pdf");
                break;
            case 15:
                new LoadPdf().execute("https://batch.libretexts.org/print/url=https://phys.libretexts.org/Bookshelves/University_Physics/Book%3A_Mechanics_and_Relativity_(Idema)/02%3A_Forces/2.01%3A_Newton's_Laws_of_Motion.pdf");
                break;
            case 16:
                new LoadPdf().execute("https://batch.libretexts.org/print/url=https://phys.libretexts.org/Bookshelves/Classical_Mechanics/Supplemental_Modules_(Classical_Mechanics)/Miscellaneous_Classical_Mechanics_Topics/Energy.pdf");
                break;
            case 17:
            case 19:
                new LoadPdf().execute("https://batch.libretexts.org/print/url=https://phys.libretexts.org/Bookshelves/University_Physics/Book%3A_Introductory_Physics_-_Building_Models_to_Describe_Our_World_(Martin_Neary_Rinaldo_and_Woodman)/08%3A_Potential_Energy_and_Conservation_of_Energy/8.03%3A_Mechanical_Energy_and_Conservation_of_Energy.pdf");
                break;
            case 18:
                new LoadPdf().execute("https://batch.libretexts.org/print/url=https://phys.libretexts.org/Bookshelves/College_Physics/Book%3A_College_Physics_(OpenStax)/07%3A_Work_Energy_and_Energy_Resources/7.02%3A_Kinetic_Energy_and_the_Work-Energy_Theorem.pdf");
                break;
            case 20:
                new LoadPdf().execute("https://batch.libretexts.org/print/url=https://phys.libretexts.org/Bookshelves/University_Physics/Book%3A_University_Physics_(OpenStax)/Map%3A_University_Physics_I_-_Mechanics_Sound_Oscillations_and_Waves_(OpenStax)/07%3A_Work_and_Kinetic_Energy/7.05%3A_Power.pdf");
                break;
            case 21:
                new LoadPdf().execute("https://batch.libretexts.org/print/url=https://phys.libretexts.org/Bookshelves/University_Physics/Book%3A_Calculus-Based_Physics_(Schnick)/Volume_A%3A_Kinetics_Statics_and_Thermodynamics/35A%3A_Temperature_Internal_Energy_Heat_and_Specific_Heat_Capacity.pdf");
                break;
                case 22:
                new LoadPdf().execute("https://batch.libretexts.org/print/url=https://phys.libretexts.org/Courses/Joliet_Junior_College/Physics_201_-_Fall_2019v2/Book%3A_Custom_Physics_textbook_for_JJC/12%3A_Temperature_and_Kinetic_Theory/12.01%3A_Temperature_and_Heat/Heat_Transfer%2C_Specific_Heat%2C_and_Calorimetry.pdf");
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
                    final ProgressDialog progressDialog = new ProgressDialog(PhysicsTopicsDisplay.this,
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