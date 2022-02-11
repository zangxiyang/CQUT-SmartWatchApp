package com.eendtech.cqutsmartwatchapp;

import android.util.Log;

import com.eendtech.cqutsmartwatchapp.manager.preferences.PreferenceManager;

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Application", "onCreate: Application类被创建");
        PreferenceManager.getInstance().initPreferences(this);
    }
}
