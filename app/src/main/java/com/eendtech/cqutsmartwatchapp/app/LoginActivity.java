package com.eendtech.cqutsmartwatchapp.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.eendtech.cqutsmartwatchapp.R;
import com.eendtech.cqutsmartwatchapp.timer.SendSmsCodeTimer;
import com.gyf.immersionbar.ImmersionBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.btn_sendSmsCode)
    Button btn_sendSmsCode;
    // 生成定时器
    SendSmsCodeTimer sendSmsCodeTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    /**
     * 初始化配置
     */
    private void init() {
        // 初始化三方库
        ButterKnife.bind(this);
        ImmersionBar.with(this)
                .statusBarDarkFont(true)
                .transparentStatusBar()
                .init();
    }

    @OnClick(R.id.btn_sendSmsCode)
    void onBtnSendSmsCodeClick() {
        sendSmsCodeTimer = new SendSmsCodeTimer(60, 1, btn_sendSmsCode);
        sendSmsCodeTimer.start();
    }


}