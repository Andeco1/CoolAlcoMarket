package com.example.revision1611;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.revision1611.databinding.LoginBinding;

public class LoginPresenter {
    private static String TRUEPASSWORD = "1234";
    private static String TRUELOGIN = "1234";
    private LoginBinding binding;
    private Context context;
    private SharedPreferences mPref;
    public LoginPresenter(Context context, LoginBinding binding, SharedPreferences mPref) {
        this.binding = binding;
        this.context = context;
        this.mPref = mPref;
    }

    public boolean signInPref(){
        String loginPref=  mPref.getString("Login","");
        String passwordPref = mPref.getString("Password","");
        if(loginPref.equals(TRUELOGIN) && passwordPref.equals(TRUEPASSWORD)) {
            return true;
        }
        return false;
    }
    public boolean signin(){
        SharedPreferences.Editor edit = mPref.edit();

        String login = binding.login.getText().toString();
        String password =  binding.password.getText().toString();

        if(login.equals(TRUELOGIN) && password.equals(TRUEPASSWORD)){
            edit.putString("Login",login);
            edit.putString("Password",password);

            edit.commit();
            return true;
        }
        return false;

    }
}
