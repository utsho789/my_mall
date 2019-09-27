package com.example.mymall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button loginButton,signUpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loginButton = findViewById(R.id.logInButtonId);
        signUpButton = findViewById(R.id.signUpButtonId);

        loginButton.setOnClickListener(this);
        signUpButton.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

            if(view.getId()==R.id.logInButtonId){


                Intent intent = new Intent(MainActivity.this,SignInActivity.class);
                startActivity(intent);
            }

            else if(view.getId()==R.id.signUpButtonId){


                Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intent);
            }


    }
}
