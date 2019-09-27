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
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    private EditText signUpNameEdit,phoneSignUpEdit,signUpEmailEdit,signUPPassEdit;
    private Button signUpButton;

    private LinearLayout linearLayout;
    FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();


        linearLayout = findViewById(R.id.linearLayoutId);


        signUpNameEdit = findViewById(R.id.editTextFullNameSignUPID);
        phoneSignUpEdit = findViewById(R.id.editTexPhoneNumberSignUPID);
        signUpEmailEdit = findViewById(R.id.editTeEmailAddressSignUPID);
        signUPPassEdit = findViewById(R.id.editTextPassWordSignUPID1234);


        signUpButton = findViewById(R.id.signUp2ndddddId);



        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mAuth.getCurrentUser()!=null){

                }else{

                }


               signUPREgister();


            }

            private void signUPREgister() {

                    final String name = signUpNameEdit.getText().toString();
                    final String phone = phoneSignUpEdit.getText().toString();
                    final String email = signUpEmailEdit.getText().toString();
                    final String pass = signUPPassEdit.getText().toString();


                    if (name.isEmpty()) {


                        signUpNameEdit.setError("Enter an Email Address : ");
                        signUpNameEdit.requestFocus();
                        return;


                    } else if (phone.isEmpty()) {


                        phoneSignUpEdit.setError("ENter An phone Number");
                        phoneSignUpEdit.requestFocus();
                        return;

                    }


                    if (email.isEmpty()) {


                        signUpEmailEdit.setError("Enter an Email Address : ");
                        signUpEmailEdit.requestFocus();
                        return;


                    } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

                        signUpEmailEdit.setError("Enter an Valid Email Address :");
                        signUpEmailEdit.requestFocus();
                        return;

                    }


                    if (pass.isEmpty()) {


                        signUPPassEdit.setError("Enter a Password : ");
                        signUPPassEdit.requestFocus();
                        return;


                    } else if (pass.length() < 6) {

                        signUPPassEdit.setError("Minimum length of a Passord Shuold be 6 :");
                        signUPPassEdit.requestFocus();
                        return;

                    }


                    mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {

                                Usercom usercom = new Usercom(name, phone, email, pass);
                                FirebaseDatabase.getInstance().getReference("usercom").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(usercom).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {


                                        if(task.isSuccessful()){

                                            Toast.makeText(SignUpActivity.this, "RegisterSuccesFully", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                                            startActivity(intent);

                                        }else{
                                            Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                                        }

                                    }
                                });

                            } else {
                                Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });





            }
        });

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);


            }
        });







    }



}
