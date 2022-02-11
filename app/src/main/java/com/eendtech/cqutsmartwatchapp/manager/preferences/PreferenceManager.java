package com.eendtech.cqutsmartwatchapp.manager.preferences;

import android.content.Context;

import com.eendtech.cqutsmartwatchapp.model.preferences.UserPreference;

public class PreferenceManager {
    private static volatile PreferenceManager instance;

    private UserPreference userPreference;

    public static PreferenceManager getInstance() {
        if (instance == null) {
            synchronized (PreferenceManager.class) {
                if (instance == null) {
                    instance = new PreferenceManager();
                }
            }
        }
        return instance;
    }

    public UserPreference getUserPreferences() {
        return userPreference;
    }

    private void setUserPreferences(UserPreference userPreference) {
        this.userPreference = userPreference;
    }

    public void initPreferences(Context context) {
        PreferenceManager.getInstance().setUserPreferences(new UserPreference(context));
    }

}
