package com.eendtech.cqutsmartwatchapp;

import android.util.Log;

import com.eendtech.cqutsmartwatchapp.manager.preferences.PreferenceManager;
import com.eendtech.cqutsmartwatchapp.model.base.AppInfoModel;

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Application", "onCreate: Application类被创建");
        PreferenceManager.getInstance().initPreferences(this);
    }

    /**
     * 应用第一次启动
     */
    private void appFirstStartEvent(){
        AppInfoModel appInfoModel = PreferenceManager.getInstance().getAppPreference().getAppInfo();
        if (appInfoModel.isFirstUse()){
            // 是第一次启动
        }else{
            // 不是第一次启动
        }

    }
}
