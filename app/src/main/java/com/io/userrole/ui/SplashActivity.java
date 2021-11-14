package com.io.userrole.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.io.userrole.R;
import com.io.userrole.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler(Looper.getMainLooper()).postAtTime(() -> {
            navigate(LoginActivity.class);
            finish();
        }, 2000);
    }
}