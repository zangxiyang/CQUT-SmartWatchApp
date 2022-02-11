package com.eendtech.cqutsmartwatchapp.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.eendtech.cqutsmartwatchapp.R;
import com.eendtech.cqutsmartwatchapp.manager.preferences.PreferenceManager;
import com.eendtech.cqutsmartwatchapp.model.base.UserModel;
import com.eendtech.cqutsmartwatchapp.model.preferences.UserPreference;
import com.gyf.immersionbar.ImmersionBar;

import butterknife.BindView;
import butterknife.ButterKnife;

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

    /**
     * 测试
     */
    private void test() {
        UserPreference userPreference = PreferenceManager.getInstance().getUserPreferences();
        userPreference.setUserInfo(new UserModel().setUserName("测试姓名").setLogin(true));
        tvTitle.setText(userPreference.getUserInfo().getUserName());


    }
}