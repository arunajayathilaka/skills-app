package com.app.salpo.skillzapp.login;

import android.os.Bundle;
import android.view.View;

/**
 * Created by imalkariyawasam on 8/24/17.
 */

public interface LoginView {

    public void onLoginClick(View view);

    public void onForgotPasswordClick(View view);

    public void saveToken(String token);

    public void directToHome();

    public void loginFail(String msg);

    public void displayToast(String msg);


}
