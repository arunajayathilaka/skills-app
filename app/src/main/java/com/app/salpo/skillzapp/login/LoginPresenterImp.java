package com.app.salpo.skillzapp.login;


import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.salpo.skillzapp.User;
import com.app.salpo.skillzapp.home.HomeActivity;
import com.app.salpo.skillzapp.model.Data;
import com.app.salpo.skillzapp.model.LoginResponse;
import com.app.salpo.skillzapp.rest.APIClient;
import com.app.salpo.skillzapp.rest.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;

import static android.support.design.R.id.wrap_content;

/**
 * Created by imalkariyawasam on 8/24/17.
 */

public class LoginPresenterImp implements LoginPresenter {
    APIInterface mApiInterface;
    String mToken;
    LoginView loginView;

    public LoginPresenterImp(LoginView loginView) {
       this.loginView = loginView;
    }

    public void verifyLogin(String email, String password) {
        mApiInterface = APIClient.getClient().create(APIInterface.class);

        User user = new User(email, password);

        Call<LoginResponse> callLogin = mApiInterface.createUser(user);
        callLogin.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, retrofit2.Response<LoginResponse> response) {
                LoginResponse session = response.body();
                Boolean success = session.getSuccess();
                if(success) {
                    Data sessionData = session.getData();
                    mToken = sessionData.getToken();
                    loginView.saveToken(mToken);
                    loginView.directToHome();
                } else {
                    String msg = session.getMsg();
                    loginView.loginFail(msg);
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                call.cancel();
                String failMsg = t.getMessage();
                loginView.displayToast(failMsg);

            }
        });
    }











}
