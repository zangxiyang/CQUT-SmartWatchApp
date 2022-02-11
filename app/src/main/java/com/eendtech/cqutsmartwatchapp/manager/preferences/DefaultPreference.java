package com.eendtech.cqutsmartwatchapp.manager.preferences;


import android.content.Context;

public class DefaultPreference implements IPreference {

    protected String TAG;


    private ISharePreferences sharePreferences;

    public DefaultPreference(Context context){
        sharePreferences = new BasePreference(context, getPreferenceName());
        // 默认为当前的类名为TAG, TAG的具体用途详见源码
        TAG = getClass().getSimpleName();
    }

    public String getPreferenceName() {
        return TAG;
    }

    @Override
    public ISharePreferences getPreferences() {
        return sharePreferences;
    }

    @Override
    public void commit() {
        getPreferences().commit();
    }

    @Override
    public void clear() {
        getPreferences().clear().commit();
    }

    @Override
    public void remove(String key) {
        getPreferences().remove(key).commit();
    }
}
