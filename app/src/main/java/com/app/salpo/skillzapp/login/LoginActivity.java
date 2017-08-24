package com.app.salpo.skillzapp.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.TextInputEditText;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.app.salpo.skillzapp.home.HomeActivity;
import com.app.salpo.skillzapp.R;
import com.app.salpo.skillzapp.model.Data;
import com.app.salpo.skillzapp.model.LoginResponse;
import com.app.salpo.skillzapp.rest.APIClient;
import com.app.salpo.skillzapp.rest.APIInterface;


import retrofit2.Call;
import retrofit2.Callback;

import static android.support.design.R.id.wrap_content;


public class LoginActivity extends AppCompatActivity implements LoginView {

    private String mEmail, mPassword;
    TextInputEditText mEmailText, mPasswordText;
    TextView mLoginFailText;

    LoginPresenterImp loginPresenterImp;

    public SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmailText = (TextInputEditText) findViewById(R.id.input_email);
        mPasswordText = (TextInputEditText) findViewById(R.id.input_password);
        mLoginFailText = (TextView) findViewById(R.id.login_fail_text);

        mSharedPreferences = getSharedPreferences("basicPref",
                Context.MODE_PRIVATE);

        loginPresenterImp = new LoginPresenterImp(this);
    }

    public void onLoginClick(View view) {
        mEmail = mEmailText.getText().toString();
        mPassword = mPasswordText.getText().toString();
        mPasswordText.setText("");
        loginPresenterImp.verifyLogin(mEmail, mPassword);
    }

    public void onForgotPasswordClick(View view) {

    }

    public void saveToken(String token){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("token", token);
        editor.commit();
    }

    public void directToHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void loginFail(String msg){
        mLoginFailText.setText(msg);
        ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) mLoginFailText.getLayoutParams();
        params.height = wrap_content;
        mLoginFailText.setLayoutParams(params);
    }

    public void displayToast(String msg) {
        Toast.makeText(this, "Something went wrong\n"+msg+"\nPlease try again.", Toast.LENGTH_LONG).show();
    }


}
