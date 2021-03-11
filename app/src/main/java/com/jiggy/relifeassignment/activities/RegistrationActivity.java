package com.jiggy.relifeassignment.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jiggy.relifeassignment.R;

import static com.jiggy.relifeassignment.activities.LoginActivity.startLogin;

public class RegistrationActivity extends AppCompatActivity {

    private static final String TAG = "RegistrationActivity";
    public static void startRegi(Context context) {
        Intent starter = new Intent(context, RegistrationActivity.class);
        context.startActivity(starter);
    }

    EditText etFname,etLName,etMobile,etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        etFname = findViewById(R.id.et_f_name);
        etLName = findViewById(R.id.et_l_name);
        etMobile = findViewById(R.id.et_mobile_no);
        etEmail = findViewById(R.id.et_email);




    }

    public void callRegi(View view) {
        String strFname = etFname.getText().toString();
        String strLName = etLName.getText().toString();
        String strMobile = etMobile.getText().toString();
        String strEmail = etEmail.getText().toString();

        if (TextUtils.isEmpty(strFname)) {
            etFname.requestFocus();
            etFname.setError("Enter Your First Name");
        } else if (TextUtils.isEmpty(strLName)) {
            etLName.requestFocus();
            etLName.setError("Enter Your Last Name");
        } else if (TextUtils.isEmpty(strMobile)) {
            etMobile.requestFocus();
            etMobile.setError("Enter Your Mobile No.");
        } else if (strMobile.length() != 10) {
            etMobile.requestFocus();
            etMobile.setError("Invalid Mobile No.");
        }else if (TextUtils.isEmpty(strEmail)) {
            etEmail.requestFocus();
            etEmail.setError("Enter Your Email-Id .");
        } else if (!Patterns.EMAIL_ADDRESS.matcher(strEmail).matches()) {
            etEmail.requestFocus();
            etEmail.setError("Enter Your Email-Id .");
        } else {
            Toast.makeText(this, "Regi Done", Toast.LENGTH_SHORT).show();
        }





    }



    public void callLogin(View view) {

        startLogin(RegistrationActivity.this);
        finish();

    }
}