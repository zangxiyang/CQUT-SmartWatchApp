package com.eendtech.cqutsmartwatchapp.manager.preferences;

import android.content.Context;

import com.eendtech.cqutsmartwatchapp.model.preferences.AppPreference;
import com.eendtech.cqutsmartwatchapp.model.preferences.UserPreference;

public class PreferenceManager {
    // 采用单例模式,防止多次加载导致数据不统一
    private static volatile PreferenceManager instance;

    private UserPreference userPreference;
    private AppPreference appPreference;

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

    public AppPreference getAppPreference() {
        return appPreference;
    }

    private void setUserPreferences(UserPreference userPreference) {
        this.userPreference = userPreference;
    }

    public void initPreferences(Context context) {
        userPreference = new UserPreference(context);
        appPreference = new AppPreference(context);
    }

}
