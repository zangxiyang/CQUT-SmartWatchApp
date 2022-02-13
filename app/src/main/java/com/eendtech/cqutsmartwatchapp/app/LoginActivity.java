package com.eendtech.cqutsmartwatchapp.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.eendtech.cqutsmartwatchapp.R;
import com.eendtech.cqutsmartwatchapp.constant.BaseConstant;
import com.eendtech.cqutsmartwatchapp.manager.preferences.PreferenceManager;
import com.eendtech.cqutsmartwatchapp.timer.SendSmsCodeTimer;
import com.eendtech.cqutsmartwatchapp.utils.PhoneCheckUtil;
import com.eendtech.cqutsmartwatchapp.utils.StringUtil;
import com.gyf.immersionbar.ImmersionBar;
import com.hjq.toast.ToastUtils;

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

    // 手机号
    @BindView(R.id.et_phoneNumber)
    EditText et_phoneNumber;

    // 密码
    @BindView(R.id.et_passWord)
    EditText et_passWord;

    // 验证码
    @BindView(R.id.et_registerCode)
    EditText et_registerCode;


    // 生成定时器
    SendSmsCodeTimer sendSmsCodeTimer;

    // 请求类型标识: 登录 or 注册
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

    /**
     * 发送验证码按钮被点击
     */
    @OnClick(R.id.btn_sendSmsCode)
    void onBtnSendSmsCodeClick() {

        // 进行前置判断
        if (StringUtil.isNotBlank(et_phoneNumber.getText().toString(), et_passWord.getText().toString())
                && PhoneCheckUtil.isPhoneLegal(et_phoneNumber.getText().toString())){
            // 如果当前不为空且手机号正则通过
            // TODO 发送验证码进行注册
            sendSmsCodeTimer = new SendSmsCodeTimer(60, 1, btn_sendSmsCode);
            sendSmsCodeTimer.start();

        } else{
            Toast.makeText(this,"内容不能为空且手机号必须输入正确!",Toast.LENGTH_LONG).show();

        }

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