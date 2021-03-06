package com.eendtech.cqutsmartwatchapp.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.eendtech.cqutsmartwatchapp.Application;
import com.eendtech.cqutsmartwatchapp.R;
import com.eendtech.cqutsmartwatchapp.manager.preferences.PreferenceManager;
import com.eendtech.cqutsmartwatchapp.model.base.UserModel;
import com.eendtech.cqutsmartwatchapp.model.preferences.UserPreference;
import com.gyf.immersionbar.ImmersionBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        test();

    }

    /**
     * 初始化三方库及组件
     */
    private void init() {

        // 初始化三方库
        ButterKnife.bind(this);
        ImmersionBar.with(this)
                .statusBarDarkFont(true)
                .transparentStatusBar()
                .init();
        // 组件初始化
        tvTitle.setText("测试设置");
    }

    /**
     * 进行前置权限判定,没有登录则调转到登录界面
     */

    private void preAuth() {

    }

    @OnClick(R.id.tv_title)
    void onTvTitleClick(){
        finish();
        System.exit(0);
    }

    /**
     * 测试
     */
    private void test() {
        UserPreference userPreference = PreferenceManager.getInstance().getUserPreferences();
        userPreference.setUserInfo(new UserModel().setUserName("测试姓名").setLogin(true));
        tvTitle.setText(userPreference.getUserInfo().getUserName());

        Intent intent = new Intent();
        intent.setClass(this,LoginActivity.class);
        startActivity(intent);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, Application.FIRST_START_FLAG == 1? "刷数据":"不刷数据",Toast.LENGTH_LONG).show();
    }
}