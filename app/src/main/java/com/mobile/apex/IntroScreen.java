package com.mobile.apex;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.text.Html;
import android.widget.Button;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class IntroScreen extends AppCompatActivity {

    PreferenceManager preferenceManager;
    LinearLayout Layout_bars;
    TextView[] bottomBars;
    int[] screens;
    Button Skip, Next;
    ViewPager vp;
    MyViewPagerAdapter myvpAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_screen);

        /* Calling Intialization function */

//        init();
        vp = (ViewPager) findViewById(R.id.view_pager);
        Layout_bars = (LinearLayout) findViewById(R.id.layoutBars);
        Skip = (Button) findViewById(R.id.skip);
        Next = (Button) findViewById(R.id.next);

        // Creating an array contains the introduction screens.
        screens = new int[]{
                R.layout.intro_screen1,
                R.layout.intro_screen3,
                R.layout.intro_screen2,
        };
        myvpAdapter = new MyViewPagerAdapter();
        vp.setAdapter(myvpAdapter);
        preferenceManager = new PreferenceManager(this);
        vp.addOnPageChangeListener(viewPagerPageChangeListener);
        // Checking the Preference Manager if the app is not running for the first time.
        if (!preferenceManager.FirstLaunch()) {
            launchMain();
            finish();
        }
        ColoredBars(0);
    }
    /* Upon clicking next, check if the view is the last */
    public void next(View v) {
        int i = getItem(+1);
        if (i < screens.length) {
            vp.setCurrentItem(i);
        } else {
            launchMain();
        }
    }
    /* Start the app and skip the introduction */
    public void skip(View view) {
        launchMain();
    }
    /* Introduction pager indicator */
    private void ColoredBars(int thisScreen) {
        // defining color resources for the active pager and the inactive.
        int colorsInactive = getResources().getColor(R.color.grey_500);
        int colorsActive = getResources().getColor(R.color.white);
        bottomBars = new TextView[screens.length];
        // removing the layout elements if there is.
        Layout_bars.removeAllViews();
        // looping through the pager.
        for (int i = 0; i < bottomBars.length; i++) {
            bottomBars[i] = new TextView(this);
            bottomBars[i].setTextSize(45);
            bottomBars[i].setText(Html.fromHtml("&#9673"));
            Layout_bars.addView(bottomBars[i]);
            bottomBars[i].setTextColor(colorsInactive);
        }
        if (bottomBars.length > 0)
            bottomBars[thisScreen].setTextColor(colorsActive);
    }
    // getting the size of the view
    private int getItem(int i) {
        return vp.getCurrentItem() + i;
    }
    // start the app
    private void launchMain() {
        // set preference to false
        preferenceManager.setFirstTimeLaunch(false);
        // creating an intent to start the next activity
        startActivity(new Intent(this, RegistrationActivity.class));
        finish();
    }
    // Onpager listener for the viewpager
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            // set the color to the view indicators.
            ColoredBars(position);
            // setting a text to the button, and visibility.
            if (position == screens.length - 1) {
                Next.setText("Let's Continue");
                Skip.setVisibility(View.GONE);
            } else {
                Next.setText(getString(R.string.next));
                Skip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater inflater;

        public MyViewPagerAdapter() {
        }
        // Populating the viewpager to inflate the viewpager views.
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(screens[position], container, false);
            container.addView(view);
            return view;
        }
        // getting the pager size
        @Override
        public int getCount() {
            return screens.length;
        }
        // removing the views int the container
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View v = (View) object;
            container.removeView(v);
        }
        // Confirming the views
        @Override
        public boolean isViewFromObject(View v, Object object) {
            return v == object;
        }
    }
}