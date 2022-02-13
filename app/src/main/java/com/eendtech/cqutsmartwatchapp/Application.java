package com.eendtech.cqutsmartwatchapp;

import android.util.Log;
import android.widget.Toast;

import com.eendtech.cqutsmartwatchapp.manager.preferences.PreferenceManager;
import com.eendtech.cqutsmartwatchapp.model.base.AppInfoModel;
import com.hjq.toast.ToastUtils;

public class Application extends android.app.Application {

    public static int FIRST_START_FLAG = 0; // 0 为不刷数据(不是第一次启动),1 为刷数据(第一次启动,刷数据到磁盘中)

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Application", "onCreate: Application类被创建");
        init();
        appFirstStartEvent();

    }

    /**
     * 进行初始化
     */
    private void init() {
        // 初始化 Toast 框架
        ToastUtils.init(this);
        // 缓存管理初始化
        PreferenceManager.getInstance().initPreferences(this);

    }

    /**
     * 应用第一次启动
     */
    private void appFirstStartEvent() {
        AppInfoModel appInfoModel = PreferenceManager.getInstance().getAppPreference().getAppInfo();
        if (appInfoModel.isFirstUse()) {
            // 是第一次启动 标识赋值,应用结束时刷数据
            this.FIRST_START_FLAG = 1;
            Toast.makeText(this,"是第一次启动",Toast.LENGTH_LONG).show();
            // ... 逻辑代码


        } else {
            // 不是第一次启动
            Toast.makeText(this,"不是第一次启动",Toast.LENGTH_LONG).show();

        }

    }

}
