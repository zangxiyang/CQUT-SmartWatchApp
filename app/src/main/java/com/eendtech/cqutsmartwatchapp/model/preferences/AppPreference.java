package com.eendtech.cqutsmartwatchapp.model.preferences;

import android.content.Context;

import com.eendtech.cqutsmartwatchapp.manager.preferences.DefaultPreference;
import com.eendtech.cqutsmartwatchapp.model.base.AppInfoModel;
import com.google.gson.Gson;

public class AppPreference extends DefaultPreference {

    public final static String KEY_APP_INFO = "cqut_app_info";
    private Gson gson = new Gson();


    public AppPreference(Context context) {
        super(context);
    }


    public AppPreference setAppInfo(AppInfoModel appInfo){
        // 通过json进行保存
        getPreferences()
                .putString(KEY_APP_INFO, gson.toJson(appInfo))
                .commit();
        return this;
    }

    public AppInfoModel getAppInfo(){
        AppInfoModel appInfoModel = new AppInfoModel()
                .setFirstUse(true);
        return gson.fromJson(getPreferences().getString(KEY_APP_INFO, gson.toJson(appInfoModel)),AppInfoModel.class);
    }
}
