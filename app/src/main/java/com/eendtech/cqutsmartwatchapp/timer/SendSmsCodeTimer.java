package com.eendtech.cqutsmartwatchapp.timer;

import android.os.CountDownTimer;
import android.widget.Button;

import com.eendtech.cqutsmartwatchapp.R;


public class SendSmsCodeTimer extends CountDownTimer {

    private Button button;

    public SendSmsCodeTimer(long secondsInFuture, long countDownIntervalBySeconds, Button button) {
        super(secondsInFuture * 1000, countDownIntervalBySeconds);
        this.button = button;
    }

    @Override
    public void onTick(long l) {
        button.setEnabled(false);
        button.setText(l / 1000 +"秒");

    }

    @Override
    public void onFinish() {
        button.setEnabled(true);
        button.setText(R.string.login_tv_sendSmsCode);
    }
}
