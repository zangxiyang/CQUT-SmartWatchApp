package com.eendtech.cqutsmartwatchapp.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.eendtech.cqutsmartwatchapp.R;
import com.eendtech.cqutsmartwatchapp.constant.BaseConstant;
import com.eendtech.cqutsmartwatchapp.manager.preferences.PreferenceManager;
import com.eendtech.cqutsmartwatchapp.timer.SendSmsCodeTimer;
import com.gyf.immersionbar.ImmersionBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.btn_sendSmsCode)
    Button btn_sendSmsCode;

    // 更改界面状态标签
    @BindView(R.id.tv_changeType)
    TextView tv_changeType;

    // 验证码栏
    @BindView(R.id.cv_verifyCode)
    CardView cv_verifyCode;


    // 生成定时器
    SendSmsCodeTimer sendSmsCodeTimer;

    private int submitFlag = BaseConstant.Login.POST_TYPE_REGISTER.getVal();

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
        // 对当前APP和登录状态进行判断
        if (PreferenceManager.getInstance().getAppPreference().getAppInfo().isFirstUse() || !PreferenceManager.getInstance().getUserPreferences().getUserInfo().isLogin()){
            // 如果当前为第一次使用APP 或者 没有登录的状态下则默认为注册
            // 进行注册界面初始化
            registerViewInit();
        } else{
            // 否则为登录界面
            submitFlag = BaseConstant.Login.POST_TYPE_LOGIN.getVal();
            // 进行登录界面初始化
            loginViewInit();
        }
    }

    @OnClick(R.id.btn_sendSmsCode)
    void onBtnSendSmsCodeClick() {
        sendSmsCodeTimer = new SendSmsCodeTimer(60, 1, btn_sendSmsCode);
        sendSmsCodeTimer.start();
    }

    @OnClick(R.id.tv_changeType)
    void onTvChangeTypeClick(){
        if (submitFlag == BaseConstant.Login.POST_TYPE_LOGIN.getVal()){
            // 如果是登录状态, 则切换为注册状态
            submitFlag = BaseConstant.Login.POST_TYPE_REGISTER.getVal();
            registerViewInit();
        } else{
            // 如果是注册状态, 则切换为登录状态
            submitFlag = BaseConstant.Login.POST_TYPE_LOGIN.getVal();
            loginViewInit();
        }
    }

    /**
     * 登录界面初始化
     */
    private void loginViewInit(){
        // 隐藏验证码栏
        cv_verifyCode.setVisibility(View.GONE);
        // 切换更改状态标签
        tv_changeType.setText(R.string.login_tv_changeRegisterType);
    }

    /**
     * 注册界面初始化
     */
    private void registerViewInit(){
        // 显示验证码栏
        cv_verifyCode.setVisibility(View.VISIBLE);
        // 切换更改状态标签
        tv_changeType.setText(R.string.login_tv_changeLoginType);
    }


}