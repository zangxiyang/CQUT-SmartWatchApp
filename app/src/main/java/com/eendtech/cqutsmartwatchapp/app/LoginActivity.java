package com.eendtech.cqutsmartwatchapp.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.eendtech.cqutsmartwatchapp.R;
import com.gyf.immersionbar.ImmersionBar;

import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    /**
     * 初始化配置
     */
    private void init(){
        // 初始化三方库
        ButterKnife.bind(this);
        ImmersionBar.with(this)
                .statusBarDarkFont(true)
                .transparentStatusBar()
                .init();
    }
}