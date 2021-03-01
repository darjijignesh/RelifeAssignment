package com.jiggy.relifeassignment.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jiggy.relifeassignment.R;

import static com.jiggy.relifeassignment.activities.MainActivity.startMain;

public class LoginActivity extends AppCompatActivity {


    private static final String TAG = "LoginActivity";

    EditText etMobileNo,etPswd;


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
            View view1 = etMobileNo;
            etMobileNo.setError("Enter Mobile Number");
            view1.requestFocus();
        } else if (mobileNo.length() != 10) {
            View view1 = etMobileNo;
            etMobileNo.setError("Invalid Mobile Number");
            view1.requestFocus();
        } else if (TextUtils.isEmpty(pswd)) {
            View view1 = etPswd;
            etMobileNo.setError("Enter Password");
            view1.requestFocus();
        } else {
            startMain(LoginActivity.this);
            finish();

        }



    }
}