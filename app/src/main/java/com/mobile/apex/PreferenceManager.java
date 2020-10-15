package com.mobile.apex;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor spEditor;
    Context context;
    private static final String FIRST_LAUNCH = "firstLaunch";
    int MODE = 0;
    private static final String PREFERENCE = "Apex";

    @SuppressLint("CommitPrefEdits")
    public PreferenceManager(Context context) {
        this.context = context;
        // getting the sharedPreference
        sharedPreferences = context.getSharedPreferences(PREFERENCE, MODE);
        // editing the sharedPreference
        spEditor = sharedPreferences.edit();
    }
    // checking if the app is running for the first time
    public void setFirstTimeLaunch(boolean isFirstTime) {
        spEditor.putBoolean(FIRST_LAUNCH, isFirstTime);
        spEditor.commit();
    }

    public boolean FirstLaunch() {
        return sharedPreferences.getBoolean(FIRST_LAUNCH, true);
    }

}
