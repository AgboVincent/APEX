package com.mobile.apex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class MathematicsTopicsDisplayActivity extends AppCompatActivity {
    PDFView mPDFView;
    int position = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.courses_lesson);
        mPDFView = findViewById(R.id.pdfView);
        position = getIntent().getIntExtra("position", -1);
        viewPdf();



    }

    private void viewPdf() {
    switch (position){
        case 0:
            mPDFView.fromAsset("Number Base.pdf").enableSwipe(true).swipeHorizontal(true).load();
            break;
        case 1:
            mPDFView.fromAsset("Fractions, Decimals and Approximation.pdf").enableSwipe(true).swipeHorizontal(true).load();
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
}