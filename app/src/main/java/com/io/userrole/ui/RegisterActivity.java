package com.io.userrole.ui;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.io.userrole.base.BaseActivity;
import com.io.userrole.databinding.ActivityRegisterBinding;
import com.io.userrole.model.User;

public class RegisterActivity extends BaseActivity {

    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        binding.btnRegister.setOnClickListener(v -> {
            //check validate empty
            if (binding.edtPassword.getText().toString().equals("") ||
                    binding.edtUser.getText().toString().equals("")) {
                showMsg("khong duoc de trong");
                return;
            }
            //check validate password and re pass
            if (!binding.edtPassword.getText().toString().equals(binding.edtRePassword.getText().toString())) {
                showMsg("mk khong trung nhau");
                return;
            }
            //check validate user exits
            if (db.userDao().findByName(binding.edtUser.getText().toString()) != null) {
                showMsg("tai khoan da ton tai");
            } else {
                db.userDao().insert(new User(binding.edtUser.getText().toString(),
                        binding.edtPassword.getText().toString(), 0, "user"));
                showMsg("dang ky thanh cong");
                finish();
            }
        });
    }
}