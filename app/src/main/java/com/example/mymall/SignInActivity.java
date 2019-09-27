package com.example.mymall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout linearLayout;
    private Button login44Button,loginWithFacebookButton;
    private EditText emailorPhoneEditTextId,password44444Id;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mAuth = FirebaseAuth.getInstance();

        login44Button = findViewById(R.id.logInButtonSignInId4444);
        loginWithFacebookButton = findViewById(R.id.logInButtonWithFbSignInId);

        emailorPhoneEditTextId = findViewById(R.id.emailorPhoneSignINEditID);
        password44444Id = findViewById(R.id.editTextPassWordSignInID444);


        login44Button.setOnClickListener(this);
        loginWithFacebookButton.setOnClickListener(this);


        linearLayout = findViewById(R.id.linearLayoutId222);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);

                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
            }
        });
    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.logInButtonSignInId4444){


            String phorEmail = emailorPhoneEditTextId.getText().toString().trim();
            String pas44 = password44444Id.getText().toString().trim();

            if(phorEmail.isEmpty()){
                emailorPhoneEditTextId.setError("Enter an Email Or Phone Number");
                emailorPhoneEditTextId.requestFocus();
                return;

            }

            else if(!Patterns.EMAIL_ADDRESS.matcher(phorEmail).matches()){

                emailorPhoneEditTextId.setError("Enter an Valid Email Address :");
                emailorPhoneEditTextId.requestFocus();
                return;

            }


            if(pas44.isEmpty()){


                password44444Id.setError("Enter a Password : ");
                password44444Id.requestFocus();
                return;





            }
            else if(pas44.length()<6){

                password44444Id.setError("Minimum length of a Passord Shuold be 6 :");
                password44444Id.requestFocus();
                return;

            }

            mAuth.signInWithEmailAndPassword(phorEmail,pas44).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()){

                        Intent intent = new Intent(SignInActivity.this,ShopActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);

                    }
                    else{

                        Toast.makeText(getApplicationContext(),task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                    }

                }
            });









        }



        else if(view.getId()==R.id.logInButtonWithFbSignInId){

            Intent intent = new Intent(SignInActivity.this,FaceBookActivty.class);
            startActivity(intent);


        }



    }


}
