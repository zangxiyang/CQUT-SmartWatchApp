package com.eendtech.cqutsmartwatchapp.manager.preferences;

import android.content.SharedPreferences;

import java.util.Set;

public interface ISharePreferences {
    SharedPreferences.Editor putString(String key, String value);

    SharedPreferences.Editor putStringSet(String key, Set<String> values);

    SharedPreferences.Editor putInt(String key, int value);

    SharedPreferences.Editor putLong(String key, long value);

    SharedPreferences.Editor putFloat(String key, float value);

    SharedPreferences.Editor putBoolean(String key, boolean value);

    SharedPreferences.Editor remove(String key);

    SharedPreferences.Editor clear();

    boolean commit();

    void apply();

    String getString(String key, String defValue);
    Set<String> getStringSet(String key);
    Boolean getBoolean(String key);
    int getInt(String key);
    Float getFloat(String key);
    long getLong(String key);

}
