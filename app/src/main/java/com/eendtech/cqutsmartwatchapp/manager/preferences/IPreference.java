package com.eendtech.cqutsmartwatchapp.manager.preferences;

public interface IPreference {
    ISharePreferences getPreferences();

    void commit();

    void clear();

    void remove(String key);
}
