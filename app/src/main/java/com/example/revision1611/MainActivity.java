package com.example.revision1611;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.revision1611.databinding.ActivityMainBinding;
import com.example.revision1611.databinding.LoginBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //привязка к view
        LoginBinding binding = LoginBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        SharedPreferences mPref;
        mPref = getPreferences(MODE_PRIVATE);
        LoginPresenter presenter = new LoginPresenter(this, binding, mPref);

        if(presenter.signInPref()){
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }

        binding.signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(presenter.signin()){
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(intent);
                };
            }
        });


    }
}