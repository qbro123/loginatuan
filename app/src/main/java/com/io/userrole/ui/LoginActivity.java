package com.io.userrole.ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;

import com.io.userrole.MainActivity;
import com.io.userrole.R;
import com.io.userrole.base.BaseActivity;
import com.io.userrole.database.DatabaseImp;
import com.io.userrole.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        binding.btnLogin.setOnClickListener(v -> {
            //check empty
            if (binding.edtUser.getText().toString().equals("") ||
                    binding.edtPassword.getText().toString().equals("")) {
                showMsg("khong duoc de trong");
                return;
            }
            if (db.userDao().findByName(binding.edtUser.getText().toString()) == null) {
                showMsg("tai khoan khong ton tai");
                return;
            }
            if (db.userDao().login(
                    binding.edtUser.getText().toString(),
                    binding.edtPassword.getText().toString()
            ) != null) {
                showMsg("dang nhap thanh cong");
                navigate(MainActivity.class);
                finish();
            } else {
                showMsg("mat khau khong dung");
            }
        });
    }
}