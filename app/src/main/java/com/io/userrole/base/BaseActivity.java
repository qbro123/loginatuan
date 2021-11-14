package com.io.userrole.base;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.io.userrole.database.AppDatabase;
import com.io.userrole.database.DatabaseImp;

public class BaseActivity extends AppCompatActivity {

    public AppDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = DatabaseImp.getInstance(this);
    }

    public void showMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public <T> void navigate(Class<T> name) {
        startActivity(new Intent(this, name));
    }
}
