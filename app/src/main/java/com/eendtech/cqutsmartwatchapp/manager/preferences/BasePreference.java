package com.eendtech.cqutsmartwatchapp.manager.preferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

public class BasePreference implements ISharePreferences{
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public BasePreference(Context context, String name) {
        sharedPreferences = context.getSharedPreferences(name, Activity.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    @Override
    public SharedPreferences.Editor putString(String key, String value) {
        return editor.putString(key,value);
    }

    @Override
    public SharedPreferences.Editor putStringSet(String key, Set<String> values) {
        return editor.putStringSet(key,values);
    }

    @Override
    public SharedPreferences.Editor putInt(String key, int value) {
        return editor.putInt(key,value);
    }

    @Override
    public SharedPreferences.Editor putLong(String key, long value) {
        return editor.putLong(key,value);
    }

    @Override
    public SharedPreferences.Editor putFloat(String key, float value) {
        return editor.putFloat(key,value);
    }

    @Override
    public SharedPreferences.Editor putBoolean(String key, boolean value) {
        return editor.putBoolean(key, value);
    }

    @Override
    public SharedPreferences.Editor remove(String key) {
        return editor.remove(key);
    }

    @Override
    public SharedPreferences.Editor clear() {
        return editor.clear();
    }

    @Override
    public boolean commit() {
        return editor.commit();
    }

    @Override
    public void apply() {
        editor.apply();
    }

    @Override
    public String getString(String key, String defValue) {
        return sharedPreferences.getString(key,defValue);
    }

    @Override
    public Set<String> getStringSet(String key) {
        return sharedPreferences.getStringSet(key, null);
    }

    @Override
    public Boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    @Override
    public int getInt(String key) {
        return sharedPreferences.getInt(key, -1);
    }

    @Override
    public Float getFloat(String key) {
        return sharedPreferences.getFloat(key, -1L);
    }

    @Override
    public long getLong(String key) {
        return sharedPreferences.getLong(key, -1L);
    }

}
