package com.jiggy.relifeassignment.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.jiggy.relifeassignment.R;

import static com.jiggy.relifeassignment.activities.MainActivity.startMain;
import static com.jiggy.relifeassignment.activities.RegistrationActivity.startRegi;

public class LoginActivity extends AppCompatActivity {


    private static final String TAG = "LoginActivity";

    EditText etMobileNo, etPswd;

    public static void startLogin(Context context) {
        Intent starter = new Intent(context, LoginActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etMobileNo = findViewById(R.id.et_mobile_no);
        etPswd = findViewById(R.id.et_pswd);


    }

    public void callLogin(View view) {
        String mobileNo = etMobileNo.getText().toString();
        String pswd = etPswd.getText().toString();

        if (TextUtils.isEmpty(mobileNo)) {
            etMobileNo.setError("Enter Mobile Number");
            etMobileNo.requestFocus();
        } else if (mobileNo.length() != 10) {
            etMobileNo.setError("Invalid Mobile Number");
            etMobileNo.requestFocus();
        } else if (TextUtils.isEmpty(pswd)) {
            etPswd.setError("Enter Password");
            etPswd.requestFocus();
        } else {
            startMain(LoginActivity.this);
            finish();

        }


    }

    public void callRegi(View view) {
        startRegi(LoginActivity.this);
        finish();

    }
}